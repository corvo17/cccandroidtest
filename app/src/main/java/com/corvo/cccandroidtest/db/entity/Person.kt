package com.corvo.cccandroidtest.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(

        @PrimaryKey(autoGenerate = true)
        val id: Long,

        @ColumnInfo(name = "first_name")
        val firstName: String,

        @ColumnInfo(name = "last_name")
        val lastName: String,

        val email: String,

        @ColumnInfo(name = "phone_number")
        val phoneNumber: String
) {
}