package com.example.neloproyect.bindingadapters

import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neloproyect.fragmenttransaction.adapters.TransactionsAdapter
import com.example.neloproyect.fragmenttransaction.daos.TransactionsDao
import com.example.neloproyect.loader.LoadingState


/**
 * @setupVisibility Is the Binding Adapter That Uses the state of the result Transaction Passed by ViewModel
 * to handle the @Visibility for the Loader.
 */
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

/**
 * @setupRecyclerView Is the Binding Adapter that recives the List Of Transactions. and set the Adapter for
 * the RecyclcerView
 */
@BindingAdapter(value = ["setupRecyclerView"])
 fun setupRecyclerView(view: RecyclerView, ListTransactions: List<TransactionsDao>?) {
    val linearLayoutManager = LinearLayoutManager(view.context)
    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
    linearLayoutManager.setAutoMeasureEnabled(true)
    ListTransactions?.let {
        view.setNestedScrollingEnabled(false)
        view.setHasFixedSize(false)
        view.setLayoutManager(linearLayoutManager)
        view.adapter = TransactionsAdapter(ListTransactions)
        }
    }


/**
 * @setupVisibilityTextView  Is the Binding Adapter That Uses the state of the result Transaction Passed by ViewModel
 * to handle the @Visibility for the Error Message
 */
@BindingAdapter(value = ["setupVisibilityTextView"])
fun setupVisibilityTextView(view: TextView , loadingState: LoadingState?) {
    loadingState?.let {
         view.isVisible  = when(it.status) {
            LoadingState.Status.RUNNING -> false
            LoadingState.Status.SUCCESS -> false
            LoadingState.Status.FAILED -> true
        }
    }

}






