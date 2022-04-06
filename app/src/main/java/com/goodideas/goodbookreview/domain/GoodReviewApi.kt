package com.goodideas.goodbookreview.domain

interface GoodReviewApi {
    suspend fun register(account:String, password:String)

    suspend fun login(account:String, password:String)

    suspend fun logout(token:String)
}