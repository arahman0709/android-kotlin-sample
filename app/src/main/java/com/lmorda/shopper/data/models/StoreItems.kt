package com.lmorda.shopper.data.models

import com.lmorda.shopper.data.models.FoodItem

data class StoreItems(
    val items: List<FoodItem>,
    val nextPage: Int?
)