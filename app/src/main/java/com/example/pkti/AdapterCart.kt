package com.example.pkti

import android.app.AlertDialog
import android.content.ClipData
import android.content.DialogInterface
import android.media.Image
import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class AdapterCart(data : MutableList<produk>): RecyclerView.Adapter<AdapterCart.myHolder>() {
    private var myData = data
    inner class myHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
        val GambarProduk = itemView.findViewById<ImageView>(R.id.GambarProduk)
        val NamaProduk = itemView.findViewById<TextView>(R.id.NamaProduk)
        val Harga = itemView.findViewById<TextView>(R.id.harga)
        val NamaToko = itemView.findViewById<TextView>(R.id.NamaToko)
        val Add = itemView.findViewById<android.widget.Button>(R.id.addList)
        val Remove = itemView.findViewById<android.widget.Button>(R.id.removeList)
        val ItemCount = itemView.findViewById<TextView>(R.id.itemCount)

        fun counter(item: produk, index: Int){
            var count = ItemCount.text.toString().toInt()
            Add.setOnClickListener {
                count++
                ItemCount.text = count.toString()
            }
            Remove.setOnClickListener() {
                if(count == 1) {
                    var dialog = AlertDialog.Builder(itemView.context)
                        .setTitle("Delete Product")
                        .setMessage("Are you sure to remove this product from your cart?")
                        .setPositiveButton("YES, SURE", DialogInterface.OnClickListener { dialog, which ->
                            removeItem(index)
                            Toast.makeText(itemView.context, "REMOVE", Toast.LENGTH_SHORT).show()
                        })
                        .setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which ->
                            return@OnClickListener
                        })
                    dialog.show()
                    return@setOnClickListener
                }
                count--
                ItemCount.text = count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val inflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_cart,parent,false)
        return myHolder(inflate)
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.NamaToko.setText(myData.get(position).NamaToko)
        holder.NamaProduk.setText(myData.get(position).NamaProduk)
        holder.Harga.setText(myData.get(position).Harga.toString())
        Picasso.get().load(myData.get(position).GambarProduk).into(holder.GambarProduk)
        holder.counter(myData[position], position)
    }

    override fun getItemCount(): Int = myData.size

    fun removeItem(pos: Int){
        myData.removeAt(pos)
        notifyItemRemoved(pos)
    }

}