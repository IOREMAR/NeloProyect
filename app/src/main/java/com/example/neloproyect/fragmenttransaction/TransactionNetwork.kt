package com.example.neloproyect.fragmenttransaction

import com.example.neloproyect.fragmenttransaction.daos.TransactionsObjectDao
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


object TransactionNetwork {

    private val URL_Serivce = "https://storage.googleapis.com/nelo-assigment/api/transactions.json"


    lateinit var TransactionsService: TransactionsApi

    init {
        createTransactionService()
    }

    /**
     * Creates the Retrofit Client Prepare the TransactionService to Use.
     */
    private fun createTransactionService() {

        // Creamos un interceptor y le indicamos el log level a usar
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        // Asociamos el interceptor a las peticiones
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl("http://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        TransactionsService = retrofit.create(TransactionsApi::class.java)
    }

    suspend fun getTransactionsService()  : TransactionsObjectDao {
        return TransactionsService.getTransactions(URL_Serivce)
    }

    interface  TransactionsApi {
        @GET
        suspend fun getTransactions(@Url UrlService: String): TransactionsObjectDao
    }

}