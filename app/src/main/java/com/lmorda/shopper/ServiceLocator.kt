package com.lmorda.shopper

import com.lmorda.shopper.data.CartApiService
import com.lmorda.shopper.data.CartRepository
import com.lmorda.shopper.data.StatusRepository
import com.lmorda.shopper.data.StoreRepository

object ServiceLocator {

    @Volatile
    var cartRepository: CartRepository? = null

    @Volatile
    var statusRepository: StatusRepository? = null

    @Volatile
    var storeRepository: StoreRepository? = null

    @Volatile
    var cartApiService: CartApiService? = null


    fun provideCartRepository(): CartRepository {
        synchronized(this) {
            return cartRepository ?: createCartRepository()
        }
    }

    fun provideStatusRepository(): StatusRepository {
        synchronized(this) {
            return statusRepository ?: createStatusRepository()
        }
    }

    fun provideStoreRepository(): StoreRepository {
        synchronized(this) {
            return storeRepository ?: createStoreRepository()
        }
    }

    private fun provideCartApiService(): CartApiService {
        synchronized(this) {
            return cartApiService ?: createMockApiService()
        }
    }

    private fun createCartRepository(): CartRepository {
        val cartRepository = CartRepository(provideCartApiService())
        this.cartRepository = cartRepository
        return cartRepository
    }

    private fun createStatusRepository(): StatusRepository {
        val statusRepository = StatusRepository(provideCartApiService())
        this.statusRepository = statusRepository
        return statusRepository
    }

    private fun createStoreRepository(): StoreRepository {
        val storeRepository = StoreRepository(provideCartApiService())
        this.storeRepository = storeRepository
        return storeRepository
    }

    private fun createMockApiService(): CartApiService {
        val cartService = CartApiService()
        this.cartApiService = cartService
        return cartService
    }

}