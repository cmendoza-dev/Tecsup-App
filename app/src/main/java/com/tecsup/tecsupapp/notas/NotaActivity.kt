package com.tecsup.tecsupapp.notas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.tecsupapp.R

class NotaActivity: AppCompatActivity() {

    private val listNotas = listOf(
        Nota("Titulo nota 1", "contenido 1", "20-05-2023"),
        Nota("Titulo nota 2", "contenido 2", "19-05-2023"),
        Nota("Titulo nota 3", "contenido 3", "18-05-2023")
    )
    0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNotes)

        recyclerView.apply {
            layoutManager =  LinearLayoutManager(context)
            adapter = NotaAdapter(listNotas)
        }

    }
}