package com.tecsup.tecsupapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistrarEstudianteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_estudiante)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tituloGestionEstudiante)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}