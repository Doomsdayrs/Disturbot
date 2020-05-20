package com.revolutionarygamesstudio.disturbot.handler.base

import discord4j.core.event.domain.message.MessageCreateEvent

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
interface ClockedCommandHandler {
    fun isMessageACommand(messageContent: String): Boolean
    fun executeCommand(messageCreateEvent: MessageCreateEvent)
}