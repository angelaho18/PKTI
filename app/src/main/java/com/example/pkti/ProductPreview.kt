package com.example.pkti

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.marginRight
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_gallery_page.*
import kotlinx.android.synthetic.main.activity_product_preview.*
import kotlinx.android.synthetic.main.gallery_item.*
import kotlinx.android.synthetic.main.gallery_item.view.*
import java.lang.Exception
import java.net.URL
import kotlin.annotation.Target as Target

class ProductPreview : AppCompatActivity() {
    private var imagePreview: ArrayList<ImagePreview> = arrayListOf(
        ImagePreview("https://i.ibb.co/wBYDxLq/beach.jpg"),
        ImagePreview("https://picsum.photos/seed/picsum/200/300"),
        ImagePreview("https://i.ibb.co/wBYDxLq/beach.jpg"),
        ImagePreview("https://picsum.photos/seed/picsum/200/300")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_preview)
        previewBack.setOnClickListener {
            this.finish()
        }

        var preview = findViewById<LinearLayout>(R.id.previewTemp)
        var prevBack = findViewById<ScrollView>(R.id.previewBackground)
        var imagePrev = findViewById<ImageView>(R.id.imagePrev)
        Glide.with(this).load("https://i.ibb.co/wBYDxLq/beach.jpg").centerCrop()
            .error(R.drawable.big_star).into(imagePrev)

        for (image in imagePreview) {
            var card = CardView(this)
            val imagesView = ImageView(this)
            val params = LinearLayout.LayoutParams(dpToPixel(100), dpToPixel(100))

            card.layoutParams = params
            card.radius = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                10f,
                resources.displayMetrics
            )
            imagesView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            val cardParam = card.layoutParams as ViewGroup.MarginLayoutParams
            cardParam.setMargins(0, 0, dpToPixel(10), 0)
            imagesView.isClickable = true
            Picasso.get().load("${image.ImageUrl}").into(imagesView)
            imagesView.scaleType = ImageView.ScaleType.CENTER_CROP
//            imagesView.adjustViewBounds = true
            imagesView.setOnClickListener {
                Glide.with(this).load("${image.ImageUrl}").centerCrop().error(R.drawable.big_star)
                    .into(imagePrev)

            }
            preview.addView(card)
            card.addView(imagesView)
        }

    }

    //convert dp to px
    fun dpToPixel(sizeInDp: Int): Int {
        val scale = resources.displayMetrics.density
        return (sizeInDp * scale + 0.5f).toInt()
    }

    fun setSize(view: View) {
        if (sizeS.isChecked) size.setText("Ukuran: S")
        else if (sizeM.isChecked) size.setText("Ukuran: M")
        else if (sizeL.isChecked) size.setText("Ukuran: L")
        else if (sizeXL.isChecked) size.setText("Ukuran: XL")
    }


}


//                object : com.squareup.picasso.Target{
//                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                        var url: URL = URL("${image.ImageUrl}")
//                        var bitmap: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
//                        prevBack.background = BitmapDrawable(resources, bitmap)
//                    }
//                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
//                        Toast.makeText(this@ProductPreview, "hula", Toast.LENGTH_SHORT).show()
//                    }
//                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//                        Toast.makeText(this@ProductPreview, "hula", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                try{
//                    var url: URL = URL("${image.ImageUrl}")
//                    var bitmap: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
//                    var bg: Drawable = BitmapDrawable(resources, bitmap)
//                    prevBack.background = bg
//
//                }catch (e: Exception){
//                    e.printStackTrace()
//                    Toast.makeText(this, "hula", Toast.LENGTH_SHORT).show()
//                }