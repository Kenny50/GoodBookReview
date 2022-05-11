package com.goodideas.goodbookreview.data.remote.dto

data class LoginDto(
    val email: String,
    val password: String
)

data class LoginResponseDto(
    val `data`: UserStateDto,
    val token: String
)

