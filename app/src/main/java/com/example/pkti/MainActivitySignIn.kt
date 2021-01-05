package com.example.pkti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_sign_in.*

class MainActivitySignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sign_in)
        signup_button2.setOnClickListener {
            val intent_signup = Intent(this,MainActivitySignUp::class.java)
            startActivity(intent_signup)
        }
    }
}