package com.lmorda.shopper.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.CartRepository
import com.lmorda.shopper.data.StoreRepository

class CartViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    fun getCartItems() = liveData {
        emit(storeRepository.getCartItems())
    }

    fun getOrderTotal() = liveData {
        emit(storeRepository.getOrderTotal())
    }
}