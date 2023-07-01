package com.tecsup.tecsupapp.noticias

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tecsup.tecsupapp.R
import com.tecsup.tecsupapp.network.Article

class NoticiaViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_noticia, parent,
        false)){

    private var imgPortada: ImageView? = null
    private var textTitulo: TextView? = null
    private var textContenido: TextView? = null

    init {
        imgPortada = itemView.findViewById(R.id.imgNoticiaPortada)
        textTitulo = itemView.findViewById(R.id.textNoticiaTitulo)
        textContenido = itemView.findViewById(R.id.textNoticiaContenido)
    }

    fun bind(article: Article) {
        textTitulo?.text = article.title
        textContenido?.text = article.content

        val url = article.urlToImage

        val options = RequestOptions()
            .placeholder(R.drawable.layout_bg)
            .error(R.drawable.layout_bg
            )

        imgPortada?.let {
            Glide.with(it)
                .setDefaultRequestOptions(options)
                .load(url)
                .into(it)
        }

    }
}