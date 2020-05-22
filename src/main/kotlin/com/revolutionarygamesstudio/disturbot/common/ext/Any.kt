package com.revolutionarygamesstudio.disturbot.common.ext

/**
 * disturbot
 * 22 / 05 / 2020
 */
inline fun <reified T : Any> T.logID() = T::class.simpleName ?: "UNKNOWN SOURCE"