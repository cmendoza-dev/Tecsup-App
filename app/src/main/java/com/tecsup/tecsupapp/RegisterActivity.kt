package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity(){

    lateinit var opciones:Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val cargos = listOf("Estudiante", "Docente", "Coordinador")

        opciones = findViewById(R.id.spinner)

        val adapt = ArrayAdapter(this, android.R.layout.simple_spinner_item, cargos)
        opciones.adapter=adapt







    }

    }
