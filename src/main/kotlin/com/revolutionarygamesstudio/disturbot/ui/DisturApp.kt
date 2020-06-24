package com.revolutionarygamesstudio.disturbot.ui

import com.revolutionarygamesstudio.disturbot.di.commandsModule
import com.revolutionarygamesstudio.disturbot.di.databaseModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.tornadofx.installTornadoSource
import tornadofx.App
import tornadofx.launch

/**
 * disturbot
 * 22 / 05 / 2020
 */
class DisturApp : App(MainView::class), KodeinAware {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch<DisturApp>()
        }
    }

    override val kodein: Kodein = Kodein {
        installTornadoSource()
        bind<MainViewController>() with provider { MainViewController() }

        import(commandsModule)
        import(databaseModule)
    }
}