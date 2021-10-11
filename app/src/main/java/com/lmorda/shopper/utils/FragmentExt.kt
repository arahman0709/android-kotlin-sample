package com.lmorda.shopper.utils

import androidx.fragment.app.Fragment
import com.lmorda.shopper.ServiceLocator
import com.lmorda.shopper.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val cartRepo = ServiceLocator.provideCartRepository()
    val statusRepo = ServiceLocator.provideStatusRepository()
    val storeRepo = ServiceLocator.provideStoreRepository()
    return ViewModelFactory(cartRepo, statusRepo, storeRepo, this)
}