package com.corvo.cccandroidtest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.corvo.cccandroidtest.MainActivity


abstract class BaseFragment : Fragment() {

    var childBinding: ViewDataBinding? = null
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val resId =
            getLayoutId() ?: return super.onCreateView(inflater, container, savedInstanceState)
        childBinding = DataBindingUtil.inflate(inflater, resId, container, false)
        childBinding?.lifecycleOwner = viewLifecycleOwner
        return childBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }


    fun getBaseActivity(run: (MainActivity) -> (Unit)) {

        (activity as? MainActivity).let {
            it?.let { it1 ->
                run(it1)
            }
        }
    }

    override fun onDestroyView() {
        hideKeyboard()
        (childBinding?.root?.parent as? ViewGroup)?.removeView(childBinding?.root)
        childBinding = null
        super.onDestroyView()
    }

    open fun hideKeyboard() {
        //(activity as? MainActivity)?.hideKeyboard()
    }

    abstract fun getLayoutId(): Int?
    abstract fun setupViews()
    abstract fun getTitle(): String


}