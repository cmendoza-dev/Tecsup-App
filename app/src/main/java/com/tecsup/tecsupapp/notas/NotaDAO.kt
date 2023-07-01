package com.tecsup.tecsupapp.notas

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotaDAO {
    @Insert
    fun insert(nota: Nota)

    @Update
    fun update(nota: Nota)

    @Delete
    fun delete(nota: Nota)

    @Query("SELECT * FROM note_table")
    fun getNota(): LiveData<List<Nota>>

}