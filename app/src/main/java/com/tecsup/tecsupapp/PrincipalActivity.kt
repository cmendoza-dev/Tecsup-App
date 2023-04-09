package com.tecsup.tecsupapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        supportActionBar?.hide()

        val button = findViewById<Button>(R.id.btnRegCurso)
        button.setOnClickListener {
            startActivity(Intent(this, Registercourse::class.java))
        }

        val bottom = findViewById<Button>(R.id.btnNoticias)
        bottom.setOnClickListener {
            startActivity(Intent(this, InfoCursoActivity::class.java))
        }

        val bot = findViewById<Button>(R.id.btnRegNotas)
        bot.setOnClickListener {
            startActivity(Intent(this, CursoActivity::class.java))
        }

        val btnestudiante = findViewById<Button>(R.id.btnRegEstudiante)
        btnestudiante.setOnClickListener {
            startActivity(Intent(this, RegistrarEstudianteActivity::class.java))
        }

        val btndocente = findViewById<Button>(R.id.btnRegDocente)
        btndocente.setOnClickListener {
            startActivity(Intent(this, RegistrarDocenteActivity::class.java))
        }




    }

}