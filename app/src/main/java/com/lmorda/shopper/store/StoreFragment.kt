package com.lmorda.shopper.store

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lmorda.shopper.R
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.databinding.FragmentStoreBinding
import com.lmorda.shopper.utils.getViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Double.valueOf

class StoreFragment : Fragment() {

    private val viewModel by viewModels<StoreViewModel> { getViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        Log.d("louie", "Store fragment created")
        val binding = FragmentStoreBinding.inflate(inflater, container, false)
        val view = binding.root
        var creatingOrder = false
        var numItems = 0

        val adapter = StoreItemAdapter({
            numItems += it
            binding.numItems.text = numItems.toString()
        })
        binding.itemsList.adapter = adapter

        lifecycleScope.launch {
            viewModel.storeItems.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        binding.cartPill.setOnClickListener {
            if (creatingOrder || adapter.checkedItems.isEmpty()) return@setOnClickListener
            creatingOrder = true
            viewModel.createOrder(adapter.checkedItems.map { it.value }).observe(viewLifecycleOwner, Observer {
                if (it == true) findNavController().navigate(R.id.action_storeFragment_to_cartFragment)
                else creatingOrder = false //TODO: Show error
            })
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("louie", "Store fragment destroyed")
    }

}
