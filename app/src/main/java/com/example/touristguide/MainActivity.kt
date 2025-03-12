package com.example.touristguide

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

//rawda
//rawda6677@

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val back = findViewById<TextView>(R.id.back)
        val signupbtn = findViewById<Button>(R.id.signup1)
        val loginbtn = findViewById<Button>(R.id.login1)
        val usernameField = findViewById<EditText>(R.id.username)
        val passwordField = findViewById<EditText>(R.id.password)
        val passwordConfirmField = findViewById<EditText>(R.id.passwordconf)
        val emailField = findViewById<EditText>(R.id.email)

        back.setOnClickListener {
            val intent = Intent(this, ViewIntroActivity::class.java)
            startActivity(intent)
        }
        loginbtn.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        signupbtn.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val passwordConfirm = passwordConfirmField.text.toString().trim()
            val email = emailField.text.toString().trim()

            when {
                username.isEmpty() || password.isEmpty() || email.isEmpty() || passwordConfirm.isEmpty() -> {
                    Toast.makeText(this, "You must fill all the fields first", Toast.LENGTH_LONG).show()
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_LONG).show()
                }

                username.length < 3 -> {
                    Toast.makeText(this, "Username must be at least 3 characters long", Toast.LENGTH_LONG).show()
                }

                !username.matches(Regex("^[a-zA-Z0-9_]*\$")) -> {
                    Toast.makeText(this, "Username can only contain letters, numbers, and underscores", Toast.LENGTH_LONG).show()
                }

                password.length < 6 -> {
                    Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_LONG).show()
                }

                !password.matches(Regex(".*[0-9].*")) -> {
                    Toast.makeText(this, "Password must contain at least one number", Toast.LENGTH_LONG).show()
                }

                !password.matches(Regex(".*[!@#\$%^&*()].*")) -> {
                    Toast.makeText(this, "Password must contain at least one special character", Toast.LENGTH_LONG).show()
                }

                password != passwordConfirm -> {
                    Toast.makeText(this, "Confirm password must be the same as password", Toast.LENGTH_LONG).show()
                }

                else -> {
                    val editor = sharedPreferences.edit()
                    editor.putString("username", username)
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.apply()

                    Toast.makeText(this, "Signed up successfully! Log in now :)", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LogIn::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
