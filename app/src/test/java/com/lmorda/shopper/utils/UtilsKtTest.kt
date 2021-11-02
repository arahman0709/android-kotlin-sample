package com.lmorda.shopper.utils

import org.junit.Assert.*

import org.junit.Test

class UtilsKtTest {

    @Test
    fun parseISO8601() {
        assertEquals("2021-11-01T14:47:00Z".parseISO8601(), "2:47PM")
        assertEquals("2021-11-01T09:47:00Z".parseISO8601(), "9:47AM")
        assertEquals("2021-11-01T12:47:00Z".parseISO8601(), "12:47PM")
    }
}