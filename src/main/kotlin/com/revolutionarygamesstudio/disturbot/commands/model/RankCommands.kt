package com.revolutionarygamesstudio.disturbot.commands.model

import com.revolutionarygamesstudio.disturbot.commands.base.IRankCommands
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.channel.Channel
import discord4j.core.`object`.entity.channel.MessageChannel
import discord4j.core.event.domain.message.MessageCreateEvent

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
class RankCommands : IRankCommands {
    override fun onRankCommand(channel: MessageChannel, user: Member, target: String?) {
    }
}