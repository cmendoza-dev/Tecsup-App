package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val button = findViewById<Button>(R.id.btnRegCurso)
        button.setOnClickListener {
            startActivity(Intent(this, Registercourse::class.java))
        }


    }

}