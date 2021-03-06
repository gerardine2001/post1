package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var postList: List<Post>):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.user_list_items,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       var currentList=postList.get(position)
        holder.etUserId.text=currentList.userId.toString()
        holder.etId.text=currentList.id.toString()
        holder.etTitle.text=currentList.title
        holder.etBody.text=currentList.body
        holder.cvPost.setOnClickListener {
            var intent=Intent(context,ViewPostActivity::class.java)
            intent.putExtra("POST_ID",currentList.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var etUserId=itemView.findViewById<TextView>(R.id.etUserId)
    var etId=itemView.findViewById<TextView>(R.id.etId)
    var etTitle=itemView.findViewById<TextView>(R.id.etTitle)
    var etBody=itemView.findViewById<TextView>(R.id.etBody)
    var cvPost=itemView.findViewById<CardView>(R.id.cvPost)

}