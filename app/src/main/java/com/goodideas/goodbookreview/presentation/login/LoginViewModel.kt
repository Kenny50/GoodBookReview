package com.goodideas.goodbookreview.presentation.login

import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import com.goodideas.goodbookreview.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo:GoodReviewRepository
):BaseViewModel() {

    fun callJson(){
        apiCall {
            //repo.logout()
        }
    }
}