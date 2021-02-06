package com.example.neloproyect.fragmenttransaction

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neloproyect.fragmenttransaction.daos.TransactionsDao
import com.example.neloproyect.loader.LoadingState
import com.example.neloproyect.utils.singleArgViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class TransactionViewModel (private val repository :  TransactionsRespository ) : ViewModel() {

   private var MutableListTransactions : MutableLiveData<List<TransactionsDao>?>  = MutableLiveData()

    val LiveListTransactions :  LiveData<List<TransactionsDao>?> get() = MutableListTransactions

    private val _loading = MutableLiveData<LoadingState>()

    val loading: LiveData<LoadingState> get() = _loading


    private val _txtMensaje = MutableLiveData<String>()

    val txtMensaje: LiveData<String> get() = _txtMensaje

    companion   object {
        /**
         * Factory for creating [TransactionViewModel]
         *
         * @param arg the repository to pass to [TransactionViewModel]
         */
        val FACTORY = singleArgViewModelFactory(::TransactionViewModel)
    }


    /**
     * Implements the consult of ListTransactions with the LiveData connection.
      */
    fun listTransactions(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loading.postValue(LoadingState.LOADING)
                val listTransacitonsvar = repository.getListTransactions()
                MutableListTransactions.postValue(listTransacitonsvar)
                _loading.postValue(LoadingState.LOADED)
            }
            catch ( exe : Exception){
                Log.e("Error",exe.message!!)
                _txtMensaje.postValue(exe.message)
                _loading.postValue(LoadingState.error(exe.message))
            }

        }
    }

}