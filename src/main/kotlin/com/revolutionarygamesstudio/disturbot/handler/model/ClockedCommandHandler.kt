package com.revolutionarygamesstudio.disturbot.handler.model

import com.revolutionarygamesstudio.disturbot.commands.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.common.consts.myID
import com.revolutionarygamesstudio.disturbot.common.obj.ClockedCommand
import com.revolutionarygamesstudio.disturbot.domain.SimpleCommand
import com.revolutionarygamesstudio.disturbot.handler.base.IClockedCommandHandler
import discord4j.core.event.domain.message.MessageCreateEvent
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberFunctions

/**
 * disturbot
 * 21 / 05 / 2020
 */
class ClockedCommandHandler : IClockedCommandHandler {
    companion object {
        private const val PREFIX = "~db"
        private const val PREFIX_LEN = PREFIX.length
    }

    val commands = arrayListOf<SimpleCommand>()

    @ExperimentalStdlibApi
    override fun registerCommands(list: List<IClockExecutor>) {
        commands.clear()
        list.forEach { executor ->
            executor::class.memberFunctions.filter { it.hasAnnotation<ClockedCommand>() }.forEach {
                commands.add(SimpleCommand(it.findAnnotation()!!, it, executor))
            }
        }
    }

    override fun isMessageACommand(messageContent: String): Boolean {
        println("Processing message $messageContent")

        // Checks if the length is valid
        if (messageContent.length <= PREFIX_LEN) return false

        // Checks if the prefix is present in where it should be
        if (!messageContent.subSequence(0, PREFIX_LEN).contains(PREFIX, true)) return false

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
            it.method.call(getParameters(splitMessage, it, messageCreateEvent))
        } ?: println("")
    }

    /**
     * Returns a list of parameters for a function
     */
    private fun getParameters(
        splitMessage: List<String>,
        command: SimpleCommand,
        event: MessageCreateEvent
    ): Array<Any?> {
        val arrayList = arrayListOf<Any?>()
        val method = command.method
        val parms = method.parameters
        val message = event.message
        var usedMessagePart = 0

        val channel = message.channel.block()

        channel?.let {
            parms.forEach {
                arrayList.add(
                    when (it.type::class) {
                        String::class -> {
                            if (usedMessagePart < splitMessage.size) {
                                val i = usedMessagePart
                                usedMessagePart++
                                splitMessage[i]
                            } else null
                        }

                        else -> null
                    }
                )
            }
        }
        TODO("Handle the command processor")
        return arrayOf()
    }
}