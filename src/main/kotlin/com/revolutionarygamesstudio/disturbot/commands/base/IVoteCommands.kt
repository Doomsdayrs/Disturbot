package com.revolutionarygamesstudio.disturbot.commands.base

import discord4j.core.`object`.entity.Member
import discord4j.core.`object`.entity.Message
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 09 / 06 / 2020
 */
interface IVoteCommands {

    // TODO Create vote, Can be scheduled
    /**
     * Creates a vote
     * @param user Must be a moderator with certain perms
     * @param pollTitle The title of the poll
     * @param pollDesc The description of the bot
     * @param options The vote options for users to select from. Example `[Foo, Bar]`
     * @param schedule How many hours from now this poll should be shown
     */
    fun onCreateVoteCommand(
        channel: MessageChannel,
        user: Member,
        message: Message,
        pollTitle: String,
        pollDesc: String,
        options: String,
        schedule: String
    )

    // TODO End Vote
    /**
     * Ends a vote, changing its text to say "vote over"
     * @param user Must be a moderator with certain perms
     * @param pollID ID of the board to end
     */
    fun onEndVoteCommand(channel: MessageChannel, user: Member, message: Message, pollID: String)

    // TODO Delete Vote
    /**
     * Deletes a vote from having a presence
     * @param user Must be a moderator with certain perms
     * @param pollID Identification of the board that must be removed
     */
    fun onDeleteVoteCommand(channel: MessageChannel, user: Member, pollID: String)

    // TODO Results of vote
    /**
     * Requires the vote to be complete
     * @param user If is mod or has certain perms, will be DMed a full list
     * @param pollID Vote to get info on
     */
    fun onResultVoteCommand(channel: MessageChannel, user: Member, pollID: String)
}