package com.lmorda.shopper.invite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.lmorda.shopper.R

class InviteAFriendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                InviteAFriend(
                    closeClickListener = { findNavController().navigate(R.id.action_inviteFragment_to_arrivalFragment) },
                    addToCalendarClickListener = { showTodo() },
                    shareThisOrderClickListener = { showTodo() },
                    learnMoreClickListener = { showTodo() },
                    messageClickListener = { showTodo() },
                    copyLinkClickListener = { showTodo() },
                    shareLinkClickListener = { showTodo() }
                )
            }
        }
    }

    private fun showTodo() {
        view?.let {
            Snackbar.make(it, "TODO", Snackbar.LENGTH_SHORT).show()
        }
    }
}