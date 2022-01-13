package com.lmorda.shopper.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lmorda.shopper.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentChatBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}