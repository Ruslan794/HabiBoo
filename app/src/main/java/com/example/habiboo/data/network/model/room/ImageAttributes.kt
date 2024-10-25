package com.example.habiboo.data.network.model.room

data class ImageAttributes(
    val name: String,
    val alternativeText: String?,
    val caption: String?,
    val width: Int?,
    val height: Int?,
    val formats: String?,
    val hash: String?,
    val ext: String?,
    val mime: String?,
    val size: Double?,
    val url: String,
    val previewUrl: String?,
    val provider: String?,
    val provider_metadata: String?,
    val createdAt: String?,
    val updatedAt: String?
)
