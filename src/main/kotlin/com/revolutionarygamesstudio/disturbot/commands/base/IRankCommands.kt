package com.revolutionarygamesstudio.disturbot.commands.base

import com.revolutionarygamesstudio.disturbot.common.obj.ClockedCommand
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
interface IRankCommands : IClockExecutor {
    /**
     * Allows the user to view their current rank
     */
    @ClockedCommand(
        ["rank", "rank?", "stage", "stage?"],
        "Shows you your current rank. Include another user to get their info"
    )
    fun onRankCommand(channel: MessageChannel, user: Member, target: String?)
}