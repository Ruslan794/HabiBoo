package com.example.habiboo.data.network.model.room

data class UserAttributes(
    val username: String,
    val email: String,
    val confirmed: Boolean,
    val blocked: Boolean,
    val createdAt: String?,
    val updatedAt: String?
)
