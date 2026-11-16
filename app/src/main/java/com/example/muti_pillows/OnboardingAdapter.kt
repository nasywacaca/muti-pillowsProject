package com.example.muti_pillows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter(
    private val titles: Array<String>,
    private val descs: Array<String>,
    private val images: IntArray
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv: ImageView = view.findViewById(R.id.ivOnboard)
        val title: TextView = view.findViewById(R.id.tvOnboardTitle)
        val desc: TextView = view.findViewById(R.id.tvOnboardDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.desc.text = descs[position]
        holder.iv.setImageResource(images[position])
    }

    override fun getItemCount(): Int = titles.size
}