package com.example.habiboo.repository

import com.example.habiboo.data.network.RetrofitClient
import com.example.habiboo.data.network.model.userAuth.*
import com.example.habiboo.data.network.services.UserAuthApiService

import com.google.gson.Gson
import retrofit2.Response

class UserAuthRepository {
    private val apiService: UserAuthApiService = RetrofitClient.createService(UserAuthApiService::class.java)

    // Login with a local provider
    suspend fun login(loginRequest: LoginRequest): Result<AuthResponse> {
        return handleApiResponse { apiService.login(loginRequest) }
    }

    // Register a new user
    suspend fun register(registerRequest: RegisterRequest): Result<AuthResponse> {
        return handleApiResponse { apiService.register(registerRequest) }
    }

    // Login with an external provider
    suspend fun loginWithProvider(provider: String): Result<AuthResponse> {
        return try {
            val response = apiService.loginWithProvider(provider)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(ErrorResponse("Unknown error", 0, "error", emptyMap()))
        }
    }

    // Callback from provider authentication
    suspend fun providerCallback(provider: String): Result<AuthResponse> {
        return handleApiResponse { apiService.providerCallback(provider) }
    }

    // Send a password reset email
    suspend fun forgotPassword(emailRequest: EmailRequest): Result<ForgotPasswordResponse> {
        return handleApiResponse { apiService.forgotPassword(emailRequest) }
    }

    // Reset the user's password
    suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): Result<AuthResponse> {
        return handleApiResponse { apiService.resetPassword(resetPasswordRequest) }
    }

    // Change the user's password
    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): Result<AuthResponse> {
        return handleApiResponse { apiService.changePassword(changePasswordRequest) }
    }

    // Confirm the user's email
    suspend fun confirmEmail(token: String): Result<Unit> {
        return handleApiResponse { apiService.confirmEmail(token) }
    }

    // A utility function to handle the API responses
    private inline fun <T> handleApiResponse(apiCall: () -> Response<T>): Result<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.Success(it)
                } ?: Result.Error(ErrorResponse("Empty response body", 0, "error", emptyMap()))
            } else {
                // Parse the error response
                val errorBody = response.errorBody()?.string()
                val errorResponse = try {
                    Gson().fromJson(errorBody, ErrorResponse::class.java)
                } catch (e: Exception) {
                    ErrorResponse("Error parsing response", 0, "error", emptyMap())
                }
                Result.Error(errorResponse)
            }
        } catch (e: Exception) {
            val networkError = ErrorResponse(e.localizedMessage ?: "Network Error", 0, "error", emptyMap())
            Result.Error(networkError)
        }
    }
}
