package br.com.datastorearquitecturmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.datastorearquitecturmvvm.DataUser
import br.com.datastorearquitecturmvvm.repository.UserDataStore
import br.com.datastorearquitecturmvvm.repository.UserDataStoreImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userDataStoreRepository: UserDataStoreImpl) : ViewModel()
{
    var dataUser: MutableLiveData<DataUser> = MutableLiveData()

    fun saveDataUser(dataStore: DataUser) {
        viewModelScope.launch(Dispatchers.IO) {
            userDataStoreRepository.saveDataUser(dataStore)
        }
    }

    fun getDataUser() {
        viewModelScope.launch(Dispatchers.IO) {
           userDataStoreRepository.getDataUser().collect(){
               dataUser.postValue(it)
           }
        }
    }
}