package com.example.muti_pillows.ccaPillows

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.muti_pillows.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnDetailPillows = findViewById<Button>(R.id.btnDetailPillows)
        val btnShowAlertDialog = findViewById<Button>(R.id.btnShowAlertDialog)
        val btnShowSnackbar = findViewById<Button>(R.id.btnShowSnackbar)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnDetailPillows?.setOnClickListener {
            Log.e("MutiPillows", "Tombol lihat snack Pillows diklik")
        }

        // 2. Klik Alert Dialog
        btnShowAlertDialog?.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Pembelian")
                .setMessage("Apakah Anda yakin ingin membeli Muti Pillows Cokelat?")
                .setPositiveButton("Beli") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("MutiPillows", "User membeli Pillows Cokelat")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("MutiPillows", "Pembelian dibatalkan")
                }
                .show()
        }

        btnShowSnackbar?.setOnClickListener {
            Snackbar.make(it, "Diskon Promo Muti Pillows Beli 2 Gratis 1!", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("MutiPillows", "Snackbar promo ditutup")
                }
                .show()
        }

        btnBack?.setOnClickListener {
            finish()
        }
    }
}