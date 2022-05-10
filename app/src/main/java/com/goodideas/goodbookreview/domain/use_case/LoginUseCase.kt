package com.goodideas.goodbookreview.domain.use_case

import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repo:GoodReviewRepository
) {
    suspend operator fun invoke(account: String, password: String) {
        return // TODO:
    }

}