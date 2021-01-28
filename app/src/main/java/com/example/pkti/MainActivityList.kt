package com.example.pkti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_home.*
import kotlinx.android.synthetic.main.activity_main_home.recyclerMain
import kotlinx.android.synthetic.main.activity_main_list.*
import kotlinx.android.synthetic.main.navigation_button.*

class MainActivityList : AppCompatActivity() {

    private lateinit var MyListAdapter : ListDesignerAdapter

    private var MyList : MutableList<ListDesigner> = mutableListOf(
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg"),
            ListDesigner("Ana", "Fashion Designer", "https://i.ibb.co/dBCHzXQ/paris.jpg", "https://i.ibb.co/wBYDxLq/beach.jpg", "https://i.ibb.co/dBCHzXQ/paris.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        MyListAdapter = ListDesignerAdapter(MyList)
        recyclerList.adapter = MyListAdapter
        recyclerList.layoutManager = LinearLayoutManager(this)
    }
}