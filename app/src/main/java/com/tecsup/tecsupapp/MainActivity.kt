package com.tecsup.tecsupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.tecsup.tecsupapp.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this,
                LoginActivity::class.java
                )
            )
            finish()

        }, 2000)

        supportActionBar?.hide()

    }
}


