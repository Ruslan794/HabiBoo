package com.example.habiboo.data.network.model.userRoles

data class CreateRoleRequest(
    val name: String,
    val description: String,
    val permissions: Map<String, PermissionEntry>

)
