package com.revolutionarygamesstudio.disturbot.ui

import com.revolutionarygamesstudio.disturbot.common.consts.ErrorKeys.BOT_ACTIVE
import com.revolutionarygamesstudio.disturbot.common.dto.HResult
import com.revolutionarygamesstudio.disturbot.common.dto.errorResult
import com.revolutionarygamesstudio.disturbot.common.dto.successResult
import com.revolutionarygamesstudio.disturbot.common.ext.logID
import com.revolutionarygamesstudio.disturbot.common.utils.Log
import com.revolutionarygamesstudio.disturbot.main.BotCore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.tornadofx.kodein
import tornadofx.Controller
import java.io.IOException

/**
 * disturbot
 * 22 / 05 / 2020
 */
class MainViewController : Controller(), KodeinAware {
    override val kodein: Kodein by kodein()
    var core: BotCore? = null
    var coreThread: Job? = null

    fun start(): HResult<*> {
        if (coreThread?.isActive == true) return errorResult(BOT_ACTIVE, "The bot is currently active")
        Log.i(logID(), "Starting the bot")
        core = BotCore(kodein)
        coreThread = GlobalScope.launch(Dispatchers.Unconfined) {
            try {
                core?.startup()
            } catch (e: IOException) {
                TODO("Add error handling here")
            }
        }
        return successResult(true)
    }

    fun stop(): HResult<*> {
        Log.i(logID(), "Stopping the bot")
        core?.shutdown()
        core = null
        coreThread?.cancel()
        coreThread = null
        return successResult(true)
    }
}