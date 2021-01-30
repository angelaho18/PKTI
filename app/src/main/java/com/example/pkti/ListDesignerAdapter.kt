package com.example.pkti

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feed_item.view.*
import kotlin.math.log

class ListDesignerAdapter (data : MutableList<ListDesigner>) : RecyclerView.Adapter<ListDesignerAdapter.ListHolder>() {
    private var myData = data
    class ListHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val Username = view.findViewById<TextView>(R.id.UsernameList)
        val Work = view.findViewById<TextView>(R.id.WorkList)
        val Pic1 = view.findViewById<ImageView>(R.id.ListGambar1)
        val Pic2 = view.findViewById<ImageView>(R.id.ListGambar2)
        val Pic3 = view.findViewById<ImageView>(R.id.ListGambar3)
        val penampung = view.findViewById<LinearLayout>(R.id.penampung)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val inflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_designer, parent, false)
        return ListHolder(inflate)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.Username.setText(myData.get(position).NamaList)
        holder.Work.setText(myData.get(position).Kerja)

        Picasso.get().load(myData.get(position).gambar1).into(holder.Pic1)
        Picasso.get().load(myData.get(position).gambar2).into(holder.Pic2)
        Picasso.get().load(myData.get(position).gambar3).into(holder.Pic3)

        holder.Pic1.setOnClickListener {
            val konteks1 = holder.Pic1.context
            val intentproduk1 = Intent(konteks1,ProductPreview::class.java)
            konteks1.startActivity(intentproduk1)
        }

        holder.Pic2.setOnClickListener {
            val konteks2 = holder.Pic1.context
            val intentproduk1 = Intent(konteks2,ProductPreview::class.java)
            konteks2.startActivity(intentproduk1)
        }

        holder.Pic3.setOnClickListener {
            val konteks3 = holder.Pic3.context
            val intentproduk1 = Intent(konteks3,ProductPreview::class.java)
            konteks3.startActivity(intentproduk1)
        }

        holder.penampung.setOnClickListener{
            val konten = holder.penampung.context
            val intentkonten = Intent(konten,GalleryPage::class.java)
            konten.startActivity(intentkonten)
        }

    }

    override fun getItemCount(): Int = myData.size
}