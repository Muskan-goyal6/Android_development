package com.example.muskangoyal.okhttpgithub

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class UserAdapter(val githubUsers: ArrayList<GithubUser>) : RecyclerView.Adapter<UserAdapter.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val githubUser = githubUsers[position]
        holder?.itemView?.userLo?.text = githubUser.name
       holder?.itemView?.userurl?.text = githubUser.profileUrl
       holder?.itemView?.userSc?.text = githubUser.score
        Picasso.get().load(githubUser.profilePic)
               .placeholder(R.mipmap.ic_launcher_round)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder?.itemView?.img)
    }

    override fun getItemCount(): Int {
       return githubUsers.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

       val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_row, parent, false)
         return MyHolder(v)
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}