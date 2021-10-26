package com.lmorda.shopper.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lmorda.shopper.R
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.databinding.CartItemBinding
import java.math.RoundingMode

class CartAdapter :
    ListAdapter<FoodItem, CartAdapter.CartItemViewHolder>(DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cart_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem = getItem(position)
        holder.bind(cartItem)
    }

    inner class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cartItem: FoodItem?) {
            if (cartItem == null) return
            val binding = CartItemBinding.bind(itemView)
            with(binding) {
                itemName.text = cartItem.name
                itemPrice.text = cartItem.price.getPriceText()
                itemImage.setImageDrawable(itemView.resources.getDrawable(cartItem.imageRes, null))
            }
        }

    }
}

fun Double.getPriceText() =
    when {
        this < 0 -> "$0.00" // server bug
        this > MAX_PRICE -> "$0.00" // server bug
        else -> "$" + this.twoDecimalsMax().let {
            if (it.needsZero()) it.toString() + "0"
            else it.toString()
        }
    }

const val MAX_PRICE = 100000.00
fun Double.twoDecimalsMax() = this.toBigDecimal().setScale(2, RoundingMode.FLOOR).toDouble()
fun Double.needsZero() = this.times(10).rem(1) == 0.0