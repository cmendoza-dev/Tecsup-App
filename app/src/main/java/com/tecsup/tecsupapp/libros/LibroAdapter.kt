package com.tecsup.tecsupapp.libros

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.tecsupapp.R

class LibroAdapter(private val bookList: List<Libro>) : RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = bookList[position]
        holder.bookImage.setImageResource(book.imageResId)
        holder.bookTitle.text = book.title
        holder.bookDescription.text = book.description
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage: ImageView = itemView.findViewById(R.id.bookImage)
        val bookTitle: TextView = itemView.findViewById(R.id.bookTitle)
        val bookDescription: TextView = itemView.findViewById(R.id.bookDescription)
    }
}