package com.revolutionarygamesstudio.disturbot.handler.base

import com.revolutionarygamesstudio.disturbot.commands.base.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.domain.SimpleCommand
import discord4j.core.event.domain.message.MessageCreateEvent

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * Interface for a command handler
 */
interface IClockedCommandHandler {
    fun registerCommands(list: List<IClockExecutor>)
    fun isMessageACommand(messageContent: String): Boolean
    fun getCommandByMessage(commandName: String):SimpleCommand?
    fun executeCommand(messageCreateEvent: MessageCreateEvent)
    fun getCommands(): List<SimpleCommand>

    /**
     * Instruction to clear commands, canceling all jobs
     */
    fun clearCommands()
}