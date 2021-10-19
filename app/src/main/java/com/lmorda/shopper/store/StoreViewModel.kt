package com.lmorda.shopper.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.data.StoreRepository

class StoreViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    val storeItems = storeRepository.storeItems

    fun getCartItems() = liveData {
        emit(storeRepository.getCartNum())
    }

    fun createOrder(items: List<FoodItem>?) =  liveData {
        items?.let {
            emit(storeRepository.createOrder(items))
        } ?: emit(false)
    }
}
