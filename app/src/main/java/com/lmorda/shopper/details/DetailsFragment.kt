package com.lmorda.shopper.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lmorda.shopper.FOOD_ITEM_ID_ARG
import com.lmorda.shopper.cart.getPriceText
import com.lmorda.shopper.databinding.FragmentDetailsBinding
import com.lmorda.shopper.details.DetailsViewModel
import com.lmorda.shopper.utils.getViewModelFactory

class DetailsFragment: Fragment() {

    private val viewModel by viewModels<DetailsViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)

        viewModel.foodItem(arguments?.get(FOOD_ITEM_ID_ARG) as? Int).observe(viewLifecycleOwner, {
            it?.let { foodItem ->
                binding.foodName.text = foodItem.name
                binding.itemImage.setImageDrawable(resources.getDrawable(foodItem.imageRes, null))
                binding.price.text = foodItem.price.getPriceText()
            }
        })

        binding.detailsBackBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}