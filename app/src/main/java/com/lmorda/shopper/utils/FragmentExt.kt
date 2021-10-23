package com.lmorda.shopper.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import com.lmorda.shopper.ServiceLocator
import com.lmorda.shopper.ViewModelFactory

fun Fragment.getViewModelFactory(arguments: Bundle? = null): AbstractSavedStateViewModelFactory {
    val cartRepo = ServiceLocator.provideCartRepository()
    val statusRepo = ServiceLocator.provideStatusRepository()
    val storeRepo = ServiceLocator.provideStoreRepository()
    return ViewModelFactory(cartRepo, statusRepo, storeRepo, this, arguments)
}