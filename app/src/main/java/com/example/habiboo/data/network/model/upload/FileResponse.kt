package com.example.habiboo.data.network.model.upload

data class FileResponse(
    val id: Int,
    val name: String,
    val alternativeText: String?,
    val caption: String?,
    val width: Int,
    val height: Int,
    val formats: Formats?,
    val hash: String,
    val ext: String,
    val mime: String,
    val size: Double,
    val url: String,
    val previewUrl: String?,
    val provider: String,
    val provider_metadata: ProviderMetadata?,
    val createdAt: String,
    val updatedAt: String
)
