package com.revolutionarygamesstudio.disturbot.domain.model.table

import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_CONTENT
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_DATE
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_REPORT_ID
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_USER_ID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

/**
 * disturbot
 * 09 / 06 / 2020
 */
class ReportTable : Table() {
    /** ID of the report */
    val id: Column<Long> = long(COLUMN_REPORT_ID).uniqueIndex()

    /** ID of the user */
    val userID: Column<Long> = long(COLUMN_USER_ID)

    /**
     * Content of the report the user made
     */
    val message: Column<String> = text(COLUMN_CONTENT)

    /**
     * Date & time the user made the report
     */
    val date: Column<Long> = long(COLUMN_DATE)
}