package com.tecsup.tecsupapp.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tecsup.tecsupapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NotaActivity: AppCompatActivity() {

    private lateinit var notaViewModel: NotaViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        notaViewModel = run {
            ViewModelProvider(this)[NotaViewModel::class.java]
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNotes)

        val adapter = NotaAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        notaViewModel.notas?.observe(this){ notas ->
            notas?.let {
                adapter.setNota(notas)
            }
        }

        val floatingNota = findViewById<FloatingActionButton>(R.id.floatingNota)
        floatingNota.setOnClickListener{
            registerAndUpdateNote()
        }


            //layoutManager =  LinearLayoutManager(context)
            //layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.notas)
        val drawable = resources.getDrawable(R.color.purple_640)
        supportActionBar?.setBackgroundDrawable(drawable)

    }

    private fun registerAndUpdateNote() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_nota, null)

        val titleAlertNote = "Registrar nota"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mDialogView.findViewById<Button>(R.id.btnCreate)
        val editTextTitleCreate  = mDialogView.findViewById<EditText>(R.id.edtTitleNote)
        val editTextDescriptionCreate  = mDialogView.findViewById<EditText>(R.id.edtDescriptionNote)

        buttonCreate.setOnClickListener {

            mAlertDialog.dismiss()

            val titleNote = editTextTitleCreate.text.toString()
            val descriptionNote = editTextDescriptionCreate.text.toString()
            val currentDateTime = LocalDateTime.now().formatChangeNote()

            var noteVM = Nota(titleNote, descriptionNote, currentDateTime)
            notaViewModel.saveNotas(noteVM)

        }


    }



    fun LocalDateTime.formatChangeNote() : String
            = this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}