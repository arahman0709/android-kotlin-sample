package com.lmorda.shopper.buyagain

import androidx.lifecycle.ViewModel
import com.lmorda.shopper.data.ShopperRepository

class BuyAgainViewModel(private val shopperRepository: ShopperRepository) : ViewModel() {

    val previousItems = shopperRepository.storeItems

}