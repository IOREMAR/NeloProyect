package com.example.neloproyect.fragmenttransaction.daos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransactionsObjectDao(
    @SerializedName("transactions")
    val transactions : List<TransactionsDao>
) : Parcelable
