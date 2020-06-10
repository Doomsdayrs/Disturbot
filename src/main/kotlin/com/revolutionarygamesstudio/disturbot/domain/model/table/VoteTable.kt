package com.revolutionarygamesstudio.disturbot.domain.model.table

import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_CONTENT
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_VOTE_ID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

/**
 * disturbot
 * 09 / 06 / 2020
 */
class VoteTable : Table() {
    /** ID of the report */
    val id: Column<Long> = long(COLUMN_VOTE_ID).uniqueIndex()

    val message: Column<String> = text(COLUMN_CONTENT)
}