package com.tecsup.tecsupapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PrincipalActivity : AppCompatActivity() {
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

        val btnNoticia = findViewById<Button>(R.id.btnNoticia)
        val fabWeb = findViewById<FloatingActionButton>(R.id.fabWeb)

        val uriPhone: Uri = Uri.parse("tel: 985919866")
        btnNoticia.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, uriPhone))
        }

        val uriWeb: Uri = Uri.parse("https://www.tecsup.edu.pe/")
        fabWeb.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, uriWeb))
        }

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Mensaje Enviar")
            type = "text/plain"
        }
        startActivity(sendIntent)


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