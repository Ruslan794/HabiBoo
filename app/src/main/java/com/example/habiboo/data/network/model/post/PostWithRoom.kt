package com.example.habiboo.data.network.model.post

data class PostWithRoom(
    val posts: List<PostData>,
    val name: String,
    val goal: String,
    val current_user_streak: Int
)
