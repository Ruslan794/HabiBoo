package com.example.habiboo.data.network.model.upload

data class FileUploadResponse(
    val id: Int,
    val name: String,
    val alternativeText: String?,
    val caption: String?,
    val width: Int,
    val height: Int,
    val formats: Formats?,
    val url: String,
    val mime: String,
    val size: Double,
    val hash: String,
    val ext: String,
    val provider: String,
    val previewUrl: String?,
    val provider_metadata: ProviderMetadata?,
    val createdAt: String,
    val updatedAt: String
)
