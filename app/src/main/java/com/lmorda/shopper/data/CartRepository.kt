package com.lmorda.shopper.data

class CartRepository(private val apiService: CartApiService) {

    suspend fun getCartItems(): List<FoodItem> {
        return apiService.getCartItems()
    }

    suspend fun getOrderTotal(): Double {
        return apiService.getOrderTotal()
    }
}