package com.goodideas.goodbookreview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.goodideas.goodbookreview.util.ViewEvent
import timber.log.Timber

abstract class BaseFragment<out T : ViewBinding>(): Fragment() {
    private var _binding: ViewBinding? = null
    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingInflater(inflater)
        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    abstract fun setUi()

    protected abstract val bindingInflater:(LayoutInflater) -> ViewBinding

    protected fun handleViewEvent(event:ViewEvent){
        when(event) {
            ViewEvent.STARTED ->{
                Timber.d("start")
            }
            ViewEvent.FAIL -> {
                Timber.d("fail")
            }
            ViewEvent.FINISH -> {
                Timber.d("finish")
            }
            ViewEvent.LOADING -> {
                Timber.d("loading")
            }
        }
    }
}
