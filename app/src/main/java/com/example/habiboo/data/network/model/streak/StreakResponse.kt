package com.example.habiboo.data.network.model.streak

import com.example.habiboo.data.network.model.room.Meta
import com.example.habiboo.data.network.model.room.StreakData


data class StreakResponse(
    val data: List<StreakData>,
val meta: Meta
)

