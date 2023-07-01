
package com.tecsup.tecsupapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.tecsupapp.network.Article
import com.tecsup.tecsupapp.noticias.NoticasViewModel
import com.tecsup.tecsupapp.noticias.NoticiaAdapter
import com.tecsup.tecsupapp.noticias.NoticiaItemClickListener

class NoticiasActivity : AppCompatActivity(),
    NoticiaItemClickListener {

    private lateinit var viewModel: NoticasViewModel
    private lateinit var adapter: NoticiaAdapter

    private lateinit var recyclerNoticias: RecyclerView
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val actionBar = supportActionBar
        actionBar?.hide()

        viewModel = ViewModelProvider(this)[NoticasViewModel::class.java]
        adapter = NoticiaAdapter(this)

        recyclerNoticias = findViewById(R.id.recyclerNoticias)
        recyclerNoticias.adapter = adapter
        recyclerNoticias.layoutManager = LinearLayoutManager(this)

        spinner = findViewById(R.id.noticias)
        val categorias = resources.getStringArray(R.array.noticias)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCategory = categorias[position]
                handleSelectedCategory(selectedCategory)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada en el Spinner
            }
        }

        viewModel.listNoticias("us", "business")
        observablesViewModel()
    }

    private fun handleSelectedCategory(category: String) {
        Toast.makeText(this, "Categoría seleccionada: $category", Toast.LENGTH_SHORT).show()
        viewModel.listNoticias("us", category)
    }

    private fun observablesViewModel() {
        viewModel.listNoticiasResponse.observe(this) { articles ->
            articles?.let {
                adapter.setArticle(it)
            }
        }
    }

    override fun onItemClick(item: Article) {
        // Acción a realizar cuando se hace clic en un artículo de noticias
    }
}
