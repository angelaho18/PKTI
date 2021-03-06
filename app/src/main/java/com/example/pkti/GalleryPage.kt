package com.example.pkti

import android.content.Intent
import android.graphics.BitmapShader
import android.graphics.Color
import android.graphics.Shader
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_gallery_page.*
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.gallery_item.*
import kotlinx.android.synthetic.main.navigation_button.*

class GalleryPage : AppCompatActivity() {

    var designs = 35
    var orders = 75
    var totalDesign = "$designs\nDesigns"
    var totalOrder = "$orders\nOrders"
    private lateinit var gridLayoutManager: GridLayoutManager
    private var Gallery = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_page)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        setSupportActionBar(findViewById(R.id.toolbar))
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            this.finish()
        })

        spanString(totalDesign, R.id.totalDesign)
        spanString(totalOrder, R.id.totalOrder)

        gridLayoutManager = GridLayoutManager(this, 2)
        galleryRecycleView.layoutManager = gridLayoutManager
        galleryRecycleView.adapter = RecyclerAdapter(Gallery)
        galleryRecycleView.setHasFixedSize(true)

        //item Decoration
//        galleryRecycleView.addItemDecoration(DividerItemDecoration(galleryRecycleView.context, gridLayoutManager.orientation))

        loadImages()
//        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//        findViewById<AppBarLayout>(R.id.app_bar).title = title

//        var shader : BitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        bottomNavigationView?.selectedItemId = R.id.list

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list ->{
                    val intentlist = Intent(this,MainActivityList::class.java)
                    startActivity(intentlist)
                }
                R.id.person -> {
                    val intentperson = Intent(this, MainProfileActivity::class.java)
                    startActivity(intentperson)
                }
                R.id.home1 -> {
                    val intenthome = Intent(this, MainActivityHome::class.java)
                    startActivity(intenthome)
                }
                R.id.map -> {
                    val intentmap = Intent(this, MapsActivity::class.java)
                    startActivity(intentmap)
                }
            }
            true
        }
    }

    private fun spanString(s: String, @IdRes tvId: Int) {
        var spanString: SpannableString = SpannableString(s)
        spanString.setSpan(RelativeSizeSpan(2.5f), 0, 3, 0)   //setSize
        spanString.setSpan(ForegroundColorSpan(Color.BLACK), 0, 3, 0)    //setColor
        findViewById<TextView>(tvId).setText(spanString)
    }

    fun call(view: View) {
        var dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel: " + "08123456789")
        startActivity(dialIntent)
    }

    private fun loadImages(){
        Gallery.add(Image("https://i.ibb.co/wBYDxLq/beach.jpg", "Beach Houses"))
        Gallery.add(Image("https://i.ibb.co/wBYDxLq/beach.jpg", "Beach Houses"))
        Gallery.add(Image("https://i.ibb.co/wBYDxLq/beach.jpg", "Beach Houses"))
        Gallery.add(Image("https://picsum.photos/seed/picsum/200/300", "Waterfall"))
        Gallery.add(Image("https://i.ibb.co/JKB0KPk/pizza.jpg", "Pizza Time"))
        Gallery.add(Image("https://i.ibb.co/dBCHzXQ/paris.jpg", "Paris Eiffel"))
        Gallery.add(Image("https://i.ibb.co/7XqwsLw/fox.jpg", "Fox"))
        Gallery.add(Image("https://i.ibb.co/L1m1NxP/girl.jpg", "Mountain Girl"))
        Gallery.add(Image("https://i.ibb.co/wc9rSgw/desserts.jpg", "Desserts Table"))
        Gallery.add(Image("https://i.ibb.co/wdrdpKC/kitten.jpg", "Kitten"))
    }




}