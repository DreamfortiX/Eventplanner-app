package com.example.eventplannerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intent = Intent(this, signlog::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}