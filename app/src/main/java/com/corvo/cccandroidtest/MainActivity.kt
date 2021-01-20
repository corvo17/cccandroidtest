package com.corvo.cccandroidtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.InflateException
import android.widget.Toast
import com.corvo.cccandroidtest.ui.fragment.MainFragment
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, MainFragment())
            .commitAllowingStateLoss()
    }

    @SuppressLint("ShowToast")
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            doubleBackToExitPressedOnce = false
            super.finishAffinity()
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(this, R.string.backPressAgain, Toast.LENGTH_SHORT)
            Timer("SettingUp", false).schedule(2_000) { doubleBackToExitPressedOnce = false }
        }
    }
}