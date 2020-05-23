package com.revolutionarygamesstudio.disturbot.domain.repository.base

import com.revolutionarygamesstudio.disturbot.common.dto.HResult

/**
 * disturbot
 * 23 / 05 / 2020
 */
interface IUserDataRepository {
    fun doesUserData(userID: Long): HResult<Boolean>

    fun insertFreshData(userID: Long): HResult<Boolean>
}