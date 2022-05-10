package com.goodideas.goodbookreview.data.remote

import com.goodideas.goodbookreview.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GoodReviewApi {

    @POST("auth/register")
    suspend fun register(registerDto: RegisterDto): UserStateDto

    @POST("auth/login")
    suspend fun login(loginDto: LoginDto): LoginResponseDto

    @POST("auth/logout")
    suspend fun logout(
        @Header("Authorization") auth: String
    ): LogoutDto

    @GET("auth/user")
    suspend fun getSelfUserData(
        @Header("Authorization") auth: String
    ): SelfInfoDto
}