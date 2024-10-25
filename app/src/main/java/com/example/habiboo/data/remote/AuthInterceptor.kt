package com.example.habiboo.data.remote


import com.example.habiboo.domain.repository.TokenRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenRepository: TokenRepository
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        if (originalRequest.headers("Authorization").isNotEmpty()) {
            return chain.proceed(originalRequest)
        }
        val token = tokenRepository.getCachedToken()

        val authenticatedRequest = if (!token.isNullOrEmpty()) {
            originalRequest.newBuilder()
                .header("Authorization", "Bearer $token") // Используем 'header' для замены
                .build()
        } else {
            originalRequest
        }

        return chain.proceed(authenticatedRequest)
    }
}

