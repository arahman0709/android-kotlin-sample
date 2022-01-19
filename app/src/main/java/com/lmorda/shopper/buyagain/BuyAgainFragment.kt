package com.lmorda.shopper.buyagain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lmorda.shopper.FOOD_ITEM_ID_ARG
import com.lmorda.shopper.R
import com.lmorda.shopper.databinding.FragmentBuyAgainBinding
import com.lmorda.shopper.store.StoreItemAdapter
import com.lmorda.shopper.store.StoreViewModel
import com.lmorda.shopper.utils.getViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BuyAgainFragment : Fragment() {

    private val viewModel by viewModels<BuyAgainViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TOOD: I just realized Buy Again is almost identical to Store!  But without store banner

        val binding = FragmentBuyAgainBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = StoreItemAdapter(
            itemClickListener = {
                val bundle = bundleOf(FOOD_ITEM_ID_ARG to it)
                findNavController().navigate(R.id.action_storeFragment_to_detailsFragment, bundle)
            },
            checkListener = {}
        )
        binding.previousItemsList.adapter = adapter

        lifecycleScope.launch {
            viewModel.previousItems.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        return view
    }
}