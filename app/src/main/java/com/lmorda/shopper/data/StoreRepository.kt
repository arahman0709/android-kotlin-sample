package com.lmorda.shopper.data

import androidx.paging.Pager
import androidx.paging.PagingConfig

class StoreRepository(private val apiService: CartApiService) {

    val storeItems = Pager(PagingConfig(pageSize = 10)) {
        StoreItemsPagingSource(apiService)
    }.flow

    val previousItems = Pager(PagingConfig(pageSize = 10)) {
        PreviousItemsPagingSource(apiService)
    }.flow

    suspend fun getFoodDetails(foodItemId: Int?): FoodItem? {
        return apiService.getFoodItemDetails(foodItemId)
    }

    suspend fun updateCart(foodItem: FoodItem, isAdd: Boolean): Boolean {
        if (isAdd) apiService.addItemToCart(foodItem)
        else apiService.removeItemFromCart(foodItem)
        return true
    }

    suspend fun getCartItems() = apiService.getCartItems()
    suspend fun getCartNum() = apiService.getCartItems().size
    suspend fun getOrderTotal() = apiService.getOrderTotal()
    suspend fun createOrder() = apiService.createOrder()
    fun getOrderDetails(orderNum: Int) = apiService.getOrderDetails(orderNum)

}