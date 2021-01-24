package com.example.pkti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_cart.*

class MainActivityCart : AppCompatActivity() {
    private lateinit var Myadapter : AdapterCart
    private var ItemProduk : MutableList<produk> = mutableListOf(
            produk("Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            produk("Batik",100000, "https://i.ibb.co/dBCHzXQ/paris.jpg")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cart)

        Myadapter = AdapterCart(ItemProduk)
        RecyclerViewCart.adapter=Myadapter
        RecyclerViewCart.layoutManager=LinearLayoutManager(this)
    }
}