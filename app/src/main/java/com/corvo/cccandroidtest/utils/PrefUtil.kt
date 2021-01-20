package com.corvo.cccandroidtest.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PrefUtil constructor(context: Context) {

    companion object {
        private const val IS_FIRST_ATTEMPT = "IS_FIRST_ATTEMPT"
        private const val APP_NAME = "CCCANDROIDTEST"
        private const val MODE = Context.MODE_PRIVATE
    }

    private var preferences: SharedPreferences = context.getSharedPreferences(
        APP_NAME,
        MODE
    )


    var isFirstAttempt: Boolean?
        get() = preferences.getBoolean(IS_FIRST_ATTEMPT, true)
        set(value) = preferences.edit {
            putBoolean(IS_FIRST_ATTEMPT, value ?: true)
        }
}