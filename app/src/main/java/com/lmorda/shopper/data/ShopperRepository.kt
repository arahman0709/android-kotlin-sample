package com.lmorda.shopper.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.lmorda.shopper.data.models.FoodItem
import com.lmorda.shopper.data.paging.PreviousItemsPagingSource
import com.lmorda.shopper.data.paging.StoreItemsPagingSource
import com.lmorda.shopper.utils.EspressoIdlingResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ShopperRepository(private val apiService: CartApiService) {

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

    // Order details, simulating the map updating, driver status, etc
    fun getOrderDetails(orderNum: Int) = apiService.getArrivalDetails(orderNum)

    // Polling order status after checkout
    private val POLLING_DELAY = 1000L
    val processOrder: Flow<String> =
        flow {
            EspressoIdlingResource.increment()
            while (true) {
                delay(POLLING_DELAY)
                val latestStatus = apiService.getCheckoutStatus()
                emit(latestStatus)
                if (latestStatus == CartApiService.MOCK_STATUSES.last()) break
            }
            EspressoIdlingResource.decrement()
        }
}