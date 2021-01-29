package com.example.pkti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_role.*
import kotlinx.android.synthetic.main.activity_main_sign_in.*

class MainActivityRole : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_role)

        desainer.setOnClickListener{
            val desainer = Intent(this,GalleryPage::class.java)
            startActivity(desainer)
        }
        customer.setOnClickListener{
            val customer = Intent(this,MainActivityHome::class.java)
            startActivity(customer)
        }

    }

}