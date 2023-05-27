package com.tecsup.tecsupapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView

class NotaAdapter():
    RecyclerView.Adapter<NotaViewHolder>() {

    private var notaLista = emptyList<Nota>()

    fun setNota(notas: List<Nota>){
        this.notaLista = notas
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return notaLista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NotaViewHolder(inflater, parent)

    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota : Nota = notaLista[position]
        holder.bind(nota)
    }

    interface ItemClickListener
    {
        fun onItemClickListener(noteItem: Nota)
    }


}