package com.mercan.hiltlearnmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var liveData: List<Post>? = null

    fun setList(liveData: List<Post>) {
        this.liveData = liveData
        notifyDataSetChanged()
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleText: TextView = view.findViewById(R.id.title)
        private val bodyText: TextView = view.findViewById(R.id.body)

        fun bind(post: Post) {
            titleText.text = post.title
            bodyText.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        liveData?.let { return it.size }
        return 0
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = liveData!![position]
        holder.bind(currentPost)
    }
}