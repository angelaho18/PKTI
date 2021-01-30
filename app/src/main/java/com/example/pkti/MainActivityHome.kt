package com.example.pkti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_home.*
import kotlinx.android.synthetic.main.activity_main_sign_in.*
import kotlinx.android.synthetic.main.navigation_button.*

class MainActivityHome : AppCompatActivity() {
    private lateinit var MyAdapter: StoryAdapter
    private lateinit var MyFeedAdapter: FeedAdapter

    private var MyStory: MutableList<Story> = mutableListOf(
        Story("Ana"),
        Story("Budi"),
        Story("Siti"),
        Story("Adi"),
        Story("Mama"),
        Story("Bapa"),
        Story("Aldo"),
        Story("Aldi"),
        Story("Aldi"),
        Story("Aldi"),
        Story("Aldi")
    )

    private var MyFeed: MutableList<Feed> = mutableListOf(
        Feed("Ana", "https://i.ibb.co/wBYDxLq/beach.jpg", "4.5", "200"),
        Feed("Budi", "https://i.ibb.co/dBCHzXQ/paris.jpg", "3.5", "200"),
        Feed("Siti", "https://i.ibb.co/dBCHzXQ/paris.jpg", "4.0", "200"),
        Feed("Adi", "https://i.ibb.co/dBCHzXQ/paris.jpg", "1.0", "200"),
        Feed("Mama", "https://i.ibb.co/wBYDxLq/beach.jpg", "3.0", "200"),
        Feed("Bapa", "https://i.ibb.co/wBYDxLq/beach.jpg", "3.5", "200"),
        Feed("Aldo", "https://i.ibb.co/wBYDxLq/beach.jpg", "2.5", "200"),
        Feed("Aldi", "https://i.ibb.co/wBYDxLq/beach.jpg", "4.5", "200"),
        Feed("Aldi", "https://i.ibb.co/wBYDxLq/beach.jpg", "4.5", "200"),
        Feed("Aldi", "https://i.ibb.co/wBYDxLq/beach.jpg", "4.5", "200"),
        Feed("Aldi", "https://i.ibb.co/wBYDxLq/beach.jpg", "4.5", "200")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        MyAdapter = StoryAdapter(MyStory)
        recyclerStory.adapter = MyAdapter
        recyclerStory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        MyFeedAdapter = FeedAdapter(MyFeed)
        recyclerMain.adapter = MyFeedAdapter
        recyclerMain.layoutManager = LinearLayoutManager(this)

        bottomNavigationView?.selectedItemId = R.id.home1



        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.person ->{
                    val intentperson = Intent(this,MainProfileActivity::class.java)
                    startActivity(intentperson)
                }
                R.id.list ->{
                    val intentlist = Intent(this,MainActivityList::class.java)
                    startActivity(intentlist)
                }
                R.id.map ->{
                    val intentmap = Intent(this,MapsActivity::class.java)
                    startActivity(intentmap)
                }
            }
            true
        }

    }

}