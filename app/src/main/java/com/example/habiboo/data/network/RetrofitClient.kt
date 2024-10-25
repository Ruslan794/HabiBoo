package com.example.habiboo.data.network


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://your-api-base-url.com/" // Replace with your actual base URL

    // Create an OkHttpClient instance for custom configurations (if needed)
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    // Create a Retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter for JSON serialization
        .build()

    // Generic function to create the service
    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}
