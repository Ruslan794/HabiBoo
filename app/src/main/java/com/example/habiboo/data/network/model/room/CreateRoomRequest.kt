package com.example.habiboo.data.network.model.room

data class CreateRoomRequest(
    val name: String,
    val description: String?,
    val users: List<String>?, // or List<Int> if the IDs are integers
    val posts: List<String>?, // or List<Int>
    val streaks: List<String>?, // or List<Int>
    val room_setting: String?, // or Int if it's an ID
    val image: String? // or Int if it's an ID
)
