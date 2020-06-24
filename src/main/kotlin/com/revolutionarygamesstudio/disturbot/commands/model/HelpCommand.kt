package com.revolutionarygamesstudio.disturbot.commands.model

import com.revolutionarygamesstudio.disturbot.commands.base.IHelpCommand
import com.revolutionarygamesstudio.disturbot.commands.base.base.ClockedCommand
import com.revolutionarygamesstudio.disturbot.handler.base.IClockedCommandHandler
import discord4j.core.`object`.entity.channel.MessageChannel
import java.awt.Color
import java.awt.Color.BLUE

/**
 * disturbot
 * 22 / 05 / 2020
 */
class HelpCommand(
    private val iClockedCommandHandler: IClockedCommandHandler
) : IHelpCommand {
    @ClockedCommand(["help"], "Shows command info, append a command to know what it does")
    override fun onHelpCommand(channel: MessageChannel, question: String?) {
        val message = StringBuilder()
        if (question != null) {
            if (iClockedCommandHandler.isMessageACommand(question.toLowerCase())) {
                val command = iClockedCommandHandler.getCommandByMessage(question)!!
                channel.createEmbed {
                    with(it) {
                        setTitle(command.annotation.aliases.contentToString())
                        setDescription(command.annotation.description)
                        setColor(Color.BLUE.rgb)
                    }
                }
            } else {
                channel.createEmbed {
                    with(it) {
                        setTitle("Error")
                        setDescription("I did not find such a command, did you mistype?")
                        setColor(Color.RED.rgb)
                    }
                }
            }
        } else {
            val commands = iClockedCommandHandler.getCommands()
            commands.forEachIndexed { index, it ->
                with(it.annotation) {
                    message.append(aliases.contentToString()).append("\n\t").append(description)
                    if (index < commands.size - 1)
                        message.append("\n====\n")
                }
            }
            channel.createEmbed {
                with(it) {
                    setTitle("Help")
                    setDescription("This is a list of commands")
                    setColor(BLUE.rgb)
                    addField("Commands", message.toString(), false)
                }
            }
        }.block()
    }
}