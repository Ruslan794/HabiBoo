package com.example.habiboo.data.repository

import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.model.User
import com.example.habiboo.domain.repository.AuthRepository
import com.example.habiboo.data.local.LocalDataSource
import com.example.habiboo.data.remote.RemoteDataSource
import retrofit2.Response

class AuthRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : AuthRepository {

    override suspend fun signIn(email: String, password: String): Response<AuthResponse> {
        return remoteDataSource.signIn(email, password)
    }

    override suspend fun signUp(email: String, username: String, password: String): Result<User> {
        return try {
            // Make a remote call to sign up and retrieve the user data
            val user = remoteDataSource.signUp(email, username, password)

            // Return the User object wrapped in Result
            Result.success(user)
        } catch (exception: Exception) {
            // Return failure if something goes wrong
            Result.failure(exception)
        }
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            // Remove the locally stored JWT token
            localDataSource.clearToken()

            // Optionally perform a remote sign-out if necessary
            remoteDataSource.signOut()

            // Return success
            Result.success(Unit)
        } catch (exception: Exception) {
            // Return failure if something goes wrong
            Result.failure(exception)
        }
    }
}
