package com.example.muti_pillows.ccaPillows

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.muti_pillows.MainActivity
import com.example.muti_pillows.R
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        // 1. Setup Toolbar Atas
        val toolbar = findViewById<Toolbar>(R.id.toolbarFourth)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 2. Inisialisasi Semua Tombol
        val btnDetailPillows = findViewById<Button>(R.id.btnDetailPillows)
        val btnShowAlertDialog = findViewById<Button>(R.id.btnShowAlertDialog)
        val btnShowSnackbar = findViewById<Button>(R.id.btnShowSnackbar)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Tombol "Lihat Detail Snack" -> Pindah ke DetailSnackActivity
        btnDetailPillows.setOnClickListener {
            val intent = Intent(this, DetailSnackActivity::class.java)
            startActivity(intent)
        }

        // Tombol "Beli Pillows (Alert Dialog)"
        btnShowAlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Pembelian")
                .setMessage("Apakah Anda yakin ingin membeli Oishi Pillows Cokelat?")
                .setPositiveButton("Beli") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(it, "Pembelian berhasil!", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        // Tombol "Cek Promo (Snackbar)"
        btnShowSnackbar.setOnClickListener {
            Snackbar.make(it, "Promo Diskon 20% untuk Pillows Cokelat!", Snackbar.LENGTH_LONG).show()
        }

        // Tombol "Kembali" di Bawah -> Kembali ke MainActivity
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Navigasi tombol Panah Kembali (<-) di Toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}