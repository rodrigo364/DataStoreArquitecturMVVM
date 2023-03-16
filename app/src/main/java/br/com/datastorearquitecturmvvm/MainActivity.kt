package br.com.datastorearquitecturmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.datastorearquitecturmvvm.viewmodel.MainViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val activityViewModel : MainViewModel by  viewModels()
    private lateinit var  dataStoreAdapter :DataStoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val mock = DataUser("RODRIGO","31 986752229","Av Londrina, 59 - Ipatinga/MG")
        activityViewModel.saveDataUser(mock)
        activityViewModel.getDataUser()
        activityViewModel.dataUser.observe(this) { user ->
            user?.let {
                dataStoreAdapter = DataStoreAdapter(it)
                recyclerView.adapter = dataStoreAdapter


            }

        }

    }
}