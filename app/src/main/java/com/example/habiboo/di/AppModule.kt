package com.example.myapplication.di

import com.example.habiboo.domain.repository.TokenRepository
import com.example.habiboo.domain.use_case.save_token.SaveTokenUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// Пример конфигурации с использованием Koin
//val appModule = module {
//
//    // Data Layer: предоставляем TokenRepositoryImpl
//    single<TokenRepository> { TokenRepositoryImpl(context = get()) }
//
//    // Domain Layer: предоставляем SaveTokenUseCase
//    factory { SaveTokenUseCase(tokenRepository = get()) }
//
//    // Presentation Layer: предоставляем AuthViewModel
////    viewModel { AuthViewModel(saveTokenUseCase = get()) }
//}
