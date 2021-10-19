package com.demo.match.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.match.R
import com.demo.match.datamodel.Players
import kotlinx.android.synthetic.main.item_user.view.*

class PlayerAdapter internal constructor(private val list: List<Players>) : RecyclerView.Adapter<PlayerAdapter.UserViewHolder>() {


    var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemLayoutView: View
        context = parent.context
        itemLayoutView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(holder, position, context)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class UserViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tv_name


        fun bindView(viewHolder: UserViewHolder, position: Int, context: Context?) {
            val players:Players = list.get(position)
           viewHolder.tvName.text = players.let {
               var string:String?=null
               string=it.nameFull
               if (it.iscaptain) {
                   string=string+" (c) "
               }
               if (it.iskeeper) {
                   string=string+" (wk) "
               }
               string
           }
        }
    }




}