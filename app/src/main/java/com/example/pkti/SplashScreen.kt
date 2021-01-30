package com.example.pkti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock.sleep
import android.widget.Toast
import java.lang.Exception

class SplashScreen : AppCompatActivity() {
    private val timeout_splash = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(
            {
                var homeIntent = Intent(this, MainActivitySignUp::class.java)
                startActivity(homeIntent)
                Toast.makeText(this, "Welcome to Busan", Toast.LENGTH_LONG).show()
                finish()
            }, timeout_splash)
    }
}