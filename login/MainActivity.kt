package com.example.userpass

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.button)
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (VALID_USERNAME == username && VALID_PASSWORD == password) {
                Toast.makeText(
                    this@MainActivity, "Login Successfull",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@MainActivity, "Invalid Credentials",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        private const val VALID_USERNAME = "user"
        private const val VALID_PASSWORD = "pass"
    }
}