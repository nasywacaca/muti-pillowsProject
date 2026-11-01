package com.example.muti_pillows

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val etSearchMenu = view.findViewById<TextInputEditText>(R.id.etSearchMenu)

        // Inisialisasi 4 CardView Menu
        val card1 = view.findViewById<CardView>(R.id.cardItem1)
        val card2 = view.findViewById<CardView>(R.id.cardItem2)
        val card3 = view.findViewById<CardView>(R.id.cardItem3)
        val card4 = view.findViewById<CardView>(R.id.cardItem4)

        // Inisialisasi Nama Menu dari Layout XML
        val name1 = view.findViewById<TextView>(R.id.tvMenuName1)?.text.toString()
        val name2 = view.findViewById<TextView>(R.id.tvMenuName2)?.text.toString()
        val name3 = view.findViewById<TextView>(R.id.tvMenuName3)?.text.toString()
        val name4 = view.findViewById<TextView>(R.id.tvMenuName4)?.text.toString()

        // Fitur Real-time Search Filter
        etSearchMenu?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim().lowercase()

                // Filter Card 1
                if (name1.lowercase().contains(query)) {
                    card1?.visibility = View.VISIBLE
                } else {
                    card1?.visibility = View.GONE
                }

                // Filter Card 2
                if (name2.lowercase().contains(query)) {
                    card2?.visibility = View.VISIBLE
                } else {
                    card2?.visibility = View.GONE
                }

                // Filter Card 3
                if (name3.lowercase().contains(query)) {
                    card3?.visibility = View.VISIBLE
                } else {
                    card3?.visibility = View.GONE
                }

                // Filter Card 4
                if (name4.lowercase().contains(query)) {
                    card4?.visibility = View.VISIBLE
                } else {
                    card4?.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return view
    }
}