package com.goodideas.goodbookreview.data.repository

import com.goodideas.goodbookreview.data.remote.GoodReviewApi
import com.goodideas.goodbookreview.data.remote.dto.*
import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import com.goodideas.goodbookreview.util.Constant
import com.goodideas.goodbookreview.util.DataStoreManager
import javax.inject.Inject

class GoodReviewRepositoryImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val api: GoodReviewApi
) : GoodReviewRepository {

    private suspend fun getToken() = dataStoreManager.read(Constant.DataStoreTokenKey)

    override suspend fun register(registerDto: RegisterDto): UserStateDto {
        return api.register(registerDto)
    }

    override suspend fun login(loginDto: LoginDto): LoginResponseDto {
        return api.login(loginDto)
    }

    override suspend fun logout(): LogoutDto {
        return api.logout(getToken())
    }

    override suspend fun getSelfInfo(): SelfInfoDto {
        return api.getSelfUserData(getToken())
    }
}