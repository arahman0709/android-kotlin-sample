package com.lmorda.shopper.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lmorda.shopper.R
import com.lmorda.shopper.data.models.Order
import com.lmorda.shopper.databinding.OrderItemBinding

class OrdersAdapter :
    ListAdapter<Order, OrdersAdapter.OrderItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Order>() {
            override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        return OrderItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.order_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        val cartItem = getItem(position)
        holder.bind(cartItem)
    }

    inner class OrderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(orderItem: Order?) {
            if (orderItem == null) return
            val binding = OrderItemBinding.bind(itemView)
            //TODO: Change this XML item file and bind the values
            //TODO: Do I need two recycler views, one for the order items too? That scrolls horizontal? Or ellpises?
            with(binding) {
//                itemName.text = orderItem.name
//                itemPrice.text = orderItem.price.getPriceText()
//                itemImage.setImageDrawable(itemView.resources.getDrawable(orderItem.imageRes, null))
            }
        }

    }
}