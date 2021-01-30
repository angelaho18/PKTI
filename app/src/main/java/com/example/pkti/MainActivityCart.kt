package com.example.pkti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_gallery_page.*
import kotlinx.android.synthetic.main.activity_main_cart.*
//import kotlinx.android.synthetic.main.activity_main_cart.previewBack
import kotlinx.android.synthetic.main.activity_product_preview.*
import kotlinx.android.synthetic.main.recyclerview_cart.*
import kotlinx.android.synthetic.main.navigation_button.*
import kotlin.properties.Delegates

class MainActivityCart : AppCompatActivity() {
    private lateinit var Myadapter : AdapterCart
    var totalPrice: Int? = null
    private var ItemProduk : MutableList<Produk> = mutableListOf(
            Produk("Ani Shop", "Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Dress",200000,"https://i.ibb.co/wBYDxLq/beach.jpg"),
            Produk("Ani Shop","Batik",100000, "https://i.ibb.co/dBCHzXQ/paris.jpg")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cart)
        setSupportActionBar(findViewById(R.id.bar))
        bar.setNavigationIcon(R.drawable.ic_arrow_back)
        bar.setNavigationOnClickListener(View.OnClickListener {
            this.finish()
        })

//        bottomNavigationView?.menu?.findItem(R.id.person)?.isChecked = false
//        bottomNavigationView?.menu?.findItem(R.id.home1)?.isChecked = false
//        bottomNavigationView?.menu?.findItem(R.id.list)?.isChecked = false
//        bottomNavigationView?.menu?.findItem(R.id.map)?.isChecked = false

        Myadapter = AdapterCart(ItemProduk)
        RecyclerViewCart.adapter=Myadapter
        RecyclerViewCart.layoutManager=LinearLayoutManager(this)



    }


}