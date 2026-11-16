package com.example.muti_pillows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

data class MenuItem(
    val name: String,
    val price: String,
    val imageResId: Int
)

class MenuAdapter(
    private var menuList: List<MenuItem>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMenu: ImageView = view.findViewById(R.id.imgMenu)
        val tvMenuName: TextView = view.findViewById(R.id.tvMenuName)
        val tvMenuPrice: TextView = view.findViewById(R.id.tvMenuPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]
        holder.tvMenuName.text = item.name
        holder.tvMenuPrice.text = item.price
        holder.imgMenu.setImageResource(item.imageResId)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Dipilih: ${item.name} (${item.price})",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = menuList.size

    fun filterList(filteredList: List<MenuItem>) {
        menuList = filteredList
        notifyDataSetChanged()
    }
}