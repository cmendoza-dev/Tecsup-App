package com.tecsup.tecsupapp.notas

import android.app.Application
import androidx.lifecycle.LiveData
import com.tecsup.tecsupapp.database.TecsupDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotaRepository(application: Application) {

    private val noteDAO: NotaDAO? = TecsupDataBase.getInstance(application)?.notaDAO()

    suspend fun insertNoteWithCoroutines(nota: Nota) {
        processInsertNote(nota)
    }

    private suspend fun processInsertNote(nota: Nota) {
        withContext(Dispatchers.Default) {
            noteDAO?.insert(nota)
        }
    }

    fun getNotes(): LiveData<List<Nota>>? {
        return noteDAO?.getNota()
    }

}