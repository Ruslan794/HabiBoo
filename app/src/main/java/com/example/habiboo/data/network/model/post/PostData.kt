package com.example.habiboo.data.network.model.post


data class PostData(
    val id: Int,
    val content: String,
    val approved: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String?,
    val media: List<String>,
    val user: PostUser,
    val comments: Int,
    val report: Report?
)

data class Report(
    val like: Int,
    val dislike: Int
)

