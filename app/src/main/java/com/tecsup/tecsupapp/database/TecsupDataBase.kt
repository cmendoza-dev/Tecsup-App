package com.tecsup.tecsupapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsup.tecsupapp.notas.Nota
import com.tecsup.tecsupapp.notas.NotaDAO

@Database(entities = [Nota::class], version = 1)
abstract class TecsupDataBase : RoomDatabase() {

    abstract fun notaDAO(): NotaDAO

    companion object {

        private const val DATABASE_NAME = "tecsup_database"

        @Volatile
        private var INSTANCE: TecsupDataBase? = null

        fun getInstance(context: Context): TecsupDataBase? {
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TecsupDataBase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            return INSTANCE
        }


    }

}