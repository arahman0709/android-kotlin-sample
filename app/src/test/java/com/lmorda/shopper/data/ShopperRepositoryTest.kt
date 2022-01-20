package com.lmorda.shopper.data

import android.text.TextUtils
import io.mockk.every
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.*
import org.junit.Test

class ShopperRepositoryTest {

    @Test
    fun testOrderStatusFlow(): Unit = runBlocking {
        val repository = ShopperRepository(CartApiService())
        val statuses = repository.processOrder.toList()
        assertThat(statuses).isEqualTo(CartApiService.MOCK_STATUSES)
    }
}