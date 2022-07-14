package com.example.tes.data.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference (context: Context){
    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences> = applicationContext.createDataStore(
        name = "my_data_store"
    )

    val accessToken: Flow<String?>
        get() = dataStore.data.map{ preferences ->
            preferences[ACCESS_TOKEN]
        }


    suspend fun saveAccessTokens(accessToken: String) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
        }
    }



    companion object {
        private val ACCESS_TOKEN = preferencesKey<String>("key_access_token")
    }
}