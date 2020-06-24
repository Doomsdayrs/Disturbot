package com.revolutionarygamesstudio.disturbot.commands.model

import com.revolutionarygamesstudio.disturbot.commands.base.IReportCommands
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 09 / 06 / 2020
 */
class ReportCommands : IReportCommands {
    override fun onReportCommand(channel: MessageChannel, user: Member, messageLink: String?) {
    }
}