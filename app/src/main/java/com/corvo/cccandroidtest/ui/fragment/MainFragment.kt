package com.corvo.cccandroidtest.ui.fragment

import com.corvo.cccandroidtest.R
import com.corvo.cccandroidtest.base.BaseFragment
import com.corvo.cccandroidtest.databinding.FragmentMainBinding
import com.corvo.cccandroidtest.ui.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment() {

    private val viewModel: MainViewModel by viewModel()

    private val binding: FragmentMainBinding
        get() = childBinding as FragmentMainBinding

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun setupViews() {
        getBaseActivity {
            initViews()
        }
    }

    private fun initViews(): Unit = with(binding) {
        vm = viewModel
        executePendingBindings()
        if (viewModel.prefUtil.isFirstAttempt == true) {
            viewModel.prefUtil.isFirstAttempt = false
            viewModel.initLocalDB()
        } else {
            viewModel.loadEstimate()
        }
    }

    override fun getTitle(): String = "MainFragment"

}