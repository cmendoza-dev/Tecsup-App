package com.tecsup.tecsupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Crear un hilo
        Thread(Runnable {
            // Tarea a ejecutar en segundo plano
            // Aquí puedes hacer cosas como descargar datos de una API, procesar información, etc.

            // Actualizar la interfaz de usuario en el hilo principal
            runOnUiThread {
                // Aquí puedes actualizar la interfaz de usuario con los resultados de la tarea en segundo plano
            }
        }).start()


    }
}


