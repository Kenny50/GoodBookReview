package com.goodideas.goodbookreview.presentation.login

import com.goodideas.goodbookreview.domain.use_case.LoginUseCase
import com.goodideas.goodbookreview.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
):BaseViewModel() {

    fun callJson(account:String, password:String) {
        apiCall {
            loginUseCase(account, password)
        }
    }

    private fun verifyEmailFormat(s: String) {

    }
}