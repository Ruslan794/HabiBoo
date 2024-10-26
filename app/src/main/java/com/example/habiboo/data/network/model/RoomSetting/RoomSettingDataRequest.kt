package com.example.habiboo.data.network.model.RoomSetting

data class RoomSettingDataRequest(
    val room: String,
    val close: Boolean,
    val period: Int,
    val isGlobal: Boolean,
    val password: String?
)
