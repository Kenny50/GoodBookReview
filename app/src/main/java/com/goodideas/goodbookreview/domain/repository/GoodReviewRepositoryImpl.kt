package com.goodideas.goodbookreview.domain.repository

import com.goodideas.goodbookreview.domain.GoodReviewApi
import javax.inject.Inject

class GoodReviewRepositoryImpl @Inject constructor(
    private val api: GoodReviewApi
):GoodReviewRepository {
    override suspend fun register(account: String, password: String) {
        api.login(account, password)
    }

    override suspend fun login(account: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}