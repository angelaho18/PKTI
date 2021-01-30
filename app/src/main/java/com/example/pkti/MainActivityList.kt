package com.example.pkti

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main_home.*
import kotlinx.android.synthetic.main.activity_main_home.recyclerMain
import kotlinx.android.synthetic.main.activity_main_list.*
import kotlinx.android.synthetic.main.navigation_button.*

class MainActivityList : AppCompatActivity() {

    private lateinit var MyListAdapter: ListDesignerAdapter

    private var MyList: MutableList<ListDesigner> = mutableListOf(
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        ),
        ListDesigner(
            "Ana",
            "Fashion Designer",
            "https://i.ibb.co/dBCHzXQ/paris.jpg",
            "https://i.ibb.co/wBYDxLq/beach.jpg",
            "https://i.ibb.co/dBCHzXQ/paris.jpg"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        MyListAdapter = ListDesignerAdapter(MyList)
        recyclerList.adapter = MyListAdapter
        recyclerList.layoutManager = LinearLayoutManager(this)

        bottomNavigationView?.selectedItemId = R.id.list

        fab.setOnClickListener{
            val intendong = Intent(this,MainActivityCart::class.java)
            startActivity(intendong)
        }

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
}