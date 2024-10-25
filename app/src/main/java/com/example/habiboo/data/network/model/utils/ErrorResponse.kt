package com.example.habiboo.data.network.model.utils

data class ErrorResponse(
    val status: Int,
    val name: String,
    val message: String,
    val details: Map<String, Any>
)
