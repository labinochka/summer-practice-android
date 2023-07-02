package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.summerpractice.databinding.FragmentMessageBinding


class MessageFragment : Fragment(R.layout.fragment_message) {
    private var binding: FragmentMessageBinding? = null
    private var adapter: UserAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMessageBinding.bind(view)

        initAdapter()
    }

    private fun initAdapter() {
        adapter = UserAdapter(UserRepository.list
        ) { user ->
            val bundle = UserFragment.createBundle(user.id)
            findNavController().navigate(R.id.action_messageFragment_to_userFragment, bundle)
        }
        binding?.rvUsers?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}