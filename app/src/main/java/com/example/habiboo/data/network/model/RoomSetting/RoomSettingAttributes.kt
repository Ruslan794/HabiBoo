package com.example.habiboo.data.network.model.RoomSetting

data class RoomSettingAttributes(
    val close: Boolean,
    val period: Int,
    val password: String?,
    val isGlobal: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String
)
