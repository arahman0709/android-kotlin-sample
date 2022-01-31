package com.lmorda.shopper.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lmorda.shopper.cart.CartAdapter
import com.lmorda.shopper.cart.CartViewModel
import com.lmorda.shopper.databinding.FragmentOrdersBinding
import com.lmorda.shopper.utils.getViewModelFactory

class OrdersFragment : Fragment() {

    private val viewModel by viewModels<OrdersViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.orders.adapter = OrdersAdapter()

        viewModel.getOrders().observe(viewLifecycleOwner, {
            (binding.orders.adapter as OrdersAdapter).apply {
                submitList(it)
            }
        })

        return view
    }
}