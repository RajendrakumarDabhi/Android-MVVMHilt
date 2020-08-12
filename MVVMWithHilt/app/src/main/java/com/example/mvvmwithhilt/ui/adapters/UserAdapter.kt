package com.example.mvvmwithhilt.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.models.User
import com.example.mvvmwithhilt.ui.adapters.UserAdapter.UserHolder
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(itemClick: (pos: Int, data: User) -> Unit) : RecyclerView.Adapter<UserHolder>() {
    val list = mutableListOf<User>()

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: User) {
            Glide.with(itemView.imageView).load(data.avatar).into(itemView.imageView)
            itemView.txt_name.text = data.first_name + data.last_name
            itemView.txt_email.text = data.email
        }

    }

    public fun setData(listdata: List<User>) {
        list.clear()
        list.addAll(listdata)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

}