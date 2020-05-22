package com.revolutionarygamesstudio.disturbot.di

import com.revolutionarygamesstudio.disturbot.commands.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.commands.base.IRankCommands
import com.revolutionarygamesstudio.disturbot.commands.model.RankCommands
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * disturbot
 * 21 / 05 / 2020
 */
val commandExecutorsModule = Kodein.Module("executors") {
    bind<IClockExecutor>() with provider { instance<IRankCommands>() }
}

val commandsModule = Kodein.Module("commands") {
    bind<IRankCommands>() with provider { RankCommands() }
}