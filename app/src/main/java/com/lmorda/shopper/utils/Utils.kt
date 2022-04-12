package com.lmorda.shopper.utils

import java.text.SimpleDateFormat
import java.util.*

val ISO_8601 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
val TIMESTAMP = SimpleDateFormat("MMMM d h:mmaa", Locale.getDefault())
fun String.parseISO8601(): String {
    return try {
        ISO_8601.parse(this)?.let { TIMESTAMP.format(it) } ?: ""
    } catch (ex: Exception) {
        ""
    }
}