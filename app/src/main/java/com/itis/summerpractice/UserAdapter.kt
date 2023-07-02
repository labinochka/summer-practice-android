package com.itis.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.summerpractice.databinding.ItemUsersBinding

class UserAdapter(
    private var list: List<User>,
    private val onItemClick: (User) -> Unit,
) : RecyclerView.Adapter<UserItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserItem = UserItem (
        ItemUsersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        onItemClick = onItemClick
    )
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: UserItem, position: Int) {
        holder.onBind(list[position])
    }
    fun getItem(position: Int): User? {
        return list[position]
    }
}