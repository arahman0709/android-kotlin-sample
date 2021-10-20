package com.lmorda.shopper.cart

import org.junit.Assert.*

import org.junit.Test

class CartAdapterKtTest {
    @Test
    fun testGetPriceText() {
        var price = 10.00
        assertEquals(price.getPriceText(), "$10.00")
        price = 10.01
        assertEquals(price.getPriceText(), "$10.01")
        price = -1.00
        assertEquals(price.getPriceText(), "$0.00")
        price = 0.0
        assertEquals(price.getPriceText(), "$0.00")
        price = 99.9999
        assertEquals(price.getPriceText(), "$99.99")
        // Anything more than this must be a bug
        price = MAX_PRICE + 1
        assertEquals(price.getPriceText(), "$0.00")
    }
}