package com.example.eventplannerapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.set
import com.airbnb.lottie.LottieAnimationView
import com.example.eventplannerapp.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var binding: ActivityLoginBinding
    private  lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        var savedEmail = sharedPreferencesHelper.getEmail()
        var savedPassword = sharedPreferencesHelper.getPassword()


        binding.login.setOnClickListener {
            val enteredEmail = binding.editTextEmail.text.toString()
            val enteredPassword = binding.editTextPassword.text.toString()
            if (enteredEmail == savedEmail && enteredPassword == savedPassword) {
                Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, home::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Wrong Credetials", Toast.LENGTH_SHORT).show()
            }

        }


        binding.forgot.setOnClickListener()
        {
            showChangePasswordDialog()
        }
    }
    private fun showChangePasswordDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_change_password,null)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        // Set up click listener for the "Change Password" button in the custom dialog
        dialogView.findViewById<Button>(R.id.changePasswordButton)?.setOnClickListener {

            val oldPassword = dialogView.findViewById<EditText>(R.id.oldPasswordEditText)?.text.toString()
            var savedPassword = sharedPreferencesHelper.getPassword()
            if (savedPassword == oldPassword )
            {
                val newPassword = dialogView.findViewById<EditText>(R.id.newPasswordEditText)?.text.toString()
                val confirmNewPassword = dialogView.findViewById<EditText>(R.id.confirmNewPasswordEditText)?.text.toString()
                if (newPassword == confirmNewPassword)
                {
                    sharedPreferencesHelper.saveCredentials( newPassword)
                    Toast.makeText(this, "Password changed", Toast.LENGTH_SHORT).show()
                    alertDialog.dismiss()
                }
            }



        }
        alertDialog.show()
    }
}
