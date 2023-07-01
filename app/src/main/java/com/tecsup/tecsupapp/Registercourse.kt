package com.tecsup.tecsupapp

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.tecsup.tecsupapp.R.layout
import com.tecsup.tecsupapp.R.string

class Registercourse : AppCompatActivity() {
    lateinit var opciones: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_registercourse)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(string.tituloRegistroUsuario)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}


