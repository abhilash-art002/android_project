package com.example.rosai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rosai.R
import com.example.rosai.databinding.PopularitemsBinding

class AdapterPopular(private val items: List<String>, private val price: List<Int>, private val image: List<Int>) : RecyclerView.Adapter<AdapterPopular.AdapterViewHolder>() {


    class AdapterViewHolder(private val binding: PopularitemsBinding) : RecyclerView.ViewHolder(binding.root) {
     private  val imagesView = binding.imageView5

        fun bind(item: String,price:String ,images: Int) {
        binding.textView19.text = item
            binding.textView20.text = price
            imagesView.setImageResource(images)
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popularitems, parent, false) // Replace with your item layout
        return AdapterViewHolder(PopularitemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item, price.toString(),images)
    }

    // Return the size of the dataset (invoked by the layout manager)
    override fun getItemCount():Int{
        return items.size
    }
}
