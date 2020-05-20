package com.revolutionarygamesstudio.disturbot.common.dto

/**
 * disturbot
 * 20 / 05 / 2020
 *
 * @author github.com/doomsdayrs
 */
sealed class HResult<out T : Any> {
    class Success<out T : Any>(
        val data: T
    ) : HResult<T>()

    object Loading : HResult<Nothing>()
    object Empty : HResult<Nothing>()
    class Error(val code: Int, val message: String) : HResult<Nothing>()
}

inline fun <reified T : Any> successResult(data: T) = HResult.Success(data)
fun loading() = HResult.Loading
fun emptyResult() = HResult.Empty
fun errorResult(code: Int, message: String) = HResult.Error(code, message)
