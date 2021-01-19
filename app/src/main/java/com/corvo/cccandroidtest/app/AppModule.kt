package com.corvo.cccandroidtest.app

import android.util.Log
import androidx.room.Room
import com.corvo.cccandroidtest.db.LocalDB
import com.corvo.cccandroidtest.helper.Const
import com.corvo.cccandroidtest.ui.viewModel.MainViewModel
import com.corvo.cccandroidtest.utils.PrefUtil
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {

    factory {
        Room.databaseBuilder(get(), LocalDB::class.java, Const.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    factory { get<LocalDB>().getEstimateAndPersonDao() }
}

val prefsModule = module {
    single {PrefUtil(get()) }
}

val viewModel = module {
    viewModel { MainViewModel(get(), get(), get()) }
}

val appModules = listOf(prefsModule, dbModule, viewModel)