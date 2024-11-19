package com.example.rosai.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rosai.databinding.MenuitemBinding

class MenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private val MenuImage: MutableList<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
//                menuFoodName.text = menuItemsName[position]
//                menuprice.text = menuItemPrice[position]
//                menuimage.setImageResource(MenuImage[position])
//                setonclick listner to open details
//                val intent = Intent(requireContext, detailsActivity::class.java)
//                intent.putExtra("MenuItemName", menuItemsName.get(position))
//                intent.putExtra("MenuItemImage", MenuImage.get(position))
//                requireContext.startActivity(intent)
            }

        }
    }



}


