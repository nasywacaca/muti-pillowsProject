package com.example.muti_pillows

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class WebFragment : Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        // Setup WebView
        val webView = view.findViewById<WebView>(R.id.webViewMieAyam)
        if (webView != null) {
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            webView.webViewClient = WebViewClient()
            // Memuat website resmi NIKI ECO 602
            webView.loadUrl("https://nikieco602.com/")
        }

        // Klik ikon Home di toolbar atas -> Pindah ke Tab Home
        val btnHomeWeb = view.findViewById<ImageView>(R.id.btnHomeWeb)
        btnHomeWeb?.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNav.selectedItemId = R.id.nav_home
        }

        return view
    }
}