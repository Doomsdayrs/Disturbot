package com.revolutionarygamesstudio.disturbot.main

import com.revolutionarygamesstudio.disturbot.BuildConfig
import com.revolutionarygamesstudio.disturbot.handler.base.ClockedCommandHandler
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
import org.kodein.di.generic.instance
import java.io.IOException

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
class BotCore(override val kodein: Kodein) : KodeinAware {
    val client: DiscordClient = DiscordClient.create(BuildConfig.discordToken)
    var gateway: GatewayDiscordClient? = null
    val clockedCommandHandler by instance<ClockedCommandHandler>()

    @Throws(IOException::class)
    fun startup() {
        shutdown()
        gateway = client.login().block() ?: throw IOException("Failure to login")
        watchUpdates()
    }

    fun watchUpdates() {
        gateway?.on(MessageCreateEvent::class.java)?.asFlow()
            ?.filter { clockedCommandHandler.isMessageACommand(it.message.content) }?.let {
                GlobalScope.launch(Dispatchers.IO) {
                    it.collect { clockedCommandHandler.executeCommand(it) }
                }
            }
    }

    fun shutdown() {
        gateway?.logout()?.block()
    }
}