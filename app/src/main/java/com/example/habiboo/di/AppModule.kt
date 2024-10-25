package com.example.habiboo.di

import android.content.Context
import com.example.habiboo.common.Constants
import com.example.habiboo.data.local.LocalDataSource
import com.example.habiboo.data.network.services.UserAuthApiService
import com.example.habiboo.data.remote.RemoteDataSource
import com.example.habiboo.data.repository.AuthRepositoryImpl
import com.example.habiboo.data.repository.TokenRepositoryImpl
import com.example.habiboo.domain.repository.AuthRepository
import com.example.habiboo.domain.repository.TokenRepository
import com.example.habiboo.domain.use_case.get_token.GetTokenUseCase
import com.example.habiboo.domain.use_case.save_token.SaveTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide RemoteDataSource
    @Provides
    @Singleton
    fun provideRemoteDataSource(userAuthApiService: UserAuthApiService): RemoteDataSource {
        return RemoteDataSource(userAuthApiService)
    }

    // Provide AuthRepository
    @Provides
    @Singleton
    fun provideAuthRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(remoteDataSource, localDataSource)
    }

    // Provide TokenRepository
    @Provides
    @Singleton
    fun provideTokenRepository(@ApplicationContext context: Context): TokenRepository {
        return TokenRepositoryImpl(context)
    }

    // Provide SaveTokenUseCase
    @Provides
    fun provideSaveTokenUseCase(tokenRepository: TokenRepository): SaveTokenUseCase {
        return SaveTokenUseCase(tokenRepository)
    }

    @Provides
    fun provideGetTokenUseCase(tokenRepository: TokenRepository): GetTokenUseCase {
        return GetTokenUseCase(tokenRepository)
    }

    @Provides
    @Singleton
    fun provideUserAuthApi(): UserAuthApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAuthApiService::class.java)
    }
}


