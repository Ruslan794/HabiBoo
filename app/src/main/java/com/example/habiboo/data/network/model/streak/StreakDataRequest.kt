package com.example.habiboo.data.network.model.streak

data class StreakDataRequest(
    val user: String,       // or Int if it's an ID
    val room: String,       // or Int if it's an ID
    val accomplished: Boolean,
    val post: String        // or Int if it's an ID
)
