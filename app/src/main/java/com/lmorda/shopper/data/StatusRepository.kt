package com.lmorda.shopper.data

import com.lmorda.shopper.utils.EspressoIdlingResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StatusRepository(private val apiService: CartApiService) {

    // Wait 1 second and fetch again
    private val POLLING_DELAY = 1000L

    // Polling
    val processOrder: Flow<String> =
        flow {
            EspressoIdlingResource.increment()
            while (true) {
                delay(POLLING_DELAY)
                val latestStatus = apiService.getOrderStatus()
                emit(latestStatus)
                if (latestStatus == CartApiService.MOCK_STATUSES.last()) break
            }
            EspressoIdlingResource.decrement()
        }
}