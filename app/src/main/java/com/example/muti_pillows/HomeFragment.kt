package com.example.muti_pillows

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val tvWelcomeUser = view.findViewById<TextView>(R.id.tvWelcomeUser)

        // Ambil nama username yang disimpan dari LoginActivity
        val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val usernameSaved = sharedPref.getString("username", "CACA")
        tvWelcomeUser?.text = usernameSaved?.uppercase()

        // Interaksi klik pada setiap item Grid Menu Favorit
        view.findViewById<ConstraintLayout>(R.id.gridItem1)?.setOnClickListener {
            Toast.makeText(requireContext(), "Mie Ayam Polosan - Rp 12.000 (Cek tab Menu untuk pesan!)", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<ConstraintLayout>(R.id.gridItem2)?.setOnClickListener {
            Toast.makeText(requireContext(), "Mie Ayam Pangsit - Rp 15.000 (Cek tab Menu untuk pesan!)", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<ConstraintLayout>(R.id.gridItem3)?.setOnClickListener {
            Toast.makeText(requireContext(), "Mie Ayam Bakso - Rp 17.000 (Cek tab Menu untuk pesan!)", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<ConstraintLayout>(R.id.gridItem4)?.setOnClickListener {
            Toast.makeText(requireContext(), "Mie Ayam Komplit - Rp 20.000 (Cek tab Menu untuk pesan!)", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}