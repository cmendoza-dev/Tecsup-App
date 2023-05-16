package com.tecsup.tecsupapp.trica

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tecsup.tecsupapp.R

class TricaActivity : AppCompatActivity(){

    private lateinit var viewModel: TricaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.trica)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trica)

        viewModel = ViewModelProvider(this).get(TricaViewModel::class.java)

        val practicaTeo1 = findViewById<EditText>(R.id.practicaTeo1)
        val practicaTeo2 = findViewById<EditText>(R.id.practicaTeo2)
        val practicaLab1 = findViewById<EditText>(R.id.practicaLab1)
        val practicaLab2 = findViewById<EditText>(R.id.practicaLab2)
        val practicaLab3 = findViewById<EditText>(R.id.practicaLab3)
        val practicaLab4 = findViewById<EditText>(R.id.practicaLab4)
        val resultadoEditText = findViewById<TextView>(R.id.resultadoEditText)

        val btnCalcularPromedio = findViewById<Button>(R.id.btnCalcularPromedio)
        btnCalcularPromedio.setOnClickListener {
            val number1 = practicaTeo1.text.toString()
            val number2 = practicaTeo2.text.toString()
            val number3 = practicaLab1.text.toString()
            val number4 = practicaLab2.text.toString()
            val number5 = practicaLab3.text.toString()
            val number6 = practicaLab4.text.toString()

            val result = viewModel.sumNumbers(number1, number2, number3, number4, number5, number6)
            resultadoEditText.text = "El resultado es: $result"
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}