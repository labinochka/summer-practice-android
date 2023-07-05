package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.itis.summerpractice.databinding.ItemUsersBinding

class UserItem (
    private val binding: ItemUsersBinding,
    private val onItemClick: (User) -> Unit,
    ) : ViewHolder(binding.root) {

    fun onBind(user: User) {
        binding.run {
            tvTitle.text = user.name
            tvDesc.text = user.desc

            root.setOnClickListener {
                onItemClick(user)
            }
        }
    }
}