package com.revolutionarygamesstudio.disturbot.ui

import org.kodein.di.generic.instance
import org.kodein.di.tornadofx.kodein
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.hbox

/**
 * disturbot
 * 22 / 05 / 2020
 */
class MainView : View("My View") {
    private val mainViewController by kodein().instance<MainViewController>()

    override val root = hbox {
        minHeight = 200.0
        minWidth = 400.0

        button("Start") {
            minHeight = 50.0
            minWidth = 50.0
            action {
                mainViewController.start()
            }
        }
        button("Stop") {
            minHeight = 50.0
            minWidth = 50.0
            action {
                mainViewController.stop()
            }
        }
        button("Restart") {
            minHeight = 50.0
            minWidth = 50.0
            action {
                mainViewController.stop()
                mainViewController.start()
            }
        }
        button("Update") {
            minHeight = 50.0
            minWidth = 50.0
        }
    }
}
