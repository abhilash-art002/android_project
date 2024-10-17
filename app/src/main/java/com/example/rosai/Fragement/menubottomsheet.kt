package com.example.rosai.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rosai.R
import com.example.rosai.adapter.MenuAdapter
import com.example.rosai.databinding.FragmentMenubottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class menubottomsheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenubottomsheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize the binding
        binding = FragmentMenubottomsheetBinding.inflate(inflater, container, false)

        binding.buttonback.setOnClickListener{
            dismiss()
        }

        // Sample data for the menu
        val menuFoodName = listOf("Burger", "Noodles", "Ice Cream", "Paneer", "Pasta")
        val menuItemPrice = listOf("$5", "$16", "$8", "$10", "$10")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5
        )

        // Initialize the adapter and set it to the RecyclerView
        val adapter = MenuAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage))
        binding.AllMenureCycle.layoutManager = LinearLayoutManager(requireContext())
        binding.AllMenureCycle.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            menubottomsheet().apply {
                // You can set parameters here if needed
            }
    }
}
