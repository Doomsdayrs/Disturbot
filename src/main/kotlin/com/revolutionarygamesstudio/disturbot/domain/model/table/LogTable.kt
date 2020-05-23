package com.revolutionarygamesstudio.disturbot.domain.model.table

import com.revolutionarygamesstudio.disturbot.common.consts.*
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

/**
 * disturbot
 * 23 / 05 / 2020
 */
class LogTable : Table() {
    /** ID of the user */
    val userID: Column<Long> = long(COLUMN_USER_ID)

    /** ID of the channel */
    val channelID: Column<Long> = long(COLUMN_CHANNEL_ID)

    /** ID of the message */
    val messageID: Column<Long> = long(COLUMN_MESSAGE_ID)

    /** time of the message */
    val timeStamp: Column<Long> = long(COLUMN_DATE)

    /**
     * Specifies the content type
     *
     * 0 = Message Creation ; Content is the message
     *
     * 1 = Message Edit     ; Content is the new message
     *
     * 2 = Message Delete   ; Content is nothing
     *
     * 3 = Reaction add     ; Content is the reaction's name & id
     *
     * 4 = Reaction remove  ; Content is the reaction's name & id
     */
    val contentType: Column<Int> = integer(COLUMN_CONTENT_TYPE)

    /** Message content */
    val content: Column<Char> = char(COLUMN_CONTENT)
}