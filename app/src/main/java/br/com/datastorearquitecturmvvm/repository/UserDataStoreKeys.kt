package br.com.datastorearquitecturmvvm.repository

import androidx.datastore.preferences.core.stringPreferencesKey

object UserDataStoreKeys {
    val NAME = stringPreferencesKey("NAME")
    val PHONE_NUMBER = stringPreferencesKey("PHONE")
    val address = stringPreferencesKey("ADDRESS")
}