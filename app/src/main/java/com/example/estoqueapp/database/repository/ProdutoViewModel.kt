package com.example.estoqueapp.database.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.estoqueapp.database.dao.AppDatabase
import com.example.estoqueapp.model.Produto
import kotlinx.coroutines.launch

class ProdutoViewModel(application: Application) : AndroidViewModel(application) {

    private val produtoDao = AppDatabase.Companion.getDatabase(application).produtoDao()
    val todosProdutos: LiveData<List<Produto>> = produtoDao.listarTodos()

    fun inserir(produto: Produto) = viewModelScope.launch { produtoDao.inserir(produto) }
    fun atualizar(produto: Produto) = viewModelScope.launch { produtoDao.atualizar(produto) }
    fun deletar(produto: Produto) = viewModelScope.launch { produtoDao.deletar(produto) }
}