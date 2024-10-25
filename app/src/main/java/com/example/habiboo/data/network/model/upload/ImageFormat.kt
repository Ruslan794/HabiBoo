package com.example.habiboo.data.network.model.upload

data class ImageFormat(
    val ext: String,
    val url: String,
    val hash: String,
    val mime: String,
    val name: String,
    val path: String?,
    val size: Double,
    val width: Int,
    val height: Int,
    val sizeInBytes: Int
)
