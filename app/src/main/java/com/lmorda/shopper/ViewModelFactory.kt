package com.lmorda.shopper

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.lmorda.shopper.cart.CartViewModel
import com.lmorda.shopper.data.StatusRepository
import com.lmorda.shopper.data.StoreRepository
import com.lmorda.shopper.details.DetailsViewModel
import com.lmorda.shopper.order.OrderDetailsViewModel
import com.lmorda.shopper.status.StatusViewModel
import com.lmorda.shopper.store.StoreViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val statusRepository: StatusRepository,
    private val storeRepository: StoreRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(CartViewModel::class.java) -> CartViewModel(storeRepository)
            isAssignableFrom(DetailsViewModel::class.java) -> DetailsViewModel(storeRepository, handle)
            isAssignableFrom(StatusViewModel::class.java) -> StatusViewModel(statusRepository)
            isAssignableFrom(StoreViewModel::class.java) -> StoreViewModel(storeRepository)
            isAssignableFrom(OrderDetailsViewModel::class.java) -> OrderDetailsViewModel(storeRepository, handle)
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}