package com.revolutionarygamesstudio.disturbot.commands.base.base

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
@Target(AnnotationTarget.FUNCTION)
@Retention
@MustBeDocumented
annotation class ClockedCommand(
    val aliases: Array<String>,
    val description: String = ""
)