package com.example.estoqueapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.estoqueapp.model.Produto

@Dao
interface ProdutoDao {
    @Insert
    suspend fun inserir(produto: Produto)
    @Update
    suspend fun atualizar(produto: Produto)
    @Delete
    suspend fun deletar(produto: Produto)
    @Query("SELECT * FROM produtos ORDER BY nome ASC")
    fun listarTodos(): LiveData<List<Produto>>
}