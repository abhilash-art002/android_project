package com.example.rosai.Fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.rosai.Fragment.menubottomsheet
import com.example.rosai.R
import com.example.rosai.adapter.AdapterPopular
import com.example.rosai.databinding.FragmentHomeBinding



/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding.textView14.setOnClickListener{
            val bottomSheetDialog = menubottomsheet()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList= ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider=binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        val recyclerView = binding.recyclerViewPopular // Use the RecyclerView from your layout
        recyclerView.layoutManager = LinearLayoutManager(context) // Set layout manager

        val items = listOf("Item 1", "Item 2", "Item 3") // Replace with your data
        val images = listOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3) // Replace with your image resources
        val prices = listOf(100, 200, 300)
        val adapter = AdapterPopular(items, prices, images,requireContext())

        recyclerView.adapter = adapter


    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            homeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}