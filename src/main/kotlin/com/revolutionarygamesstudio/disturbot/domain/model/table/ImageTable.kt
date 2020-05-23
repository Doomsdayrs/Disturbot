package com.revolutionarygamesstudio.disturbot.domain.model.table

import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_CHANNEL_ID
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_MESSAGE_ID
import com.revolutionarygamesstudio.disturbot.common.consts.COLUMN_USER_ID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.api.ExposedBlob

/**
 * disturbot
 * 23 / 05 / 2020
 * This table contains images that are attached with each message
 */
class ImageTable : Table() {

    /** ID of the user */
    val userID: Column<Long> = long(COLUMN_USER_ID)

    /** ID of the channel */
    val channelID: Column<Long> = long(COLUMN_CHANNEL_ID)

    /** ID of the message */
    val messageID: Column<Long> = long(COLUMN_MESSAGE_ID)

    val image0: Column<ExposedBlob> = blob(this::image0.name)
    val image1: Column<ExposedBlob> = blob(this::image1.name)
    val image2: Column<ExposedBlob> = blob(this::image2.name)
    val image3: Column<ExposedBlob> = blob(this::image3.name)
    val image4: Column<ExposedBlob> = blob(this::image4.name)
    val image5: Column<ExposedBlob> = blob(this::image5.name)
    val image6: Column<ExposedBlob> = blob(this::image6.name)
    val image7: Column<ExposedBlob> = blob(this::image7.name)
    val image8: Column<ExposedBlob> = blob(this::image8.name)
    val image9: Column<ExposedBlob> = blob(this::image9.name)
}