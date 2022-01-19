package com.lmorda.shopper.buyagain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.StoreRepository

class BuyAgainViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    val previousItems = storeRepository.storeItems

}