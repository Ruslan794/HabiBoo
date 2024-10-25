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

    // Ключ для хранения JWT токена
    companion object {
        private val KEY_JWT_TOKEN = stringPreferencesKey("jwt_token")
    }

    // Сохранение JWT токена
    override suspend fun saveToken(token: String) {
        try {
            context.dataStore.edit { preferences ->
                preferences[KEY_JWT_TOKEN] = token
            }
        } catch (e: Exception) {
            // Log error or handle it accordingly
        }
    }

    override suspend fun getToken(): String? {
        return try {
            context.dataStore.data
                .map { preferences ->
                    preferences[KEY_JWT_TOKEN]
                }
                .first()
        } catch (e: Exception) {
            // Log error or handle it accordingly
            null
        }
    }

    override suspend fun clearToken() {
        try {
            context.dataStore.edit { preferences ->
                preferences.remove(KEY_JWT_TOKEN)
            }
        } catch (e: Exception) {
            // Log error or handle it accordingly
        }
    }

    // Optional: Expose token as a Flow
    fun getTokenFlow(): Flow<String?> {
        return context.dataStore.data
            .map { preferences ->
                preferences[KEY_JWT_TOKEN]
            }
    }

}
