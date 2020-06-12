package com.revolutionarygamesstudio.disturbot.di

import com.revolutionarygamesstudio.disturbot.commands.base.IHelpCommand
import com.revolutionarygamesstudio.disturbot.commands.base.IRankCommands
import com.revolutionarygamesstudio.disturbot.commands.model.HelpCommand
import com.revolutionarygamesstudio.disturbot.commands.model.RankCommands
import com.revolutionarygamesstudio.disturbot.handler.base.IClockedCommandHandler
import com.revolutionarygamesstudio.disturbot.handler.model.ClockedCommandHandler
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

/**
 * disturbot
 * 21 / 05 / 2020
 */

val commandsModule = Kodein.Module("commands") {
    bind<IClockedCommandHandler>() with provider { ClockedCommandHandler() }
    bind<IRankCommands>() with provider { RankCommands() }
    bind<IHelpCommand>() with provider { HelpCommand() }
}