package com.example.habiboo.data.network.model.room

data class Pagination (
    val page: Int,
    val pageSize: Int,
    val pageCount: Int,
    val totalPages: Int
)