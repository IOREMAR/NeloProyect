package com.example.neloproyect.fragmenttransaction

import com.example.neloproyect.fragmenttransaction.daos.TransactionsDao
import kotlinx.coroutines.CompletableDeferred
import java.lang.Exception

class TransactionsRespository {

    private val Network = TransactionNetwork

    @Throws (Exception::class)
    suspend fun getListTransactions() : List<TransactionsDao>? {

        val listTransactions = CompletableDeferred<List<TransactionsDao>?>()

        try {
            val NetworkListBank = Network.getTransactionsService()
            listTransactions.complete(NetworkListBank.transactions)
        }catch (exe : Exception){
            throw exe
        }
        return listTransactions.await()
    }

}