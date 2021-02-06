package com.example.neloproyect

import com.example.neloproyect.fragmenttransaction.TransactionNetwork
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UnitTestClass {
    
    @Test
     fun TransactionsTest () = runBlocking {

        val NetworkTransaction  = TransactionNetwork

        val api = NetworkTransaction.TransactionsService
        //You Can Change the Service and The Assert for Difrent services
        var ResponseService = api.getTransactions("https://storage.googleapis.com/nelo-assigment/api/transactions.json")

        assert(ResponseService.transactions.isNotEmpty())
    }
}