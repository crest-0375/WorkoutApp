package com.example.workoutapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemHistoryTimesBinding

class HistoryAdapter(private val items: List<HistoryEntity>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemHistoryTimesBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvIndexedValue = binding.tvIndexNumber
        val tvHistoryItem = binding.tvHistoryItem
        val llHistoryItem = binding.llHistoryItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryTimesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val startDate: String = items[position].startDate
        val endDate: String = items[position].endDate

        holder.tvIndexedValue.text = (position + 1).toString()
        holder.tvHistoryItem.text = "$startDate to\n$endDate"
        if (position % 2 == 0){
            holder.llHistoryItem.setBackgroundResource(R.color.light_grey)
        }
    }
}