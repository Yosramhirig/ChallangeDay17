package com.example.challange17.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.challange17.databinding.FoodItemBinding


open class FoodAdapter : ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK){

var size : Float = 0f

    private  lateinit var mlistener : onclickListener
    interface onclickListener{
        fun onItemClick(position: Int)
    }

    fun onItemClickListener(listener: Any){
        mlistener  = listener as onclickListener
    }

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
        return ViewHolder(binding, mlistener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item, position)
        }
    }



    inner class ViewHolder(val itemBinding: FoodItemBinding, listener : onclickListener):
        RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemBinding.ivholder.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(item: Food, position: Int){

            itemBinding.apply {
                tvName.text = item.name
                tvName.textSize = size
                ivAvatar.load(item.imageUrl){
                    transformations(CircleCropTransformation())


                }
            }
        }




    }


}