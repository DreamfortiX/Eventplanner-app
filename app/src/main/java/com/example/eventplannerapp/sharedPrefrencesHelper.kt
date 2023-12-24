package com.example.eventplannerapp

// SharedPreferencesHelper.kt
import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    fun saveCredentials(email: String, password: String, confirmPassword: String) {
        val editor = sharedPreferences.edit()
        editor.putString("EMAIL", email)
        editor.putString("PASSWORD", password)
        editor.putString("CONFIRM_PASSWORD", confirmPassword)
        editor.apply()
    }

    fun getEmail(): String? {
        return sharedPreferences.getString("EMAIL", "")
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("PASSWORD", "")
    }

    fun getConfirmPassword(): String? {
        return sharedPreferences.getString("CONFIRM_PASSWORD", "")
    }

    fun saveCredentials(newPassword: String) {
        val editor = sharedPreferences.edit()
        editor.putString("newPassword", newPassword)
    }
}
