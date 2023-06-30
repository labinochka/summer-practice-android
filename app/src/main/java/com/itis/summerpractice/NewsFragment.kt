package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.summerpractice.databinding.FragmentNewsBinding


class NewsFragment : Fragment(R.layout.fragment_news) {
    private var binding: FragmentNewsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)

        binding?.run {
            subscribeBut.setOnClickListener{
                val className = this::class
                val bundle = Bundle()
                bundle.putString("ARG_NAME", className.simpleName)
                findNavController().navigate(R.id.action_newsFragment_to_chanelFragment,
                bundle
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}