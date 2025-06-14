package com.example.estoqueapp.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.estoqueapp.model.Produto

@Database(entities = [Produto::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

    companion object {
        @Volatile private var instancia: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instancia ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "estoque_db"
                )
                .fallbackToDestructiveMigration() // <--- ADICIONE ISSO
                .build()
                .also { instancia = it }
            }
        }
    }
}