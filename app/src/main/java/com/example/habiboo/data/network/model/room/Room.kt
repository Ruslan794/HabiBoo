package com.example.habiboo.data.network.model.room

import com.google.gson.annotations.SerializedName

data class Room(
    val id: String,
    val name: String,
    val description: String?,
    val goal: String,
    val image: String?,
    val close: Boolean,
    @SerializedName("users")
    val users: Users,
){
    // Property to get the count directly
    val currentMembers: Int
        get() = users.count
}

data class Users(
    val count: Int
)