package com.tecsup.tecsupapp.notas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Nota(
    @ColumnInfo(name = "titulo_note")
    var titulo: String,
    @ColumnInfo(name = "description_note")
    var contenido: String,
    @ColumnInfo(name = "date_note")
    var fecha: String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_note")
    var noteId: Int = 0

}














