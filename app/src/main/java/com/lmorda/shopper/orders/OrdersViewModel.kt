package com.lmorda.shopper.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.ShopperRepository

class OrdersViewModel(private val shopperRepository: ShopperRepository) : ViewModel() {

    fun getOrders() = liveData {
        emit(shopperRepository.getOrders())
    }

}