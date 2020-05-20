package com.revolutionarygamesstudio.disturbot.common.obj

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ClockedCommand(
    val aliases: Array<String>,
    val description: String = "",
    val privateOnly: Boolean = true
)