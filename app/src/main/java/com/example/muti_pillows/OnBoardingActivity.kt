package com.example.muti_pillows

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.viewPagerOnboarding)
        val btnNext = findViewById<MaterialButton>(R.id.btnNext)

        val titles = arrayOf(
            "Selamat Datang di NIKI ECO 602",
            "Menu Mie Ayam Spesial",
            "Pesan & Hubungi Outlet Cepat"
        )
        val descs = arrayOf(
            "Nikmati kelezatan masakan rumahan setiap hari langsung dari genggaman tangan Anda.",
            "Tersedia berbagai varian mie ayam pangsit, bakso, dan menu komplit rasa gurih bikin nagih.",
            "Fitur pencarian menu real-time dan panggilan cepat outlet untuk kemudahan pemesanan."
        )
        val images = intArrayOf(
            R.drawable.polosan,
            R.drawable.pangsit,
            R.drawable.komplit
        )

        val adapter = OnboardingAdapter(titles, descs, images)
        viewPager.adapter = adapter

        btnNext.setOnClickListener {
            if (viewPager.currentItem < titles.size - 1) {
                viewPager.currentItem += 1
            } else {
                val prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
                prefs.edit().putBoolean("isFirstRun", false).apply()

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}