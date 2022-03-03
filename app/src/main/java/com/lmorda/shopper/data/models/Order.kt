package com.lmorda.shopper.data.models

data class Order(
    val id: Int,
    val date: String,
    val items: List<FoodItem>,
    val total: Double
)
