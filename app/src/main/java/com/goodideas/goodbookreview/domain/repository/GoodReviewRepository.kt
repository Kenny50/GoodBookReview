package com.goodideas.goodbookreview.domain.repository

interface GoodReviewRepository {

    suspend fun register(account:String, password:String)

    suspend fun login(account:String, password:String)

    suspend fun logout()
}