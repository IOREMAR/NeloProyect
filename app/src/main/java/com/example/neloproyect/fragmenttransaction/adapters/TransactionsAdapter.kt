package com.example.neloproyect.fragmenttransaction.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neloproyect.databinding.TransactionsItemBinding
import com.example.neloproyect.fragmenttransaction.daos.TransactionsDao
import java.text.SimpleDateFormat
import java.util.*

class TransactionsAdapter (private val data : List<TransactionsDao>) : RecyclerView.Adapter<TransactionsAdapter.ViewHolderAdapter>() {

    inner class ViewHolderAdapter(val binding: TransactionsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TransactionsDao?) {
            binding.dataItem = item
            binding.txtDate.text = getDateTime(item!!.timestamp)
            binding.executePendingBindings()
        }

        private fun getDateTime( timeStamp: Long): String? {
            try {
                val sdf = SimpleDateFormat("MM/dd/yyyy")
                val netDate = Date(timeStamp)
                return sdf.format(netDate)
            } catch (e: Exception) {
                return e.toString()
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TransactionsItemBinding.inflate(inflater,parent,true)
        return ViewHolderAdapter(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) = holder.bind(data.get(position))

    override fun getItemCount(): Int = data.size



}