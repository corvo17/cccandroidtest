package com.corvo.cccandroidtest.db.entity

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "estimate")
data class Estimate(

    @PrimaryKey(autoGenerate = true)
    var estimateId: Long = 0L,

    val company: String?,

    val address: String?,

    val number: Long,

    @ColumnInfo(name = "revision_number")
    val revisionNumber: Long,

    @ColumnInfo(name = "created_date")
    val createdDate: Long,

    @ColumnInfo(name = "created_by")
    val created_by: String,

    @ColumnInfo(name = "requested_by")
    val requestedBy: String,

    val contact: String,
) {
    fun getCreatedDatee(): String = convertDate(createdDate)
    fun getNumberr() = number.toString()
    fun getRevisionNumberr() = revisionNumber.toString()
}

@SuppressLint("SimpleDateFormat")
private fun convertDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return format.format(date)
}