package com.goodideas.goodbookreview.data.repository

import com.goodideas.goodbookreview.data.local.vo.FakeVo
import com.goodideas.goodbookreview.data.remote.GoodReviewApi
import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import javax.inject.Inject

class GoodReviewRepositoryImpl @Inject constructor(
    private val api: GoodReviewApi
) : GoodReviewRepository {
    override suspend fun register(account: String, password: String): FakeVo {
        return api.register()
    }

    override suspend fun login(account: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}