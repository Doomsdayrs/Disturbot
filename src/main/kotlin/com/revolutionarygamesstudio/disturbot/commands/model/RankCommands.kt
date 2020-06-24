package com.revolutionarygamesstudio.disturbot.commands.model

import com.revolutionarygamesstudio.disturbot.commands.base.IRankCommands
import com.revolutionarygamesstudio.disturbot.commands.base.base.ClockedCommand
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
class RankCommands : IRankCommands {
    @ClockedCommand(
        ["rank", "rank?", "stage", "stage?"],
        "Shows you your current rank. Include another user to get their info"
    )
    override fun onRankCommand(channel: MessageChannel, user: Member, target: String?) {
    }
}