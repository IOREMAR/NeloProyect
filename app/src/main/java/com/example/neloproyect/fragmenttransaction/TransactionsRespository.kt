package com.example.neloproyect.fragmenttransaction

import android.util.Log

import com.example.neloproyect.fragmenttransaction.daos.TransactionsDao
import com.google.gson.stream.MalformedJsonException
import kotlinx.coroutines.CompletableDeferred



class TransactionsRespository {

    private val Network = TransactionNetwork

    /**
     * @getlistTransactions made the networkTransactions and handle the errors for RestApi.
     */
    suspend fun getListTransactions() : List<TransactionsDao>? {

        val listTransactions = CompletableDeferred<List<TransactionsDao>?>()

        try {
            val NetworkListBank = Network.getTransactionsService()
            if(NetworkListBank.transactions.isNotEmpty()) {
                listTransactions.complete(NetworkListBank.transactions)
            }else{
                throw RuntimeException("No existen transacciones")
            }
        }catch (exe : MalformedJsonException){
            Log.e("Error",exe.message!!)
            throw Exception("Favor de Intentarlo Mas Tarde")
        }
        catch (exe: RuntimeException){
            Log.e("Error",exe.message!!)
            throw exe
        }
        return listTransactions.await()
    }

}