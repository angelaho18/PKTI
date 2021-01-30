package com.example.pkti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_sign_in.*


class MainActivitySignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sign_in)
        signup_button2.setOnClickListener {
            val intent_signup = Intent(this,MainActivitySignUp::class.java)
            startActivity(intent_signup)
        }
        signinbutton.setOnClickListener{
            val intentSignin = Intent(this,MainActivityRole::class.java)
            startActivity(intentSignin)
        }
        findViewById<android.widget.Button>(R.id.google).setOnClickListener { view ->
            Snackbar.make(view, "Sorry Google is not Available Now", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
       }

    }
}