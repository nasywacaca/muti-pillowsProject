package com.example.muti_pillows

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMenuNative = findViewById<MaterialButton>(R.id.btnMenuNative)
        val btnPemesananWeb = findViewById<MaterialButton>(R.id.btnPemesananWeb)
        val btnProfile = findViewById<MaterialButton>(R.id.btnProfile)

        // Buka Daftar Menu
        btnMenuNative.setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }

        // Buka WebView Pemesanan
        btnPemesananWeb.setOnClickListener {
            startActivity(Intent(this, WebMieAyamActivity::class.java))
        }

        // Buka Profil Developer
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}