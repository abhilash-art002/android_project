package com.example.rosai.Fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rosai.R
import com.example.rosai.adapter.BuyAgainAdapter
import com.example.rosai.databinding.FragmentHistoryBinding

class historyFragment : Fragment() {

        private lateinit var binding:FragmentHistoryBinding
        private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setUpRecyclerview()
        return binding.root
    }

    private fun setUpRecyclerview(){
        val buyAgainFoodName = arrayListOf("Food1","Food2","Food3")
        val buyAgainFoodPrice = arrayListOf("$10","$20","$30")
        val buyAgainFoodImage = arrayListOf(R.drawable.menu1,R.drawable.menu4,R.drawable.menu3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.foodRecycler.adapter = buyAgainAdapter
        binding.foodRecycler.layoutManager=LinearLayoutManager(requireContext())
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            historyFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}