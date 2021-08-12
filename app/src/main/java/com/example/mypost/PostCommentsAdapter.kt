package com.example.mypost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostCommentsAdapter(var postComment:List<Comments>):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comment_view_items,parent,false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=postComment.get(position)
        holder.name.text=currentComment.name
        holder.email.text=currentComment.email
        holder.body.text=currentComment.body
    }

    override fun getItemCount(): Int {
        return postComment.size
    }
}
class CommentsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var name=itemView.findViewById<TextView>(R.id.name)
    var email=itemView.findViewById<TextView>(R.id.email)
    var body=itemView.findViewById<TextView>(R.id.body)
}
