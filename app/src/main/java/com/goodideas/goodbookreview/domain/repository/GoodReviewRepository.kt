package com.goodideas.goodbookreview.domain.repository

import com.goodideas.goodbookreview.data.remote.dto.*

interface GoodReviewRepository {

    suspend fun register(registerDto: RegisterDto): UserStateDto

    suspend fun login(loginDto: LoginDto): LoginResponseDto

    suspend fun logout(): LogoutDto

    suspend fun getSelfInfo(): SelfInfoDto
}