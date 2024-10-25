package com.example.habiboo.data.network.model.userRoles

data class Role(
    val id: Int,
    val name: String,
    val description: String,
    val type: String,
    val createdAt: String,
    val updatedAt: String,
    val permissions: Map<String, ContentTypePermissions>

)
