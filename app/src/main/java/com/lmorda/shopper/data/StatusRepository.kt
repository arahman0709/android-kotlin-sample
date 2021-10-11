package com.lmorda.shopper.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StatusRepository(private val apiService: CartApiService) {

    // Polling
    val processOrder: Flow<String> = flow {
        while (true) {
            delay(1000) // Wait 1 second and fetch again
            val latestStatus = apiService.getOrderStatus()
            emit(latestStatus)
            if (latestStatus == CartApiService.MOCK_STATUSES.last()) break
        }
    }
}