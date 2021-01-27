package com.example.pkti

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.gallery_item.view.*

class RecyclerAdapter(private var images: ArrayList<Image>): RecyclerView.Adapter<RecyclerAdapter.ImageHolder>() {
    class ImageHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val ImageUrl = view.findViewById<ImageView>(R.id.imageView)
        val Title = view.findViewById<TextView>(R.id.imageTextView)

        fun bindItems(item : Image){
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, Title.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        //using extensions
//        val inflatedView = parent.inflate(R.layout.gallery_item, false)
//        return ImageHolder(inflatedView)
        //without extensions
        val inflateView = LayoutInflater.from(parent.context)
        val cellForRow = inflateView.inflate(R.layout.gallery_item, parent, false)
        return ImageHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        var image = images.get(position)
        holder.Title.text = image.title
//        holder.view.imageTextView.text = images.get(position).title
        Picasso.get().load(image.imageURL).into(holder.view.imageView)
        holder.bindItems(image)

    }

    override fun getItemCount() = images.size
}

//class ImageHolder(view: View): RecyclerView.ViewHolder(view){
//}

