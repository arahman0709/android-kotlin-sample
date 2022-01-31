package com.lmorda.shopper.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lmorda.shopper.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
//https://developer.android.com/guide/topics/ui/settings
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}