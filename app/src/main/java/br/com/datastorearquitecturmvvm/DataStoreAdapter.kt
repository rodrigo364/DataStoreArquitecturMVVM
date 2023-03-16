package br.com.datastorearquitecturmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataStoreAdapter(private val dataStore:  DataUser) :
    RecyclerView.Adapter<DataStoreAdapter.DataStoreViewHolder>() {

    class DataStoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = view.findViewById(R.id.txtName)
        private val txtPhone: TextView = view.findViewById(R.id.txtPhone)
        private val txtAddress: TextView = view.findViewById(R.id.txtAddress)
        private var currentDataUser : DataUser? = null

            fun bind(dataUser: DataUser) {
                currentDataUser = dataUser
                txtName.text = currentDataUser?.name ?: ""
                txtPhone.text = currentDataUser?.phone ?: ""
                txtAddress.text = currentDataUser?.address ?: ""
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataStoreViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.view_data_store_user,parent,false)

        return DataStoreViewHolder(view)

    }

    override fun getItemCount(): Int {
       return 1
    }

    override fun onBindViewHolder(holder: DataStoreViewHolder, position: Int) {

        holder.bind(dataStore)
    }


}