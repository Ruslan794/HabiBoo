package com.example.habiboo.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.habiboo.domain.repository.TokenRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

@Singleton
class TokenRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : TokenRepository {

    companion object {
        private val KEY_JWT_TOKEN = stringPreferencesKey("jwt_token")
    }

    // Переменная для кеширования токена в памяти
    @Volatile
    private var cachedToken: String? = null

    override suspend fun saveToken(token: String) {
        try {
            context.dataStore.edit { preferences ->
                preferences[KEY_JWT_TOKEN] = token
            }
            cachedToken = token // Обновляем кеш
        } catch (e: Exception) {
            // Обработка ошибки
        }
    }

    override suspend fun getToken(): String? {
        return try {
            cachedToken ?: context.dataStore.data
                .map { preferences ->
                    preferences[KEY_JWT_TOKEN]
                }
                .first()
                .also { token ->
                    cachedToken = token // Кешируем токен
                }
        } catch (e: Exception) {
            // Обработка ошибки
            null
        }
    }

    override suspend fun clearToken() {
        try {
            context.dataStore.edit { preferences ->
                preferences.remove(KEY_JWT_TOKEN)
            }
            cachedToken = null // Очищаем кеш
        } catch (e: Exception) {
            // Обработка ошибки
        }
    }

    override fun getCachedToken(): String? {
        return cachedToken
    }
}
