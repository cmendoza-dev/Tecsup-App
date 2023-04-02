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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_register)
        val cargos = listOf("Estudiante", "Docente", "Coordinador")

        opciones = findViewById(R.id.spinner)

        val adapt = ArrayAdapter(this, android.R.layout.simple_spinner_item, cargos)
        opciones.adapter=adapt
    }
}
