package com.example.pkti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoryAdapter (data : MutableList<Story>) : RecyclerView.Adapter<StoryAdapter.StoryHolder>() {
    private var myData = data
    class StoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Username = itemView.findViewById<TextView>(R.id.UsernameStory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.story_item, parent, false)
        return StoryHolder(inflate)
    }

    override fun onBindViewHolder(holder: StoryHolder, position: Int) {
        holder.Username.setText(myData.get(position).NamaStory)
    }

    override fun getItemCount(): Int = myData.size
}