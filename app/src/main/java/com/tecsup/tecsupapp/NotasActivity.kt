package com.tecsup.tecsupapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NotasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Gestión de notas"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.itemRegister -> {
                Toast.makeText(this, "Se selecciono registrar nota", Toast.LENGTH_LONG).show()
            }
            R.id.itemSearch -> {
                Toast.makeText(this, "Se selecciono buscar nota", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)

    }


}