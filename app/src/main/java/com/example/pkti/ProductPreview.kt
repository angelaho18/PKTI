package com.example.pkti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_preview.*
import kotlinx.android.synthetic.main.gallery_item.*
import kotlinx.android.synthetic.main.gallery_item.view.*

class ProductPreview : AppCompatActivity() {
    private var imagePreview : ArrayList<ImagePreview> = arrayListOf(
        ImagePreview("https://i.ibb.co/wBYDxLq/beach.jpg"),
        ImagePreview("https://picsum.photos/seed/picsum/200/300"),
        ImagePreview("https://i.ibb.co/wBYDxLq/beach.jpg"),
        ImagePreview("https://picsum.photos/seed/picsum/200/300")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_preview)

        previewBack.setOnClickListener{
            this.finish()
        }

        var preview = findViewById<LinearLayout>(R.id.previewTemp)

        for (image in imagePreview){
            var sizeInDp = 100
            val scale = resources.displayMetrics.density
            val dpToPixel = (sizeInDp * scale + 0.5f).toInt()   //convert dp to px

            val imagesView = ImageView(this)
            val params = LinearLayout.LayoutParams(dpToPixel, dpToPixel)
            imagesView.setLayoutParams(params)
            imagesView.setBackgroundResource(R.drawable.view_data_effect)
            imagesView.isClickable = true
            Picasso.get().load("${image.ImageUrl}").into(imagesView)
            imagesView.scaleType = ImageView.ScaleType.FIT_XY
            imagesView.adjustViewBounds = true
            imagesView.setOnClickListener{

            }
            preview.addView(imagesView)

//            val textview = TextView(this)
//            textview.setText("$image")
//            preview.addView(textview)
        }

    }



}