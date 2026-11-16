package com.example.muti_pillows

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            // Selalu arahkan ke OnBoardingActivity setelah Splash Screen
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }, 2000)
    }
}