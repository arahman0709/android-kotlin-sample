package com.lmorda.shopper.order

import androidx.lifecycle.*
import com.lmorda.shopper.ORDER_ID_ARG
import com.lmorda.shopper.data.Order
import com.lmorda.shopper.data.StoreRepository

class OrderViewModel(val storeRepository: StoreRepository, val state: SavedStateHandle): ViewModel() {

    var orderId: Int? = -1

    init {
        if (orderId == -1) orderId = state.get<Int>(ORDER_ID_ARG)
    }

    val orderDetails = storeRepository.getOrderDetails(state.get<Int>(ORDER_ID_ARG) ?: -1)

}