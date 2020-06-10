package com.revolutionarygamesstudio.disturbot.domain.model.table

import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_CONTENT
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_REPORT_ID
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_USER_ID
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_VOTE_ID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

/**
 * disturbot
 * 09 / 06 / 2020
 *
 * Data for a vote in a table, each user is only allowed one entry for each vote ID
 */
class UserVoteTable : Table() {
    /** ID of the report */
    val userID: Column<Long> = long(COLUMN_USER_ID)

    /** ID of the vote this is tied to */
    val voteID: Column<Long> = long(COLUMN_VOTE_ID)

    /** Which vote the user made for the vote */
    val vote: Column<Int> = integer(COLUMN_CONTENT)
}