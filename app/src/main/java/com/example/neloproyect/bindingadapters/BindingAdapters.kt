package com.example.neloproyect.bindingadapters

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neloproyect.fragmenttransaction.adapters.TransactionsAdapter
import com.example.neloproyect.fragmenttransaction.daos.TransactionsDao
import com.example.neloproyect.loader.LoadingState

@BindingAdapter(value = ["setupVisibility"])
fun ProgressBar.progressVisibility(loadingState: LoadingState?) {
    loadingState?.let {
        isVisible = when(it.status) {
            LoadingState.Status.RUNNING -> true
            LoadingState.Status.SUCCESS -> false
            LoadingState.Status.FAILED -> false
        }
    }

}

@BindingAdapter(value = ["setupRecyclerView"])
 fun setupRecyclerView(view: RecyclerView, ListTransactions: List<TransactionsDao>?) {
    val linearLayoutManager = LinearLayoutManager(view.context)
    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
    ListTransactions?.let {
        view.setHasFixedSize(true)
        view.setLayoutManager(linearLayoutManager)
        view.isNestedScrollingEnabled = true
        view.adapter = TransactionsAdapter(ListTransactions)
        }
    }



