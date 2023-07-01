package com.tecsup.tecsupapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.tecsup.tecsupapp.DashboardActivity
import com.tecsup.tecsupapp.R
import com.tecsup.tecsupapp.notas.NotaActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val edtCorreo = findViewById<TextInputEditText>(R.id.edtCorreo)
        val edtClave = findViewById<TextInputEditText>(R.id.edtClave)

        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        btnIngresar.setOnClickListener {

            val correo = edtCorreo.text.toString()
            val clave = edtClave.text.toString()
            viewModel.login(correo, clave)
        }

        observableViewModel()

        /*val buttonRegistrar = findViewById<Button>(R.id.btnRegistrar)
        buttonRegistrar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }*/

        val buttonRegistrar = findViewById<Button>(R.id.btnRegistrar)
        buttonRegistrar.setOnClickListener {
            startActivity(Intent(this, NotaActivity::class.java))
        }

        supportActionBar?.hide()
    }

    fun observableViewModel() {
        viewModel.userLoginStringError.observe(this) {
            // mostrar alerta con mensaje
            alertaMensaje(it)
        }
        viewModel.userLoginServiceResponse.observe(this) {
            if (it) {
                startActivity(Intent(this, DashboardActivity::class.java))
            }
        }
    }

    fun alertaMensaje(mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(mensaje)
        builder.setCancelable(false)
        builder.setPositiveButton("Aceptar") { _, _ -> }

        val alertDialog = builder.create()
        alertDialog.show()

    }


}

