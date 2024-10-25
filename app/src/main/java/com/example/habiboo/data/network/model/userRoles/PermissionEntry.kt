package com.example.habiboo.data.network.model.userRoles

data class PermissionEntry(
    val controllers: Map<String, ControllerPermissions>
)
