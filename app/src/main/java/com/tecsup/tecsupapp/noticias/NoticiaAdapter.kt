package com.tecsup.tecsupapp.noticias

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.tecsupapp.network.Article

interface NoticiaItemClickListener{
    fun onItemClick(item: Article)
}

class NoticiaAdapter (private val mItemClickListener: NoticiaItemClickListener):
    RecyclerView.Adapter<NoticiaViewHolder>() {

    private var articleList = emptyList<Article>()

    fun setArticle(articles: List<Article>) {
        this.articleList = articles
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = articleList.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NoticiaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoticiaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val article: Article = articleList[position]
        holder.bind(article)

        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(article)
        }
    }

}