package com.revolutionarygamesstudio.disturbot.commands.base

import com.revolutionarygamesstudio.disturbot.commands.base.base.IClockExecutor
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 22 / 05 / 2020
 */
interface IHelpCommand : IClockExecutor {
    fun onHelpCommand(channel: MessageChannel, question: String?)
}