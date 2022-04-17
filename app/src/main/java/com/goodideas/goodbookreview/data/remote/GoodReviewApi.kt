package com.goodideas.goodbookreview.data.remote

import com.goodideas.goodbookreview.data.local.vo.FakeVo
import retrofit2.http.GET

interface GoodReviewApi {

    @GET("/posts/1")
    suspend fun register(): FakeVo

    suspend fun login(account: String, password: String)

    suspend fun logout(token: String)
}