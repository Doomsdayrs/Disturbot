package com.revolutionarygamesstudio.disturbot.main

import com.revolutionarygamesstudio.disturbot.BuildConfig
import com.revolutionarygamesstudio.disturbot.commands.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.handler.base.IClockedCommandHandler
import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.message.MessageCreateEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactive.asFlow
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.allInstances
import org.kodein.di.generic.instance
import java.io.IOException

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * Simply scrap this object and make a new one to restart
 */
class BotCore(override val kodein: Kodein) : KodeinAware {
    val client: DiscordClient = DiscordClient.create(BuildConfig.discordToken)
    var gateway: GatewayDiscordClient? = null
    val clockedCommandHandler by instance<IClockedCommandHandler>()
    val commands by allInstances<IClockExecutor>()

    /**
     * Signals the beginning of the bot
     */
    @Throws(IOException::class)
    fun startup() {
        // Login to discord
        gateway = client.login().block() ?: throw IOException("Failure to login")

        // register commands
        clockedCommandHandler.registerCommands(commands)
        watchUpdates()
    }

    /**
     * Setups up command handling
     */
    fun watchUpdates() {
        gateway?.on(MessageCreateEvent::class.java)?.asFlow()
            ?.filter { clockedCommandHandler.isMessageACommand(it.message.content) }?.let {
                GlobalScope.launch(Dispatchers.IO) {
                    it.collect { clockedCommandHandler.executeCommand(it) }
                }
            }
    }

    /**
     * Shuts the bot down
     */
    fun shutdown() {
        gateway?.logout()?.block()
    }
}