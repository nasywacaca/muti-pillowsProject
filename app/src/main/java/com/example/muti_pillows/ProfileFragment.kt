package com.example.muti_pillows

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val btnLogout = view.findViewById<MaterialButton>(R.id.btnLogout)
        val btnHomeProfile = view.findViewById<ImageView>(R.id.btnHomeProfile)
        val btnCallOutlet = view.findViewById<MaterialButton>(R.id.btnCallOutlet)
        val lvOutletInfo = view.findViewById<ListView>(R.id.lvOutletInfo)

        // Data untuk SimpleAdapter
        val outletData = listOf(
            mapOf("title" to "Alamat Utama", "detail" to "Jl. Umban Sari No. 602, Rumbai, Pekanbaru"),
            mapOf("title" to "Jam Operasional", "detail" to "Setiap Hari: 10.00 - 22.00 WIB"),
            mapOf("title" to "Layanan Tersedia", "detail" to "Dine-In, Take Away & Pesan Antar Kampus")
        )

        val simpleAdapter = SimpleAdapter(
            requireContext(),
            outletData,
            R.layout.item_outlet_info,
            arrayOf("title", "detail"),
            intArrayOf(R.id.tvInfoTitle, R.id.tvInfoDetail)
        )
        lvOutletInfo?.adapter = simpleAdapter

        lvOutletInfo?.setOnItemClickListener { _, _, position, _ ->
            val selected = outletData[position]
            Toast.makeText(requireContext(), "${selected["title"]}: ${selected["detail"]}", Toast.LENGTH_SHORT).show()
        }

        // Klik ikon Home di toolbar atas -> Pindah ke Tab Home
        btnHomeProfile?.setOnClickListener {
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNav.selectedItemId = R.id.nav_home
        }

        // Klik Tombol Hubungi Outlet -> Membuka Phone Dialer
        btnCallOutlet?.setOnClickListener {
            val phoneNumber = "081234567890"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }

        // Fungsi Logout
        btnLogout?.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()

            val intent = Intent(requireActivity(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}