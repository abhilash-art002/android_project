package com.example.rosai.com.example.rosai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rosai.databinding.NotificationitemBinding

class NotificationAdapter(private var notification : ArrayList<String>,
    private var notificationImage: ArrayList<Int>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
       val binding = NotificationitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = notification.size
    inner class NotificationViewHolder(private val binding:NotificationitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notificationtextview.text = notification[position]
                notificationimageview.setImageResource(notificationImage[position])
            }
        }

    }
}