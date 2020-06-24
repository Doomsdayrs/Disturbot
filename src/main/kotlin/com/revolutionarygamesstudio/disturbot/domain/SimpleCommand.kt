package com.revolutionarygamesstudio.disturbot.domain

import com.revolutionarygamesstudio.disturbot.commands.base.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.commands.base.base.ClockedCommand
import kotlin.reflect.KFunction

/**
 * disturbot
 * 21 / 05 / 2020
 */
data class SimpleCommand(
    val annotation: ClockedCommand,
    val method: KFunction<*>,
    val executor: IClockExecutor,
    val CLASS: Any
)