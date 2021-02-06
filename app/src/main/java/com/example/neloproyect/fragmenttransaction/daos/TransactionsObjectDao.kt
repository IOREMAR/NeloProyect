package com.example.neloproyect.fragmenttransaction.daos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * @TransactionsObjectDao  Transactions Object That Contains the List Of Transactions.
 */
@Parcelize
data class TransactionsObjectDao(
    @SerializedName("transactions")
    val transactions : List<TransactionsDao>
) : Parcelable
