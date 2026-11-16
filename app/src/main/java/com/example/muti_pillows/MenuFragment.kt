package com.example.muti_pillows

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MenuFragment : Fragment() {

    private lateinit var menuAdapter: MenuAdapter
    private lateinit var fullMenuList: List<MenuItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val etSearchMenu = view.findViewById<TextInputEditText>(R.id.etSearchMenu)
        val rvMenu = view.findViewById<RecyclerView>(R.id.rvMenu)

        // Daftar Data Menu NIKI ECO 602
        // Daftar Data Menu Asli NIKI ECO 602
        fullMenuList = listOf(
            MenuItem("Pangsit Polosan", "Rp 10.000", R.drawable.polosan),
            MenuItem("Mie Ayam Pangsit Goreng", "Rp 18.000", R.drawable.pangsit),
            MenuItem("Mie Ayam Bakso", "Rp 20.000", R.drawable.solaria),
            MenuItem("Mie Ayam Komplit", "Rp 25.000", R.drawable.komplit)
        )

        // Pasang CustomAdapter ke RecyclerView
        menuAdapter = MenuAdapter(fullMenuList)
        rvMenu.layoutManager = LinearLayoutManager(requireContext())
        rvMenu.adapter = menuAdapter

        // Fitur Real-time Search Filter pada RecyclerView
        etSearchMenu?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim().lowercase()
                val filtered = fullMenuList.filter {
                    it.name.lowercase().contains(query)
                }
                menuAdapter.filterList(filtered)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return view
    }
}