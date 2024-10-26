package com.example.habiboo.data.network.model.post

data class Post(
    val content: String,
    val approved: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String,
    val media: List<String>,
    val user: User
)

data class User(
    val username: String,
    val image: String
)