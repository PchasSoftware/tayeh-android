package ir.pchas.tayehclient.repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

public data class AppPreferences(val token: String, val loginStatus: Boolean)

@Singleton
public class PreferencesManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

    internal val preferencesFlow = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e("PreferencesManager", "Error reading preferences", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val token = preferences[PreferencesKeys.TOKEN] ?: ""
            val loginStatus = preferences[PreferencesKeys.LOGIN_STATUS] ?: false
            AppPreferences(token, loginStatus)
        }

    public suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.TOKEN] = token
        }
    }

    public suspend fun saveLoginStatus(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.LOGIN_STATUS] = isLoggedIn
        }
    }

    private object PreferencesKeys {
        val TOKEN = stringPreferencesKey("token")
        val LOGIN_STATUS = booleanPreferencesKey("login_status")
    }
}