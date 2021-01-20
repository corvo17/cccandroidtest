package com.corvo.cccandroidtest.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class Person(

    @PrimaryKey(autoGenerate = false)
    var personId: String,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    val email: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String
) {
    fun getFullName() = firstName + lastName
}