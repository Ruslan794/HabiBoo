package com.example.habiboo.data.network.services



import com.example.habiboo.data.network.model.*
import com.example.habiboo.data.network.model.userAuth.User
import com.example.habiboo.data.network.model.userRoles.CreateRoleRequest
import com.example.habiboo.data.network.model.userRoles.CreateRoleResponse
import com.example.habiboo.data.network.model.userRoles.CreateUserRequest
import com.example.habiboo.data.network.model.userRoles.DeleteRoleResponse
import com.example.habiboo.data.network.model.userRoles.PermissionsTreeResponse
import com.example.habiboo.data.network.model.userRoles.RoleResponse
import com.example.habiboo.data.network.model.userRoles.UpdateRoleRequest
import com.example.habiboo.data.network.model.userRoles.UpdateRoleResponse
import retrofit2.Response
import retrofit2.http.*

interface UserRolesService {

 //  // Get default generated permissions
 //  @GET("users-permissions/permissions")
 //  suspend fun getPermissions(): Response<PermissionsTreeResponse>

 //  // List roles
 //  @GET("users-permissions/roles")
 //  suspend fun listRoles(): Response<RoleResponse>

 //  @POST("users-permissions/roles")
 //  suspend fun createRole(@Body roleRequest: CreateRoleRequest): Response<CreateRoleResponse>

 //  @GET("users-permissions/roles/{id}")
 //  suspend fun getRole(@Path("id") roleId: String): Response<RoleResponse>


 //  @PUT("users-permissions/roles/{role}")
 //  suspend fun updateRole(
 //      @Path("role") roleId: String,
 //      @Body updateRoleRequest: UpdateRoleRequest
 //  ): Response<UpdateRoleResponse>

 //  // Delete a role
 //  @DELETE("users-permissions/roles/{role}")
 //  suspend fun deleteRole(@Path("role") roleId: String): Response<DeleteRoleResponse>


 //  // Get list of users
 //  @GET("users")
 //  suspend fun getUsers(): Response<List<User>>

 //  // Create a new user
 //  @POST("users")
 //  suspend fun createUser(@Body createUserRequest: CreateUserRequest): Response<UserResponse>

 //  // Get a specific user
 //  @GET("users/{id}")
 //  suspend fun getUser(@Path("id") id: String): Response<UserResponse>

 //  // Update a user
 //  @PUT("users/{id}")
 //  suspend fun updateUser(@Path("id") id: String, @Body userRequest: UserRequest): Response<UserResponse>

 //  // Delete a user
 //  @DELETE("users/{id}")
 //  suspend fun deleteUser(@Path("id") id: String): Response<Unit>

 //  // Get authenticated user info
 //  @GET("users/me")
 //  suspend fun getAuthenticatedUser(): Response<UserResponse>

 //  // Get user count
 //  @GET("users/count")
 //  suspend fun getUserCount(): Response<Int>
}
