package com.example.rosai.Fragement

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rosai.CongratsButtonSheet
import com.example.rosai.R
import com.example.rosai.activity_pay_out
import com.example.rosai.adapter.CartAdapter
import com.example.rosai.databinding.CartitemBinding
import com.example.rosai.databinding.FragmentCartBinding

class cartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartfoodName = listOf("Burger","Noodles","IceCream","Paneer","Pasta")
        val cartItemPrice = listOf("$5","$16","$8","$10","$10",)
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5
        )
        val adapter=CartAdapter(ArrayList(cartfoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartrecycle.layoutManager=LinearLayoutManager(requireContext())
        binding.cartrecycle.adapter = adapter
        binding.proceedBtn.setOnClickListener{
            val intent=Intent(requireContext(),activity_pay_out::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            cartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}