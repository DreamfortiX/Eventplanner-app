package com.example.eventplannerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.eventplannerapp.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        setContentView(binding.root)

        sharedPreferencesHelper = SharedPreferencesHelper(this)
        binding.signup.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val confirmPassword = binding.editTextCPassword.text.toString()
            if (isValidEmail(email) && password.length<7 && password == confirmPassword) {
                Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
                sharedPreferencesHelper.saveCredentials(email, password, confirmPassword)
                startActivity(Intent(this,login::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid email address & password", Toast.LENGTH_SHORT).show()
            }

        }

        // Example: Retrieve credentials when needed
//        retrieveButton.setOnClickListener {
//            val savedEmail = sharedPreferencesHelper.getEmail()
//            val savedPassword = sharedPreferencesHelper.getPassword()
//            val savedConfirmPassword = sharedPreferencesHelper.getConfirmPassword()
        }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



}




