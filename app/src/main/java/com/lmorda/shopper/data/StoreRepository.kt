package com.lmorda.shopper.data

import androidx.paging.Pager
import androidx.paging.PagingConfig

class StoreRepository(private val apiService: CartApiService) {

    var lastFetchedFoodItem: FoodItem? = null

    val storeItems = Pager(PagingConfig(pageSize = 10)) {
        StorePagingSource(apiService)
    }.flow

    suspend fun getFoodDetails(foodItemId: Int?, forceRefresh: Boolean): FoodItem? {
        if (forceRefresh) lastFetchedFoodItem = apiService.getFoodItemDetails(foodItemId)
        return lastFetchedFoodItem
    }

    suspend fun getCartNum(): Int {
        return apiService.getCartItems().size
    }

    suspend fun createOrder(items: List<FoodItem>) = apiService.createOrder(items)

}