package com.example.muti_pillows

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)
        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnSubmitRegister = findViewById<MaterialButton>(R.id.btnSubmitRegister)

        btnSubmitRegister?.setOnClickListener {
            val name = etName?.text.toString().trim()
            val phone = etPhone?.text.toString().trim()
            val username = etUsername?.text.toString().trim()
            val password = etPassword?.text.toString().trim()

            if (name.isNotEmpty() && phone.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, OtpVerificationActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                intent.putExtra("EXTRA_PHONE", phone)
                intent.putExtra("EXTRA_USERNAME", username)
                intent.putExtra("EXTRA_PASSWORD", password)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Harap isi semua kolom formulir!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}