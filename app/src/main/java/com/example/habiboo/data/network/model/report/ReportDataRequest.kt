package com.example.habiboo.data.network.model.report

data class ReportDataRequest(
    val user: String,
    val post: String,
    val votes: List<String>,
    val isClosed: Boolean
)
