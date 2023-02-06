package com.example.challange17

import MySharedPref
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.challange17.databinding.FoodItemBinding
import kotlinx.coroutines.withContext

class FoodAdapter : androidx.recyclerview.widget.ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    var size : Float = 0f
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {

            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.name == newItem.name || oldItem.imageUrl == newItem.imageUrl
            }

        }
    }
    private lateinit var binding: FoodItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(val itemBinding: FoodItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Food){
            itemBinding.tvName.textSize = size
            itemBinding.tvName.text = item.name

            itemBinding.ivAvatar.setImageResource(item.imageUrl)
        }
    }


}