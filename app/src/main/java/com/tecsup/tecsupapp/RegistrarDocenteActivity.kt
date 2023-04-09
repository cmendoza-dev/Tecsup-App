package com.tecsup.tecsupapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistrarDocenteActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_docente)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tituloGestionDocente)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}


