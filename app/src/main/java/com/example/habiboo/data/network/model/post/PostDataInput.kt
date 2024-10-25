package com.example.habiboo.data.network.model.post

data class PostDataInput(
    val user: String, // Can be a user ID or username
    val content: String,
    val media: List<String>,
    val approved: Boolean,
    val comments: List<String>,
    val report: String?,
    val room: String?,
    val streak: String?
)
