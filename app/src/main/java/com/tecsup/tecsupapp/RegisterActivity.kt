package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity(){

    lateinit var opciones:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tituloRegistroUsuario)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)
    }
}
