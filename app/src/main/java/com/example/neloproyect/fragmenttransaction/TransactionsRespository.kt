package com.example.neloproyect.fragmenttransaction

import com.example.neloproyect.fragmenttransaction.DAOs.TransactionsDao
import kotlinx.coroutines.CompletableDeferred
import java.lang.Exception

class TransactionsRespository {

    private val Network = TransactionNetwork


    suspend fun getListTransactions() : List<TransactionsDao>? {

        var listTransactions = CompletableDeferred<List<TransactionsDao>?>()

        try {
            var NetworkListBank = Network.getTransactionsService()
            listTransactions.complete(NetworkListBank)
        }catch (exe : Exception){
            throw exe
        }
        return listTransactions.await()
    }


}