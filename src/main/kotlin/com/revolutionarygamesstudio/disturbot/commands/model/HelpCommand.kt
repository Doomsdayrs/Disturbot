package com.revolutionarygamesstudio.disturbot.commands.model

import com.revolutionarygamesstudio.disturbot.commands.base.IHelpCommand
import com.revolutionarygamesstudio.disturbot.common.ext.logID
import com.revolutionarygamesstudio.disturbot.common.obj.ClockedCommand
import com.revolutionarygamesstudio.disturbot.common.utils.Log
import discord4j.core.`object`.entity.channel.MessageChannel

/**
 * disturbot
 * 22 / 05 / 2020
 */
class HelpCommand : IHelpCommand {
    @ClockedCommand(["help"])
    override fun onHelpCommand(channel: MessageChannel, question: String?) {
        Log.i(logID(), "Executing")
        channel.createMessage("Yo im here").block()
        Log.i(logID(), "sent")
    }
}