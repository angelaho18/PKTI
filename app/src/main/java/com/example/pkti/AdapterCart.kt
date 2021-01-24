package com.example.pkti

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterCart(data : MutableList<produk>): RecyclerView.Adapter<AdapterCart.myHolder>() {
    private var myData = data
    class myHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val GambarProduk = itemView.findViewById<ImageView>(R.id.GambarProduk)
        val NamaProduk = itemView.findViewById<TextView>(R.id.NamaProduk)
        val Harga = itemView.findViewById<TextView>(R.id.harga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val inflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_cart,parent,false)
        return myHolder(inflate)
    }

    override fun getItemCount(): Int = myData.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {

        holder.NamaProduk.setText(myData.get(position).NamaProduk)
        holder.Harga.setText(myData.get(position).Harga.toString())
        Picasso.get().load(myData.get(position).GambarProduk).into(holder.GambarProduk)
    }
}