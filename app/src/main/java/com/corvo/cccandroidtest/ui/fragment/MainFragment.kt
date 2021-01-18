package com.corvo.cccandroidtest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.corvo.cccandroidtest.R
import com.corvo.cccandroidtest.base.BaseFragment

class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews() {
        getBaseActivity {

        }
    }

    override fun getTitle(): String = "MainFragment"


}