package com.example.muti_pillows

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Buka halaman registrasi
        tvRegister?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin?.setOnClickListener {
            val username = etUsername?.text.toString().trim()
            val password = etPassword?.text.toString().trim()

            val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
            val regUsername = sharedPref.getString("reg_username", null)
            val regPassword = sharedPref.getString("reg_password", null)

            if (!username.isNullOrEmpty() && !password.isNullOrEmpty()) {
                // Rule 1: username == password
                val isRule1Valid = (username == password)

                // Rule 2: username & password cocok dengan data registrasi di SharedPreferences
                val isRule2Valid = (!regUsername.isNullOrEmpty() && !regPassword.isNullOrEmpty() && username == regUsername && password == regPassword)

                if (isRule1Valid || isRule2Valid) {
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", true)
                    editor.putString("username", username)
                    editor.apply()

                    Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Isi Username dan Password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}