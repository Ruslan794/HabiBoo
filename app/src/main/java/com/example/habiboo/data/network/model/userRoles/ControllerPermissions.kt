package com.example.habiboo.data.network.model.userRoles

data class ControllerPermissions(
    val find: PermissionDetails? = null,
    val findOne: PermissionDetails? = null,
    val create: PermissionDetails? = null)
