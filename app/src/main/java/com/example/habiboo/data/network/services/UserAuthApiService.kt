package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.userAuth.AuthResponse
import com.example.habiboo.data.network.model.userAuth.ChangePasswordRequest
import com.example.habiboo.data.network.model.userAuth.EmailRequest
import com.example.habiboo.data.network.model.userAuth.ForgotPasswordResponse
import com.example.habiboo.data.network.model.userAuth.LoginRequest
import com.example.habiboo.data.network.model.userAuth.RegisterRequest
import com.example.habiboo.data.network.model.userAuth.ResetPasswordRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserAuthApiService {
    // Login with a local provider
    @POST("auth/local")
    suspend fun login(@Body loginRequest: LoginRequest): Response<AuthResponse>

    // Register a new user
    @POST("auth/local/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<AuthResponse>


    // Login with an external provider
    @GET("connect/{provider}")
    suspend fun loginWithProvider(@Path("provider") provider: String): AuthResponse

    // Callback from provider authentication
    @GET("auth/{provider}/callback")
    suspend fun providerCallback(@Path("provider") provider: String): Response<AuthResponse>

    @POST("auth/forgot-password")
    suspend fun forgotPassword(@Body emailRequest: EmailRequest): Response<ForgotPasswordResponse>


    // Reset the user's password
    @POST("auth/reset-password")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest): Response<AuthResponse>


    @POST("auth/change-password")
    suspend fun changePassword(@Body changePasswordRequest: ChangePasswordRequest): Response<AuthResponse>


    // Confirm the user's email
    @GET("auth/email-confirmation")
    suspend fun confirmEmail(@Query("confirmation") token: String): Response<Unit>

}
