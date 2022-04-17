package com.goodideas.goodbookreview.domain.repository

import com.goodideas.goodbookreview.data.local.vo.FakeVo

interface GoodReviewRepository {

    suspend fun register(account: String, password: String): FakeVo

    suspend fun login(account: String, password: String)

    suspend fun logout()
}