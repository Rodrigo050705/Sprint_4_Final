package com.example.estoqueapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class Produto(
    @PrimaryKey(autoGenerate = true) val codigo: Int = 0, // Renomeei para evitar conflito com id String
    val id: String,
    val nome: String,
    val quantidade: Int,
    val preco: Double,
    val origem: String,
    val alcool: Double,
    val tipo: String
)
