package com.example.muti_pillows

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnBackProfile = findViewById<ImageView>(R.id.btnBackProfile)
        val btnLogout = findViewById<MaterialButton>(R.id.btnLogout)

        btnBackProfile?.setOnClickListener {
            finish()
        }

        // Fitur Logout P5 (Hapus SharedPreferences & Kembali ke Login)
        btnLogout?.setOnClickListener {
            val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            Toast.makeText(this, "Berhasil Logout", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}