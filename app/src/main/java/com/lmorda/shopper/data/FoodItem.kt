package com.lmorda.shopper.data

data class FoodItem(
    val id: Int,
    val price: Double,
    val name: String,
    var imageRes: Int,
    var inCart: Boolean = false
)