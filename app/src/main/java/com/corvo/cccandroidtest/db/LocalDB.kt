package com.corvo.cccandroidtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.corvo.cccandroidtest.db.dao.CardDao
import com.corvo.cccandroidtest.db.entity.Card
import com.corvo.cccandroidtest.db.entity.Estate
import com.corvo.cccandroidtest.db.entity.User


@Database(
    entities = [User::class, Estate::class, Card::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDB : RoomDatabase() {
    abstract fun userDao(): CardDao?
}
