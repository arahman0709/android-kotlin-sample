package com.lmorda.shopper.cart

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lmorda.shopper.MainCoroutineRule
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.data.StoreRepository
import com.lmorda.shopper.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CartViewModelTest {

    private lateinit var viewModel: CartViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testGetItems() {
        val mockRepository = mockk<StoreRepository>()
        viewModel = CartViewModel(mockRepository)
        coEvery { mockRepository.getCartItems() } returns
                listOf(FoodItem(0, 10.00, "Food", 0))
        viewModel.getCartItems().observeForever { }
        assertEquals(
            viewModel.getCartItems().getOrAwaitValue(),
            listOf(FoodItem(0, 10.00, "Food", 0))
        )
    }

    @Test
    fun testGetOrderTotal() {
        val mockRepository = mockk<StoreRepository>()
        viewModel = CartViewModel(mockRepository)
        coEvery { mockRepository.getOrderTotal() } returns 10.00
        viewModel.getOrderTotal().observeForever { }
        assertEquals(
            viewModel.getOrderTotal().getOrAwaitValue(),
            10.00, 0.0
        )
    }
}