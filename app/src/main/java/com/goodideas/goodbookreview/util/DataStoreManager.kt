package com.goodideas.goodbookreview.util

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = Constant.DataStoreNameToken)

class DataStoreManager @Inject constructor(
    context: Context
) {
    private val dataStore = context.dataStore

    suspend fun write(key: String, value: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[
                    stringPreferencesKey(key)
            ] = Constant.TokenPrefix + value
        }
    }

    suspend fun read(key: String) {
        return dataStore.data.first().let { it[stringPreferencesKey(key)] }
    }

    suspend fun clear(key: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences.remove(stringPreferencesKey(key))
        }
    }
}