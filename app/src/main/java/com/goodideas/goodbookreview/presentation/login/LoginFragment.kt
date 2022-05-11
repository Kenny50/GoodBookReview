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
import com.goodideas.goodbookreview.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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
            login()
        }
    }

    private fun login() {
        lifecycleScope.launch {
            viewModel.login(
                binding.emailText.editText?.text.toString(),
                binding.passwordText.editText?.text.toString()
            ).collect {
                confirmLoginState(it)
            }
        }
    }

    private fun <T> confirmLoginState(resource: Resource<T>) {
        when (resource) {
            is Resource.Loading -> {}
            is Resource.Success -> {
                Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
            }
            is Resource.Error -> {
                Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleViewFlow() {
        viewModel.receiveChannelAsFlow.onEach {
            handleViewEvent(it)
        }.launchIn(lifecycleScope)
    }


}