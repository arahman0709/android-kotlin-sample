package com.lmorda.shopper.utils

import java.text.SimpleDateFormat

val ISO_8601 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
val TIMESTAMP = SimpleDateFormat("MMMM dd h:mmaa")
fun String.parseISO8601(): String {
    try {
        return ISO_8601.parse(this)?.let { TIMESTAMP.format(it) } ?: ""
    } catch (ex: Exception) {
        return ""
    }
}