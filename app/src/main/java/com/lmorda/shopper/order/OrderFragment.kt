package com.lmorda.shopper.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lmorda.shopper.R
import com.lmorda.shopper.ViewModelFactory
import com.lmorda.shopper.databinding.FragmentOrderBinding
import com.lmorda.shopper.utils.getViewModelFactory

class OrderFragment: Fragment() {

    private val viewModel by viewModels<OrderViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOrderBinding.inflate(inflater, container, false)

        viewModel.getOrder().observe(viewLifecycleOwner, {
            binding.orderName.text = it.name
        })

        binding.closeOrderBtn.setOnClickListener {
            findNavController().navigate(R.id.action_orderFragment_to_storeFragment)
        }

        return binding.root
    }
}