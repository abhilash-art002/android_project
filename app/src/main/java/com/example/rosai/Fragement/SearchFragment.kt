package com.example.rosai.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log // Import Log class for logging
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rosai.R
import com.example.rosai.adapter.MenuAdapter
import com.example.rosai.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalFoodName = listOf("Burger", "Noodles", "IceCream", "Paneer", "Pasta")
    private val originalItemPrice = listOf("$5", "$16", "$8", "$10", "$10")
    private val originalItemImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5
    )

    // Mutable lists to store filtered menu data
    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuItemPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("SearchFragment", "onCreateView called") // Log message for debugging

        // Inflate the layout using View Binding
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Set up the adapter with the initial (filtered) menu data
        adapter = MenuAdapter(filterMenuFoodName, filterMenuItemPrice, filterMenuImage)
        binding.searchrecycleview.layoutManager = LinearLayoutManager(requireContext())
        binding.searchrecycleview.adapter = adapter

        // Initialize with full data before any filtering
        filterMenuFoodName.addAll(originalFoodName)
        filterMenuItemPrice.addAll(originalItemPrice)
        filterMenuImage.addAll(originalItemImage)

        // Setup SearchView functionality
        setupSearchView()

        showAllMenu()

        // Return the root view of the binding
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        filterMenuFoodName.addAll(originalFoodName)
        filterMenuItemPrice.addAll(originalItemPrice)
        filterMenuImage.addAll(originalItemImage)

        adapter.notifyDataSetChanged()
    }

    // Set up SearchView filtering
    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { filterMenuItems(it) }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                newText.let { filterMenuItems(newText) }
                return true
            }
        })
    }

    // Filter menu items based on the search query
    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItems(query: String) {
        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        originalFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filterMenuFoodName.add(foodName)
                filterMenuItemPrice.add(originalItemPrice[index])
                filterMenuImage.add(originalItemImage[index])
            }
        }
        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged()
    }

    companion object {
        // You can add any companion object methods or constants here if needed
    }
}
