package com.example.muti_pillows

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class WebMieAyamActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_mie_ayam)

        val webView = findViewById<WebView>(R.id.webViewMieAyam)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val ivBtnBack = findViewById<ImageView>(R.id.ivBtnBack)

        ivBtnBack.setOnClickListener {
            finish()
        }

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        }

        // Pakai Link Web Publik agar PASTI TERBUKA & Tidak Muter-muter
        webView.loadUrl("https://www.google.com")
    }
}