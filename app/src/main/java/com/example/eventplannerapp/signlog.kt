package com.example.eventplannerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventplannerapp.databinding.ActivitySignlogBinding

class signlog : AppCompatActivity() {
    private lateinit var binding: ActivitySignlogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignlogBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.signup.setOnClickListener()
        {
            startActivity(Intent(this,signup::class.java))
            finish()
        }
        binding.login.setOnClickListener()
        {
            startActivity(Intent(this,login::class.java))
            finish()
        }
    }
}