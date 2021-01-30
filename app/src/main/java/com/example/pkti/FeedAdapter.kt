package com.example.pkti

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_home.*
import kotlinx.android.synthetic.main.feed_item.view.*
import kotlin.math.log

class FeedAdapter (data : MutableList<Feed>) : RecyclerView.Adapter<FeedAdapter.FeedHolder>() {
    private var myData = data
    class FeedHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val Username = view.findViewById<TextView>(R.id.UsernameFeed)
        val Pic = view.findViewById<ImageView>(R.id.FeedGambar)
        val Peringkat = view.findViewById<TextView>(R.id.rating)
        val Commentar = view.findViewById<TextView>(R.id.comment)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder {
        val inflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.feed_item, parent, false)
        return FeedHolder(inflate)



    }

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        holder.Username.setText(myData.get(position).NamaFeed)
        holder.Peringkat.setText(myData.get(position).rate)
        holder.Commentar.setText(myData.get(position).comment)

        Picasso.get().load(myData.get(position).gambar).into(holder.Pic)

        Log.i("HOME", myData.get(position).gambar)

        holder.Pic.setOnClickListener {
            val konteks = holder.Pic.context
            val intentproduk = Intent(konteks,ProductPreview::class.java)
            konteks.startActivity(intentproduk)
        }

        holder.Username.setOnClickListener{
            val konten = holder.Username.context
            val intentkonten = Intent(konten,GalleryPage::class.java)
            konten.startActivity(intentkonten)
        }

    }

    override fun getItemCount(): Int = myData.size
}