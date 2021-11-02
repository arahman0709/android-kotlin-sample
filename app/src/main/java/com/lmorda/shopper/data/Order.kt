package com.lmorda.shopper.data

data class Order (
    val orderNum: Int,
    val status: String,
    val arrivalFirst: String,
    val arrivalSecond: String,
    val statusDetails: String,
    val storeName: String
)
