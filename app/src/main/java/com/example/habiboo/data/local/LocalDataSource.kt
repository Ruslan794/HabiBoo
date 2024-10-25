package com.example.habiboo.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class LocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {

    // Key for storing the JWT token
    companion object {
        private val KEY_JWT_TOKEN = stringPreferencesKey("jwt_token")
    }

    // Save JWT token using DataStore
    suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_JWT_TOKEN] = token
        }
    }

    // Clear the stored JWT token using DataStore
    suspend fun clearToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(KEY_JWT_TOKEN)
        }
    }

    // Retrieve the JWT token using DataStore
    fun getToken(): Flow<String?> {
        return context.dataStore.data
            .map { preferences ->
                preferences[KEY_JWT_TOKEN]
            }
    }
}
