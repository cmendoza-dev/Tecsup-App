package com.tecsup.tecsupapp.trica

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tecsup.tecsupapp.R

class TricaActivity : AppCompatActivity() {

    private lateinit var viewModel: TricaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.trica)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trica)

        viewModel = ViewModelProvider(this)[TricaViewModel::class.java]

        val practicaTeo1 = findViewById<EditText>(R.id.practicaTeo1)
        val practicaTeo2 = findViewById<EditText>(R.id.practicaTeo2)
        val practicaLab1 = findViewById<EditText>(R.id.practicaLab1)
        val practicaLab2 = findViewById<EditText>(R.id.practicaLab2)
        val practicaLab3 = findViewById<EditText>(R.id.practicaLab3)
        val practicaLab4 = findViewById<EditText>(R.id.practicaLab4)
        val resultadoEditText = findViewById<TextView>(R.id.resultadoTextView)

        val btnCalcularPromedio = findViewById<Button>(R.id.btnCalcularPromedio)

        btnCalcularPromedio.setOnClickListener {
            val pTeo1 = practicaTeo1.text.toString()
            val pTeo2 = practicaTeo2.text.toString()
            val pLab1 = practicaLab1.text.toString()
            val pLab2 = practicaLab2.text.toString()
            val pLab3 = practicaLab3.text.toString()
            val pLab4 = practicaLab4.text.toString()

            val errorFields = ArrayList<String>()

            if (pTeo1.isBlank()) {
                errorFields.add("Práctica 1")
            } else if (pTeo2.isBlank()) {
                errorFields.add("Práctica 2")
            } else if (pLab1.isBlank()) {
                errorFields.add("Práctica 1")
            } else if (pLab2.isBlank()) {
                errorFields.add("Práctica 2")
            } else if (pLab3.isBlank()) {
                errorFields.add("Práctica 3")
            } else if (pLab4.isBlank()) {
                errorFields.add("Práctica 4")
            }
            if (errorFields.isNotEmpty()) {
                val errorMessage = "${errorFields.joinToString(", ")}"
                showErrorMessage(errorMessage)
            } else {
                try {
                    val result = viewModel.sumNumbers(pTeo1, pTeo2, pLab1, pLab2, pLab3, pLab4)
                    resultadoEditText.text = "  $result"
                } catch (e: Exception) {
                    val errorMessage = "Error en la suma: ${e.message}"
                    showErrorMessage(errorMessage)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showErrorMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ingrese la Nota")
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar", null)
        builder.show()
    }

}


/*var result = 0

    if ( pTeo1 < 0.toString() && pTeo1 > 20.toString() || pTeo2 < 0.toString() && pTeo2 > 20.toString() || pLab1 < 0.toString() && pLab1 > 20.toString() || pLab2 < 0.toString() && pLab2 > 20.toString() || pLab3 < 0.toString() && pLab3 > 20.toString() || pLab4 < 0.toString() && pLab4 > 20.toString()){
        tricaStringError.value = "Ingrese una nota válida"
    }else if(pTeo1.isEmpty()){
        tricaStringError.value = "Ingrese la Práctica 1"
    }else if(pTeo2.isEmpty()){
        tricaStringError.value = "Ingrese la Práctica 2"
    }else if(pLab1.isEmpty()){
        tricaStringError.value = "Ingrese la Práctica 1"
    }else if(pLab2.isEmpty()){
        tricaStringError.value = "Ingrese la Práctica 2"
    }else if(pLab3.isEmpty()){
        tricaStringError.value = "Ingrese la Práctica 3"
    }else if(pLab4.isEmpty()){
        tricaStringError.value = "Ingrese la Práctica 4"
    }else{
        result = viewModel.sumNumbers(pTeo1, pTeo2, pLab1, pLab2, pLab3, pLab4).toInt()
    }*/
