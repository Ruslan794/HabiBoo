package com.example.habiboo.data.network.model.comment

import com.example.habiboo.data.network.model.post.PostData
import com.example.habiboo.data.network.model.room.UserData

data class CommentAttributes(
    val text: String,
    val user: UserData,
    val post: PostData?,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String?
)
