package com.revolutionarygamesstudio.disturbot.handler.base

import com.revolutionarygamesstudio.disturbot.commands.base.IClockExecutor
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
    fun executeCommand(messageCreateEvent: MessageCreateEvent)

    /**
     * Instruction to clear commands, canceling all jobs
     */
    fun clearCommands()
}