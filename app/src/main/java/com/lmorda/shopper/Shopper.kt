package com.lmorda.shopper

import android.app.Application
import com.lmorda.shopper.utils.Loug

class Shopper: Application() {

    override fun onTerminate() {
        Loug.d("shopper", "app terminated")
        super.onTerminate()
    }

}