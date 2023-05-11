package com.tecsup.tecsupapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonIngresar = findViewById<Button>(R.id.btnIngresar)
        buttonIngresar.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        val buttonRegistrar = findViewById<Button>(R.id.btnRegistrar)
        buttonRegistrar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        supportActionBar?.hide()

    }

}

