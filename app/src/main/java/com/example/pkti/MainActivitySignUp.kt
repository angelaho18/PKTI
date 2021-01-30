package com.example.pkti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_sign_up.*

class MainActivitySignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sign_up)
        signin_button1.setOnClickListener {
            val intent_signin = Intent(this, MainActivitySignIn::class.java)
            startActivity(intent_signin)
        }
        signup.setOnClickListener {
            val intent_Signup = Intent(this, MainActivityRole::class.java)
            startActivity(intent_Signup)
        }
        findViewById<android.widget.Button>(R.id.google2).setOnClickListener { view ->
            Snackbar.make(view, "Sorry Google is not Available Now", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    fun showGal(view: View) {
        val intentMap = Intent(this, ProductPreview::class.java)
        startActivity(intentMap)
    }

}