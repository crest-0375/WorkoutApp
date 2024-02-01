package com.example.workoutapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemExerciseStausBinding

class ExerciseStatusAdapter(private val items: ArrayList<ExerciseModel>) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemExerciseStausBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExerciseStausBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.tvItem.text = model.id.toString()
        if (model.isSelected)
            holder.tvItem.setBackgroundResource(R.drawable.item_circular_color_thin_accent_border)
        else if (model.isCompleted)
            holder.tvItem.setBackgroundResource(R.drawable.item_circular_color_accent_background)
    }
}