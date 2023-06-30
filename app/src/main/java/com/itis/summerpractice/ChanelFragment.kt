package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.FragmentChanelBinding

class ChanelFragment : Fragment(R.layout.fragment_chanel) {
    private var binding: FragmentChanelBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChanelBinding.bind(view)
        val className = arguments?.getString("ARG_NAME")
        Snackbar.make(binding!!.root, className.orEmpty(), Snackbar.LENGTH_LONG).show()

        binding?.run {
            exitBut.setOnClickListener{
                findNavController().navigate(R.id.action_chanelFragment_to_newsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}