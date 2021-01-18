package com.corvo.cccandroidtest.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PrefUtil constructor(context: Context) {

    companion object{
        private val IS_AUTHORIZED = "IS_AUTHORIZED"
        private val APP_NAME = "CCCANDROIDTEST"
        private val MODE = Context.MODE_PRIVATE
    }

    private var preferences: SharedPreferences = context.getSharedPreferences(
        APP_NAME,
        MODE
    )


    var isAuthorized: Boolean?
        get() = preferences.getBoolean(IS_AUTHORIZED, false)
        set(value) = preferences.edit {
            putBoolean(IS_AUTHORIZED, value?:false)
        }
}