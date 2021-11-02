package com.lmorda.shopper.order

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.lmorda.shopper.R
import com.lmorda.shopper.ViewModelFactory
import com.lmorda.shopper.databinding.FragmentOrderBinding
import com.lmorda.shopper.utils.getViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class OrderFragment: Fragment() {

    private val viewModel by viewModels<OrderViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOrderBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            viewModel.orderDetails.collectLatest {
                binding.orderStatus.text = it?.status
                binding.arrivalTime.text = it?.arrivalFirst + " " + it?.arrivalSecond
                binding.statusDetails.text = it?.statusDetails
            }
        }

        binding.chatEditText.setOnEditorActionListener { view, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    //sendMessage()
                    view.text = ""
                    showMessageSent()
                    true
                }
                else -> false
            }
        }

        binding.closeOrderBtn.setOnClickListener {
            findNavController().navigate(R.id.action_orderFragment_to_storeFragment)
        }

        return binding.root
    }

    fun showMessageSent() {
        view?.let {
            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
            Snackbar.make(it, "Message sent", Snackbar.LENGTH_SHORT).show()
        }
    }
}