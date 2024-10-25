package com.example.habiboo.data.network.model.vote

data class VoteDataRequest(
    val user: String, // or Int if using numeric IDs
    val approved: Boolean,
    val report: String // or Int if using numeric IDs
)
