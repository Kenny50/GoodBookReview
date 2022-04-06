package com.goodideas.goodbookreview.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.goodideas.goodbookreview.databinding.FragmentLoginBinding
import com.goodideas.goodbookreview.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel by viewModels<LoginViewModel>()

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentLoginBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleViewFlow()
    }

    override fun setUi() {
        binding.registerButton.setOnClickListener {
            Toast.makeText(requireContext(), " click", Toast.LENGTH_SHORT).show()
            viewModel.callJson()
        }
    }

    private fun handleViewFlow(){
        viewModel.receiveChannelAsFlow.onEach {
            handleViewEvent(it)
        }.launchIn(lifecycleScope)
    }


}