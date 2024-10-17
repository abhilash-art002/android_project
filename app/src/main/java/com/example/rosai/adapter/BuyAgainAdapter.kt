package com.example.rosai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosai.R

class BuyAgainAdapter(
    private val buyagainFoodName: ArrayList<String>,
    private val buyAgainFoodPrice: ArrayList<String>,
    private val buyagainFoodImage: ArrayList<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        // Inflate the layout and pass it to the ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.againbuyitem, parent, false)
        return BuyAgainViewHolder(view)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int = buyagainFoodName.size

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyagainFoodName[position], buyAgainFoodPrice[position], buyagainFoodImage[position])
    }

    // ViewHolder class that uses `View?` type in the constructor
    class BuyAgainViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

        // Pre-initialize the views using `findViewById()` inside the constructor
        private val foodImageView: ImageView? = view?.findViewById(R.id.recentFoodImage)
        private val foodNameTextView: TextView? = view?.findViewById(R.id.recentFoodName)
        private val foodPriceTextView: TextView? = view?.findViewById(R.id.recentFoodPrice)

        // Bind data to the views
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            foodImageView?.setImageResource(foodImage)
            foodNameTextView?.text = foodName
            foodPriceTextView?.text = foodPrice
        }
    }
}
