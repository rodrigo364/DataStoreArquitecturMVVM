package br.com.datastorearquitecturmvvm.repository
import br.com.datastorearquitecturmvvm.DataUser
import kotlinx.coroutines.flow.Flow

interface UserDataStore {
    suspend fun saveDataUser(userData: DataUser)

    suspend fun getDataUser() : Flow<DataUser>
}