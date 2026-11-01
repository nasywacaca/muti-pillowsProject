package com.example.muti_pillows

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val btnLogout = view.findViewById<MaterialButton>(R.id.btnLogout)
        val btnHomeProfile = view.findViewById<ImageView>(R.id.btnHomeProfile)

        // DITAMBAHKAN (FITUR 1 P9): Inisialisasi Tombol Hubungi Outlet
        val btnCallOutlet = view.findViewById<MaterialButton>(R.id.btnCallOutlet)

        // Klik ikon Home di toolbar atas -> Pindah ke Tab Home
        btnHomeProfile?.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNav.selectedItemId = R.id.nav_home
        }

        // DITAMBAHKAN (FITUR 1 P9): Klik Tombol Hubungi Outlet -> Membuka Phone Dialer
        btnCallOutlet?.setOnClickListener {
            val phoneNumber = "081234567890" // Nomor telepon outlet NIKI ECO 602
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }

        // Fungsi Logout
        btnLogout?.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()

            val intent = Intent(requireActivity(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}