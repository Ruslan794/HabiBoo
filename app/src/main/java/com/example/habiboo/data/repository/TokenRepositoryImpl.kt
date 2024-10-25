package com.example.habiboo.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.habiboo.domain.repository.TokenRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

// Data Layer: реализация TokenRepository
class TokenRepositoryImpl(private val context: Context) : TokenRepository {

    // Ключ для хранения JWT токена
    companion object {
        private val KEY_JWT_TOKEN = stringPreferencesKey("jwt_token")
    }

    // Сохранение JWT токена
    override suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_JWT_TOKEN] = token
        }
    }

    // Получение JWT токена
    override suspend fun getToken(): String? {
        return context.dataStore.data
            .map { preferences ->
                preferences[KEY_JWT_TOKEN]
            }
            .first()
    }

    // Удаление JWT токена
    override suspend fun clearToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(KEY_JWT_TOKEN)
        }
    }
}
