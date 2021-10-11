package com.lmorda.shopper.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.CartRepository

class CartViewModel(private val cartRepository: CartRepository) : ViewModel() {

    fun getCartItems() = liveData {
        emit(cartRepository.getCartItems())
    }

    fun getOrderTotal() = liveData {
        emit(cartRepository.getOrderTotal())
    }
}