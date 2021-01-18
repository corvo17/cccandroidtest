package com.corvo.cccandroidtest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.corvo.cccandroidtest.MainActivity


abstract class BaseFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(getLayout(),container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    open fun changeHomeNav(item: MenuItem) {

    }



    fun getBaseActivity(run : (MainActivity) -> (Unit)) {

        (activity as? MainActivity).let {
            it?.let { it1 ->
                run(it1)
            }
        }
    }

    abstract fun getLayout() : Int
    abstract fun setupViews()
    abstract fun getTitle() : String


}