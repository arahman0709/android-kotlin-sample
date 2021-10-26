package com.lmorda.shopper.utils

import android.util.Log

object Loug {

    fun d(tag: String, msg: String) =
        try {
            Log.d(tag, msg)
        } catch (ex: Exception) {
        }

}

