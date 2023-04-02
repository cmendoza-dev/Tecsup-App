package com.tecsup.tecsupapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Registercourse : AppCompatActivity() {
    lateinit var opciones: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registercourse)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val anos = listOf("2023-I", "2022-II", "2022-I")

        opciones = findViewById(R.id.anios)

        val adapt = ArrayAdapter(this, android.R.layout.simple_spinner_item, anos)
        opciones.adapter=adapt

    }
}