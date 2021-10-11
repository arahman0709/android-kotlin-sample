package com.lmorda.shopper.data

data class StoreItems(
    val items: List<FoodItem>,
    val nextPage: Int?
)