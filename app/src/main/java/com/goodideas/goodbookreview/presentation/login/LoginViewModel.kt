package com.goodideas.goodbookreview.presentation.login

import com.goodideas.goodbookreview.data.remote.dto.LoginDto
import com.goodideas.goodbookreview.data.remote.dto.LoginResponseDto
import com.goodideas.goodbookreview.domain.use_case.LoginUseCase
import com.goodideas.goodbookreview.presentation.BaseViewModel
import com.goodideas.goodbookreview.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
):BaseViewModel() {

    suspend fun login(account: String, password: String): Flow<Resource<LoginResponseDto>> {
        return loginUseCase(
            LoginDto(email = account, password = password)
        )
            .addViewEventTracker()
            .flowOn(Dispatchers.IO)
    }
}