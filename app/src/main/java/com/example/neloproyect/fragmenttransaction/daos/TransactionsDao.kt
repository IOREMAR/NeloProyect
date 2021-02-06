package com.example.neloproyect.fragmenttransaction.daos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @TransactionsDao Is the TransactionObject. :
 * @uuid :The uuid representing the transaction.
 * @merchantUuid :The uuid representing the merchant.
 * @merchantName :Merchant Name
 * @currencyCode :The currency code of the transaction.
 * @amount :Amount
 * @timestamp :The timestamp UTC of the transaction.
 */
@Parcelize
data class TransactionsDao(
    val uuid: String,
    val merchantUuid: String,
    val merchantName: String,
    val currencyCode: String,
    val amount: Int,
    val timestamp: Long
) : Parcelable
