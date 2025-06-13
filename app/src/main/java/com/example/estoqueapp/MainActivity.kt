package com.example.estoqueapp

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.estoqueapp.database.repository.ProdutoViewModel
import com.example.estoqueapp.model.Produto

class MainActivity : AppCompatActivity() {

    // ✅ ViewModel declarada corretamente
    private val viewModel: ProdutoViewModel by viewModels()

    private lateinit var adapter: ProdutoAdapter
    private var produtoEditando: Produto? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome = findViewById<EditText>(R.id.etNome)
        val etQuantidade = findViewById<EditText>(R.id.etQuantidade)
        val etPreco = findViewById<EditText>(R.id.etPreco)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val rvProdutos = findViewById<RecyclerView>(R.id.rvProdutos)

        adapter = ProdutoAdapter(
            onEditar = { produto ->
                produtoEditando = produto
                etNome.setText(produto.nome)
                etQuantidade.setText(produto.quantidade.toString())
                etPreco.setText(produto.preco.toString())
                btnSalvar.text = "Atualizar"
            },
            onExcluir = { produto ->
                viewModel.deletar(produto)
            }
        )

        rvProdutos.layoutManager = LinearLayoutManager(this)
        rvProdutos.adapter = adapter

        viewModel.todosProdutos.observe(this, Observer { produtos ->
            adapter.submitList(produtos)
        })

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val quantidade = etQuantidade.text.toString().toIntOrNull() ?: 0
            val preco = etPreco.text.toString().toDoubleOrNull() ?: 0.0

            if (nome.isBlank()) {
                Toast.makeText(this, "Nome é obrigatório", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val produto = Produto(
                id = produtoEditando?.id ?: 0,
                nome = nome,
                quantidade = quantidade,
                preco = preco
            )

            if (produtoEditando == null) {
                viewModel.inserir(produto)
            } else {
                viewModel.atualizar(produto)
                produtoEditando = null
                btnSalvar.text = "Salvar"
            }

            etNome.text.clear()
            etQuantidade.text.clear()
            etPreco.text.clear()
        }
    }
}
