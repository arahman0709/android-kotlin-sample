package com.lmorda.shopper

import com.lmorda.shopper.data.CartRepository
import com.lmorda.shopper.data.StatusRepository
import com.lmorda.shopper.data.StoreRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Assert.*
import org.junit.Test

class ServiceLocatorTest {

    @Test
    fun testProvideStatusRepository() {
        mockkObject(ServiceLocator)
        val repository = mockk<StatusRepository>()
        every { ServiceLocator.provideStatusRepository() } returns repository
        assertEquals(ServiceLocator.provideStatusRepository(), repository)
    }

    @Test
    fun testProvideStoreRepository() {
        mockkObject(ServiceLocator)
        val repository = mockk<StoreRepository>()
        every { ServiceLocator.provideStoreRepository() } returns repository
        assertEquals(ServiceLocator.provideStoreRepository(), repository)
    }


}