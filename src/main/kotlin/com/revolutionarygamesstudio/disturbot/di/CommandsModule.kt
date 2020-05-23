package com.revolutionarygamesstudio.disturbot.di

import com.revolutionarygamesstudio.disturbot.commands.base.IHelpCommand
import com.revolutionarygamesstudio.disturbot.commands.base.IRankCommands
import com.revolutionarygamesstudio.disturbot.commands.model.HelpCommand
import com.revolutionarygamesstudio.disturbot.commands.model.RankCommands
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

/**
 * disturbot
 * 21 / 05 / 2020
 */

val commandsModule = Kodein.Module("commands") {
    bind<IRankCommands>() with provider { RankCommands() }
    bind<IHelpCommand>() with provider { HelpCommand() }
}