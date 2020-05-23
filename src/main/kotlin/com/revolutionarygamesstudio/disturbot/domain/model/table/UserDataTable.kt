package com.revolutionarygamesstudio.disturbot.domain.model.table

import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_EXP
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_LEVEL
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_NOTIFY_TYPE
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_USER_ID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

/**
 * disturbot
 * 23 / 05 / 2020
 */
class UserDataTable : Table() {
    /** ID of the user */
    val id: Column<Long> = long(COLUMN_USER_ID).uniqueIndex()

    /**
     * How the user should be notified of a level up
     *
     * 0 = Do not
     *
     * 1 = In chat
     *
     * 2 = In DM
     */
    val levelUpNotifyType: Column<Long> = long(COLUMN_NOTIFY_TYPE).default(1)

    /**
     * The count of EXP the user has
     */
    val exp: Column<Double> = double(COLUMN_EXP)

    val level: Column<Int> = integer(COLUMN_LEVEL).default(0)
}