package com.example.muti_pillows

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MenuListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        val btnBackMenu = findViewById<ImageView>(R.id.btnBackMenu)
        btnBackMenu.setOnClickListener {
            finish()
        }
    }
}