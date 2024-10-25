package com.example.habiboo.di

import android.content.Context
import com.example.habiboo.common.Constants
import com.example.habiboo.data.local.LocalDataSource
import com.example.habiboo.data.network.services.RoomsApiService
import com.example.habiboo.data.network.services.UserAuthApiService
import com.example.habiboo.data.remote.AuthInterceptor
import com.example.habiboo.data.remote.RemoteDataSource
import com.example.habiboo.data.repository.AuthRepositoryImpl
import com.example.habiboo.data.repository.RoomsRepositoryImpl
import com.example.habiboo.data.repository.TokenRepositoryImpl
import com.example.habiboo.domain.repository.AuthRepository
import com.example.habiboo.domain.repository.RoomsRepository
import com.example.habiboo.domain.repository.TokenRepository
import com.example.habiboo.domain.use_case.get_all_rooms.GetAllRoomsUseCase
import com.example.habiboo.domain.use_case.get_all_rooms.GetMyRoomsUseCase
import com.example.habiboo.domain.use_case.get_token.GetTokenUseCase
import com.example.habiboo.domain.use_case.save_token.SaveTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide RemoteDataSource
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        userAuthApiService: UserAuthApiService,
        roomsApiService: RoomsApiService,
        tokenRepository: TokenRepository
    ): RemoteDataSource {
        return RemoteDataSource(userAuthApiService, roomsApiService, tokenRepository)
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
    fun provideRoomsApiService(retrofit: Retrofit): RoomsApiService {
        return retrofit.create(RoomsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomsRepository(
        remoteDataSource: RemoteDataSource
    ): RoomsRepository {
        return RoomsRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetAllRoomsUseCase(
        roomsRepository: RoomsRepository
    ): GetAllRoomsUseCase {
        return GetAllRoomsUseCase(roomsRepository)
    }

    @Provides
    @Singleton
    fun provideGetMyRoomsUseCase(
        roomsRepository: RoomsRepository
    ): GetMyRoomsUseCase {
        return GetMyRoomsUseCase(roomsRepository)
    }


    @Provides
    @Singleton
    fun provideAuthInterceptor(
        tokenRepository: TokenRepository
    ): AuthInterceptor {
        return AuthInterceptor(tokenRepository)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Установите нужный уровень логирования
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) // Увеличьте при необходимости
            .readTimeout(30, TimeUnit.SECONDS) // Увеличьте при необходимости
            .writeTimeout(30, TimeUnit.SECONDS) // Увеличьте при необходимости
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserAuthApiService(retrofit: Retrofit): UserAuthApiService {
        return retrofit.create(UserAuthApiService::class.java)
    }
}


