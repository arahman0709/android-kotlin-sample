package com.lmorda.shopper.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.lmorda.shopper.MainActivity
import com.lmorda.shopper.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launch {
            delay(3000)
            startApp()
        }
    }
    fun startApp() = startActivity(Intent(this, MainActivity::class.java))
}