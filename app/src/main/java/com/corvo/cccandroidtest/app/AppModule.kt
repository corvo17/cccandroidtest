package com.corvo.cccandroidtest.app

import androidx.room.Room
import com.corvo.cccandroidtest.db.LocalDB
import com.corvo.cccandroidtest.helper.Const
import com.corvo.cccandroidtest.utils.PrefUtil
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dbModule = module {
    factory {
        Room.databaseBuilder(get(), LocalDB::class.java, Const.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    factory { get<LocalDB>().getEstimateAndPerson()}
}

val prefsModule = module {
    single { named("prefs"); PrefUtil(get()) }
}

val appModules = listOf(dbModule)