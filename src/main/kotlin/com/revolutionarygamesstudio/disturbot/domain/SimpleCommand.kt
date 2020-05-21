package com.revolutionarygamesstudio.disturbot.domain

import com.revolutionarygamesstudio.disturbot.commands.base.IClockExecutor
import com.revolutionarygamesstudio.disturbot.common.obj.ClockedCommand
import java.lang.reflect.Method
import kotlin.reflect.KFunction

/**
 * disturbot
 * 21 / 05 / 2020
 */
data class SimpleCommand(val annotation: ClockedCommand, val method: KFunction<*>, val executor: IClockExecutor)