package com.example.pkti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock.sleep
import android.widget.Toast
import java.lang.Exception

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var Timer: Thread = Thread(){
            fun run(){
                try{
                    sleep(3000)
                    var homeIntent = Intent(this, MainActivitySignUp::class.java)
                    startActivity(homeIntent)
                    Toast.makeText(this, "START", Toast.LENGTH_LONG).show()
                }catch (e: Exception){
                    e.printStackTrace()
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show()
                }finally {
                    Toast.makeText(this, "FIN", Toast.LENGTH_LONG).show()
                }
            }
        }
        Timer.start()

    }


}