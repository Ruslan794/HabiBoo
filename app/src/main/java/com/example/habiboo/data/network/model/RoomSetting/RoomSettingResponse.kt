package com.example.habiboo.data.network.model.RoomSetting

import com.example.habiboo.data.network.model.room.Meta

data class RoomSettingResponse(
    val data: List<RoomSettingData>,
    val meta: Meta
)
