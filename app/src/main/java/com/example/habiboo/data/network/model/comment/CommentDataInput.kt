package com.example.habiboo.data.network.model.comment

data class CommentDataInput(
    val text: String,
    val user: String, // Could be an ID or a username based on your requirements
    val post: String // Could be an ID or a title based on your requirements
)
