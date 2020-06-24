package com.revolutionarygamesstudio.disturbot.commands.model

import com.revolutionarygamesstudio.disturbot.commands.base.IVoteCommands
import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 09 / 06 / 2020
 */
class VoteCommands:IVoteCommands {
    override fun onCreateVoteCommand(
        channel: MessageChannel,
        user: Member,
        message: Message,
        pollTitle: String,
        pollDesc: String,
        options: String,
        schedule: String
    ) {
        TODO("Not yet implemented")
    }

    override fun onEndVoteCommand(channel: MessageChannel, user: Member, message: Message, pollID: String) {
        TODO("Not yet implemented")
    }

    override fun onDeleteVoteCommand(channel: MessageChannel, user: Member, pollID: String) {
        TODO("Not yet implemented")
    }

    override fun onResultVoteCommand(channel: MessageChannel, user: Member, pollID: String) {
        TODO("Not yet implemented")
    }
}