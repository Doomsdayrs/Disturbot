package com.revolutionarygamesstudio.disturbot.common.utils

import com.revolutionarygamesstudio.disturbot.common.consts.CCYAN
import com.revolutionarygamesstudio.disturbot.common.consts.CPURPLE
import com.revolutionarygamesstudio.disturbot.common.consts.CRED
import com.revolutionarygamesstudio.disturbot.common.consts.CRESET


object Log {

    /**
     * Enforces an ID length
     */
    private fun matchIDSize(string: String): String {
        val originalSize = string.length
        return when {
            originalSize == 20 -> {
                string
            }
            originalSize > 20 -> {
                string.substring(0, string.length - (originalSize - 20))
            }
            else -> {
                val add = 20 - originalSize
                val builder = StringBuilder(string)
                for (i in 0..add)
                    builder.append(" ")
                builder.toString()
            }
        }
    }

    /**
     * Error message
     */
    fun e(id: String, message: Any?) {
        println("${CRED}E>${matchIDSize(id)}\t$message$CRESET}")
    }


    /**
     * Error message
     */
    fun e(id: String, message: Any?, e: Exception? = null) =
        println("${CRED}E>${matchIDSize(id)}\t$message$CRESET\n${e?.printStackTrace() ?: "ERROR UNDEFINED"}")

    /**
     * Error message
     */
    fun e(id: String, message: Any?, e: Throwable? = null) =
        println("${CRED}E>${matchIDSize(id)}\t$message$CRESET\n${e?.printStackTrace() ?: "ERROR UNDEFINED"}")


    /**
     * Information
     */
    fun d(id: String, message: Any?) = println("${CPURPLE}D>${matchIDSize(id)}\t${message.toString()}$CRESET")

    /**
     * Information
     */
    fun i(id: String, message: Any?) = println("${CCYAN}I>${matchIDSize(id)}\t${message.toString()}$CRESET")
}