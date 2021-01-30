package com.example.pkti

import android.app.AlertDialog
import android.content.ClipData
import android.content.DialogInterface
import android.media.Image
import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class AdapterCart(data : MutableList<Produk>): RecyclerView.Adapter<AdapterCart.myHolder>() {
    private var myData = data
    inner class myHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val GambarProduk = itemView.findViewById<ImageView>(R.id.GambarProduk)
        val NamaProduk = itemView.findViewById<TextView>(R.id.NamaProduk)
        val Harga = itemView.findViewById<TextView>(R.id.harga)
        val NamaToko = itemView.findViewById<TextView>(R.id.NamaToko)
        val Add = itemView.findViewById<android.widget.Button>(R.id.addList)
        val Remove = itemView.findViewById<android.widget.Button>(R.id.removeList)
        val ItemCount = itemView.findViewById<TextView>(R.id.itemCount)
        val Total = itemView.findViewById<TextView>(R.id.totalPrice)
        val Delete = itemView.findViewById<ImageButton>(R.id.deleteItem)

        fun bindTotal(item: Produk){
            var count = ItemCount.text.toString().toInt()
            var total = 0
            var price = 0
            for (i in myData){
                price  = i.Harga
                total += (price * item.JumlahProduk)
            }
//            Toast.makeText(itemView.context, "count $count price $price total $total", Toast.LENGTH_LONG).show()
//            Total.text = total.toString()
        }
        
        fun counter(item: Produk, index: Int){
            var count = ItemCount.text.toString().toInt()
            var dialog = AlertDialog.Builder(itemView.context)
                .setTitle("Delete Product")
                .setMessage("Are you sure to remove this product from your cart?")
                .setPositiveButton("YES, SURE", DialogInterface.OnClickListener { dialog, which ->
                    removeItem(index)
                    Toast.makeText(itemView.context, "Item Removed", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("CANCEL", DialogInterface.OnClickListener { dialog, which ->
                    return@OnClickListener
                })
            Add.setOnClickListener {
                count++
                ItemCount.text = count.toString()
            }
            Remove.setOnClickListener() {
                if(count == 1) {
                    dialog.show()
                    return@setOnClickListener
                }
                count--
                ItemCount.text = count.toString()
                item.JumlahProduk = ItemCount.text.toString().toInt()
            }
            Delete.setOnClickListener {
                dialog.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val inflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_cart,parent,false)
        return myHolder(inflate)
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        var getPos = myData[position]
        holder.NamaToko.text = getPos.NamaToko
        holder.NamaProduk.text = getPos.NamaProduk
        holder.Harga.text = getPos.Harga.toString()
        Picasso.get().load(getPos.GambarProduk).into(holder.GambarProduk)
        holder.counter(getPos, position)
        holder.bindTotal(getPos)
    }

    override fun getItemCount(): Int = myData.size

    fun removeItem(pos: Int){
        myData.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun updateItem(pos: Int, text: Produk){
        myData.set(pos, text)
        notifyItemChanged(pos)
    }

}