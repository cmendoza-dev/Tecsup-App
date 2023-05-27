package com.tecsup.tecsupapp.notas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotaViewModel(application: Application): AndroidViewModel(application){

    private val repository = NotaRepository(application)

    val notas = repository.getNotes()

    fun saveNotas(nota: Nota) {
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(nota)
        }
    }

}