package com.goodideas.goodbookreview.data.repository

import com.goodideas.goodbookreview.data.remote.GoodReviewApi
import com.goodideas.goodbookreview.data.remote.dto.*
import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import javax.inject.Inject

class GoodReviewRepositoryImpl @Inject constructor(
    private val api: GoodReviewApi
) : GoodReviewRepository {
    private val token = "" //todo use datastore read token
    override suspend fun register(registerDto: RegisterDto): UserStateDto {
        return api.register(registerDto)
    }

    override suspend fun login(loginDto: LoginDto): LoginResponseDto {
        return api.login(loginDto)
    }

    override suspend fun logout(): LogoutDto {
        return api.logout(token)
    }

    override suspend fun getSelfInfo(): SelfInfoDto {
        return api.getSelfUserData(token)
    }
}