package com.lmorda.shopper.data

import androidx.paging.Pager
import androidx.paging.PagingConfig

class StoreRepository(private val apiService: CartApiService) {

    val storeItems = Pager(PagingConfig(pageSize = 10)) {
        StorePagingSource(apiService)
    }.flow

    suspend fun getFoodDetails(foodItemId: Int?): FoodItem? {
        return apiService.getFoodItemDetails(foodItemId)
    }

    suspend fun updateCart(foodItem: FoodItem, isAdd: Boolean): Boolean {
        if (isAdd) apiService.addItemToCart(foodItem)
        else apiService.removeItemFromCart(foodItem)
        return true
    }

    suspend fun getCartItems(): List<FoodItem> {
        return apiService.getCartItems()
    }

    suspend fun getCartNum(): Int {
        return apiService.getCartItems().size
    }

    suspend fun getOrderTotal(): Double {
        return apiService.getOrderTotal()
    }

    suspend fun createOrder() = apiService.createOrder()

    suspend fun getOrder(orderId: Int?) = Order("Order Name")

}