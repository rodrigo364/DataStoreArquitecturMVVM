package br.com.datastorearquitecturmvvm.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import br.com.datastorearquitecturmvvm.DataUser
import br.com.datastorearquitecturmvvm.repository.UserDataStoreKeys.NAME
import br.com.datastorearquitecturmvvm.repository.UserDataStoreKeys.PHONE_NUMBER
import br.com.datastorearquitecturmvvm.repository.UserDataStoreKeys.address
import kotlinx.coroutines.flow.map

const val DataStore_NAME = "DATAUSERNAME"

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)

class UserDataStoreImpl(private val context: Context) : UserDataStore {

    override suspend fun saveDataUser(userData: DataUser) {
        context.datastore.edit { store ->
            store[NAME] = userData.name
            store[PHONE_NUMBER] = userData.phone
            store[address]  = userData.address
        }
    }

    override suspend fun getDataUser()= context.datastore.data.map { store ->
        DataUser(
            name = store[NAME] ?: "",
            phone = store[PHONE_NUMBER] ?: "",
            address = store[address] ?: ""

        )
    }
}