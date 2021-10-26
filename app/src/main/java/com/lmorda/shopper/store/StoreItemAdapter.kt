package com.lmorda.shopper.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lmorda.shopper.R
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.databinding.StoreItemBinding

class StoreItemAdapter(
    val itemClickListener: (Int) -> Unit,
    val checkListener: (Pair<FoodItem, Boolean>) -> Unit
) : PagingDataAdapter<FoodItem, StoreItemAdapter.StoreItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FoodItem>() {
            override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        return StoreItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.store_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        val cartItem = getItem(position)
        holder.bind(cartItem)
    }

    inner class StoreItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(foodItem: FoodItem?) {
            if (foodItem == null) return
            val binding = StoreItemBinding.bind(itemView)
            itemView.setOnClickListener { itemClickListener.invoke(foodItem.id) }
            with(binding) {
                itemName.text = foodItem.name
                itemImage.setImageDrawable(itemView.resources.getDrawable(foodItem.imageRes, null))
                cbItem.isChecked = foodItem.inCart
                cbItem.setOnCheckedChangeListener { _, isChecked ->
                    checkListener.invoke(Pair(foodItem, isChecked))
                }
            }
        }
    }
}