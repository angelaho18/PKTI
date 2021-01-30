package com.example.pkti

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.core.view.get
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main_profile.*
import kotlinx.android.synthetic.main.navigation_button.*

class MainProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_profile)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        bottomNavigationView?.selectedItemId = R.id.person

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list -> {
                    val intentlist = Intent(this, MainActivityList::class.java)
                    startActivity(intentlist)
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
}