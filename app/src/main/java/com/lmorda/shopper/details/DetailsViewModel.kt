package com.lmorda.shopper.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.FOOD_ITEM_ID_ARG
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.data.StoreRepository
import com.lmorda.shopper.status.StatusViewModel

class DetailsViewModel(
    private val storeRepository: StoreRepository,
    private val state: SavedStateHandle
): ViewModel() {

    var itemId: Int? = null

    init {
        itemId = state.get(FOOD_ITEM_ID_ARG)
    }

    val foodItem = liveData {
        emit(storeRepository.getFoodDetails(itemId))
    }

}