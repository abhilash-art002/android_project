package com.example.rosai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rosai.databinding.MenuitemBinding

class MenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private val menuImageName: MutableList<Int>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuItemsName[position], menuItemPrice[position], menuImageName[position])
    }

    override fun getItemCount(): Int = menuItemsName.size

    class MenuViewHolder(private val binding: MenuitemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, price: String, imageResId: Int) {
            binding.menuFoodName.text = foodName
            binding.menuprice.text = price
            binding.menuimage.setImageResource(imageResId)
        }
    }
}
