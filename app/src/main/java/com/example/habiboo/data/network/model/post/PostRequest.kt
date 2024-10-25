package com.example.habiboo.data.network.model.post

data class PostRequest(
    val user: String,
    val content: String,
    val media: List<String>,
    val approved: Boolean,
    val comments: List<String>,
    val report: String,
    val room: String,
    val streak: String
)
