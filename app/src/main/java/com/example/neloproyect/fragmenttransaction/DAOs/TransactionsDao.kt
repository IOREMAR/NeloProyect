package com.example.neloproyect.fragmenttransaction.DAOs

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransactionsDao(
    val uuid: Long,
    val merchantUuid: String,
    val merchantName: String,
    val currencyCode: String,
    val amount: Int,
    val timestamp: Long
) : Parcelable

/*
"uuid": "96a6ccbb-0de6-4641-b089-276ff8c0622d",
"merchantUuid": "64deb0be-668d-4218-83d1-174496601483",
"merchantName": "Starbucks Coffee",
"currencyCode": "USD",
"amount": 400,
"timestamp": 1611847753*/
