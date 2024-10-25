import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenManager(context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "user_prefs")
    private val dataStore = context.dataStore

    companion object {
        private val KEY_JWT_TOKEN = stringPreferencesKey("jwt_token")
    }

    // Сохранить JWT токен
    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_JWT_TOKEN] = token
        }
    }

    // Получить JWT токен
    val tokenFlow: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[KEY_JWT_TOKEN]
        }

    // Удалить JWT токен
    suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences.remove(KEY_JWT_TOKEN)
        }
    }
}
