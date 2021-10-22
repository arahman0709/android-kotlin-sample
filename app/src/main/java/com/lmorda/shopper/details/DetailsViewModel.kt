package com.lmorda.shopper.details

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.data.StoreRepository
import com.lmorda.shopper.status.StatusViewModel

class DetailsViewModel(private val storeRepository: StoreRepository): ViewModel() {

    var forceRefresh = true

    fun foodItem(itemId: Int?) = liveData {
        emit(storeRepository.getFoodDetails(itemId, forceRefresh))
        forceRefresh = false
    }

}