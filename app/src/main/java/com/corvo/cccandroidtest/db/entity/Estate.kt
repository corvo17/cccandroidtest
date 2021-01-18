package com.corvo.cccandroidtest.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "estate")
data class Estate(

    // TODO: 1/18/2021
    val id: Long,

    val company: String,

    val address: String,

    val number: Long,

    val revision_number: Long,

    @ColumnInfo(name = "created_date")
    val createdDate: String,

    @ColumnInfo(name = "created_by")
    val createdBy: String,

    @ColumnInfo(name = "requested_by")
    val requestedBy: String,

    val contact: String,
) {
}