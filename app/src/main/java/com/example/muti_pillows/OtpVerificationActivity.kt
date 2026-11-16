package com.example.muti_pillows

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class OtpVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        val etOtp = findViewById<TextInputEditText>(R.id.etOtp)
        val btnVerifyOtp = findViewById<MaterialButton>(R.id.btnVerifyOtp)

        // Ambil data kiriman dari RegisterActivity
        val registeredName = intent.getStringExtra("EXTRA_NAME") ?: ""
        val registeredPhone = intent.getStringExtra("EXTRA_PHONE") ?: ""
        val registeredUsername = intent.getStringExtra("EXTRA_USERNAME") ?: ""
        val registeredPassword = intent.getStringExtra("EXTRA_PASSWORD") ?: ""

        btnVerifyOtp?.setOnClickListener {
            val inputOtp = etOtp?.text.toString().trim()

            // Aturan Soal 2: OTP harus sama persis dengan Nomor HP
            if (inputOtp.isNotEmpty() && inputOtp == registeredPhone) {
                // Simpan data pendaftaran ke SharedPreferences
                val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("reg_name", registeredName)
                editor.putString("reg_phone", registeredPhone)
                editor.putString("reg_username", registeredUsername)
                editor.putString("reg_password", registeredPassword)
                editor.apply()

                Toast.makeText(this, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_SHORT).show()

                // Kembali ke LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            } else {
                // Aturan Soal 2: Tampilkan dialog error jika OTP beda/kosong
                MaterialAlertDialogBuilder(this)
                    .setTitle("Verifikasi Gagal")
                    .setMessage("Kode OTP yang Anda masukkan salah atau tidak sesuai dengan nomor Handphone registrasi!")
                    .setPositiveButton("Coba Lagi") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}