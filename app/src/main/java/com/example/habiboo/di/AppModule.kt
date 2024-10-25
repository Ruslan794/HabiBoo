package com.example.habiboo.di

import android.content.Context
import com.example.habiboo.data.repository.TokenRepositoryImpl
import com.example.habiboo.domain.repository.TokenRepository
import com.example.habiboo.domain.use_case.save_token.SaveTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Предоставление TokenRepository
    @Provides
    @Singleton
    fun provideTokenRepository(@ApplicationContext context: Context): TokenRepository {
        return TokenRepositoryImpl(context)
    }

    // Предоставление SaveTokenUseCase
    @Provides
    fun provideSaveTokenUseCase(tokenRepository: TokenRepository): SaveTokenUseCase {
        return SaveTokenUseCase(tokenRepository)
    }
}
