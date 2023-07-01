package com.tecsup.tecsupapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.tecsupapp.R

class NotaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_nota, parent, false)) {

    private var textDate: TextView? = null
    private var textTitle: TextView? = null
    private var textDescription: TextView? = null

    init {
        textDate = itemView.findViewById(R.id.textDate)
        textTitle = itemView.findViewById(R.id.textTitle)
        textDescription = itemView.findViewById(R.id.textDescription)
    }

    fun bind(nota: Nota) {
        textDate?.text = nota.fecha
        textTitle?.text = nota.titulo
        textDescription?.text = nota.contenido
    }
}




