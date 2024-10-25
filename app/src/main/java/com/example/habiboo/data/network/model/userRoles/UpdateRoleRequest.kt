package com.example.habiboo.data.network.model.userRoles

data class UpdateRoleRequest(
    val name: String,
    val description: String,
    val permissions: Map<String, ContentTypePermissions>

)
