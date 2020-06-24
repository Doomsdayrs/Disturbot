package com.revolutionarygamesstudio.disturbot.commands.base

import com.revolutionarygamesstudio.disturbot.commands.base.base.IClockExecutor
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 09 / 06 / 2020
 */
interface IReportCommands : IClockExecutor {
    fun onReportCommand(channel: MessageChannel, user: Member, messageLink: String?)
}