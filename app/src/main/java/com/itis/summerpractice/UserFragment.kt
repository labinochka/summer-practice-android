package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.itis.summerpractice.databinding.FragmentUserBinding

class UserFragment : Fragment(R.layout.fragment_user) {
    private var binding: FragmentUserBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserBinding.bind(view)

        val adapter = UserAdapter(UserRepository.list) {}

        val userId = arguments?.getInt(ARG_ID)
        val user = adapter.getItem(userId!!)
        binding?.run {
            tvId.text = "ID: " + user!!.id.toString()
            tvUser.text = "Name: " + user.name
            tvText.text = "Description: " + user.desc
            Glide.with(binding!!.root)
                .load(user.url)
                .into(imgUser)
            btnExit.setOnClickListener{
                findNavController().navigate(R.id.action_userFragment_to_messageFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"

        fun createBundle(idUser: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ID, idUser)
            return bundle
        }
    }
}