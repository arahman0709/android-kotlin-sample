package com.lmorda.shopper.data

import android.text.TextUtils
import io.mockk.every
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.*
import org.junit.Test

class StatusRepositoryTest {

    @Test
    fun testOrderStatusFlow(): Unit = runBlocking {
        val repository = StatusRepository(CartApiService())
        val statuses = repository.processOrder.toList()
        assertThat(statuses).isEqualTo(CartApiService.MOCK_STATUSES)
    }
}