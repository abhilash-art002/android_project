package com.example.rosai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rosai.databinding.CartitemBinding

class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemPrices: MutableList<String>,
    private val cartImages: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartitemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                foodname.text = cartItems[position] // Correct TextView reference
                itemprice.text = cartItemPrices[position] // Correct TextView reference
                cartItemImage.setImageResource(cartImages[position]) // Correct ImageView reference
                CartItemQuantity.text = itemQuantities[position].toString() // Display item quantity

                minus.setOnClickListener{
                    decreaseQuantity(position)
                }
                plusbutton.setOnClickListener{
                    increaseQuantity(position)
                }
                trash.setOnClickListener{
                    delete(position)
                }
            }
        }

    private fun increaseQuantity(position: Int){
                itemQuantities[position]++
                binding.CartItemQuantity.text = itemQuantities[position].toString()
            }

      private fun decreaseQuantity(position: Int){
            if(itemQuantities[position]>1){
                itemQuantities[position]--
                binding.CartItemQuantity.text = itemQuantities[position].toString()
            }
        }
      private fun delete(position: Int){
            cartItems.removeAt(position)
            cartItemPrices.removeAt(position)
            cartImages.removeAt(position)
             notifyItemRemoved(position)
        }
    }
}
