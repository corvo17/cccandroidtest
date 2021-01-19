package com.corvo.cccandroidtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.corvo.cccandroidtest.db.dao.EstimateAndPersonDao
import com.corvo.cccandroidtest.db.entity.EstimateAndPerson
import com.corvo.cccandroidtest.db.entity.Estimate
import com.corvo.cccandroidtest.db.entity.Person


@Database(
    entities = [Person::class, Estimate::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDB : RoomDatabase() {
    abstract fun getEstimateAndPersonDao(): EstimateAndPersonDao
}
