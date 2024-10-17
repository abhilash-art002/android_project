package com.example.rosai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rosai.com.example.rosai.adapter.NotificationAdapter
import com.example.rosai.databinding.FragmentHistoryBinding
import com.example.rosai.databinding.FragmentNotificationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class NotificationFragment : BottomSheetDialogFragment() {
  private lateinit var binding: FragmentNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(layoutInflater,container,false)
        val notificationImage = listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congrats)
        val notifications = listOf("Order Has been Cancelled","Order Has Been Taken By Driver","Congrats Your Order Placed")
        val adapter= NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImage)
        )
        binding.notificationRecycle.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecycle.adapter = adapter
        return binding.root
    }

    companion object {

    }
}