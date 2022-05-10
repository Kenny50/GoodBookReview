package com.goodideas.goodbookreview.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class RegisterDto(
    val email: String,
    val name: String,
    val password: String
)

@Serializable
data class UserStateDto(
    @SerialName("created_at")
    val createdAt: String,
    val email: String,
    val id: Int,
    @SerialName("is_comments_page_private")
    val isCommentsPagePrivate: Boolean,
    val name: String,
    @SerialName("updated_at")
    val updatedAt: String
)