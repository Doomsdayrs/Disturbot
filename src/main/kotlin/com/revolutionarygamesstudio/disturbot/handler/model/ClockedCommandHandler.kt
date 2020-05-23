package com.revolutionarygamesstudio.disturbot.handler.model

import com.revolutionarygamesstudio.disturbot.commands.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.common.consts.myID
import com.revolutionarygamesstudio.disturbot.common.ext.logID
import com.revolutionarygamesstudio.disturbot.common.obj.ClockedCommand
import com.revolutionarygamesstudio.disturbot.common.utils.Log
import com.revolutionarygamesstudio.disturbot.domain.SimpleCommand
import com.revolutionarygamesstudio.disturbot.handler.base.IClockedCommandHandler
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.discordjson.json.UserData
import kotlin.reflect.KParameter
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions
import kotlin.reflect.full.hasAnnotation

/**
 * disturbot
 * 21 / 05 / 2020
 */
class ClockedCommandHandler : IClockedCommandHandler {
    companion object {
        private const val PREFIX = "d~"
        private const val PREFIX_LEN = PREFIX.length
        private var messageCount = 0
    }

    val commands = arrayListOf<SimpleCommand>()

    val commandNotations: MutableMap<Array<String>, String> = hashMapOf()

    @ExperimentalStdlibApi
    override fun registerCommands(list: List<IClockExecutor>) {
        commands.clear()
        Log.d(logID(), "Processing ${list.size} executor(s)")
        list.forEach { executor ->
            Log.d(logID(), "Checking executor: ${executor.logID()}")
            executor::class.functions.filter { it.hasAnnotation<ClockedCommand>() }.forEach { function ->
                val annotation = function.findAnnotation<ClockedCommand>()!!
                Log.d(logID(), "Registering command: ${annotation.aliases.contentToString()}")
                commands.add(SimpleCommand(annotation, function, executor, executor))
                commandNotations[annotation.aliases.map { it.toLowerCase() }.toTypedArray()] = annotation.description
            }
        }
    }

    override fun isMessageACommand(messageContent: String): Boolean {
        if (commands.isEmpty()) {
            Log.e(logID(), "No commands present")
            return false
        }
        val id = messageCount
        messageCount++
        Log.i(logID(), "Processing message $messageCount [$messageContent]")

        // Checks if the length is valid
        if (messageContent.length <= PREFIX_LEN) return false

        // Checks if the prefix is present in where it should be
        if (!messageContent.subSequence(0, PREFIX_LEN).contains(PREFIX, true)) return false

        Log.d(logID(), "Message $messageCount is a command, continuing if relevant")

        // Checks if this 'command' is real
        val command = messageContent.split(" ")
        if (commandNotations.none { it.key.contains(command[0].removePrefix(PREFIX).toLowerCase()) }) return false

        Log.d(logID(), "Message $messageCount is a recognized command, dispatching")

        return true
    }

    override fun executeCommand(messageCreateEvent: MessageCreateEvent) {
        val message = messageCreateEvent.message
        val author = message.author.get()
        val id = author.id.asLong()
        if (id == myID) {
            println("Message is by me")
            return
        }

        if (author.isBot) {
            println("${author.id} = bot")
            return
        }

        val splitMessage = message.content.trim().split(" ")
        val commandName = splitMessage[0].removePrefix(PREFIX)
        commands.find { it.annotation.aliases.contains(commandName) }?.let {
            try {
                val i = it.method.parameters.size
                val received = getParameters(splitMessage, it, messageCreateEvent)
                Log.d(logID(), "$i vs ${received.size}")
                it.method.callBy(received)
            } catch (e: IllegalArgumentException) {
                Log.e(logID(), "An exception occurred on attempt to call $commandName: ${e.message}")
            }
        } ?: println("")
    }

    /**
     * Returns a list of parameters for a function
     */
    private fun getParameters(
        splitMessage: List<String>,
        command: SimpleCommand,
        event: MessageCreateEvent
    ): Map<KParameter, Any?> {
        val hashMap = hashMapOf<KParameter, Any?>()
        val method = command.method
        val methodName = method.name
        val params = method.parameters
        val message = event.message
        var usedMessagePart = 1

        message.channel.block()?.let { channel ->
            params.forEach { kParameter ->
                Log.i(logID(), "$methodName requires param ${kParameter.index} of ${kParameter.type}")
                if (kParameter.index == 0) {
                    hashMap[kParameter] = command.CLASS
                } else
                    hashMap[kParameter] = when (kParameter.type) {
                        String::class -> {
                            if (usedMessagePart < splitMessage.size) {
                                val i = usedMessagePart
                                usedMessagePart++
                                splitMessage[i]
                            } else null
                        }
                        MessageCreateEvent::class -> event
                        MessageChannel::class -> channel
                        Message::class -> message
                        UserData::class -> message.userData
                        else -> {
                            if (kParameter.type.isMarkedNullable) null
                            else when (kParameter.type.toString()) {
                                "discord4j.core.`object`.entity.channel.MessageChannel" -> channel
                                else -> throw IllegalArgumentException("Cannot apply null for such")
                            }
                        }
                    }
            }
        }
        Log.d(logID(), "Size ${hashMap.size}")
        return hashMap
    }
}