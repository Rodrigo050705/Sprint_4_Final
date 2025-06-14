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
import androidx.core.widget.doOnTextChanged


class MainActivity : AppCompatActivity() {

    private var listaCompleta: List<Produto> = emptyList()

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
        val etId = findViewById<EditText>(R.id.etId)
        val etOrigem = findViewById<EditText>(R.id.etOrigem)
        val etAlcool = findViewById<EditText>(R.id.etAlcool)
        val etTipo = findViewById<EditText>(R.id.etTipo)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val rvProdutos = findViewById<RecyclerView>(R.id.rvProdutos)
        val etBusca = findViewById<EditText>(R.id.etBusca)

        adapter = ProdutoAdapter(
            onEditar = { produto ->
                produtoEditando = produto
                etNome.setText(produto.nome)
                etQuantidade.setText(produto.quantidade.toString())
                etPreco.setText(produto.preco.toString())
                etId.setText(produto.id)
                etOrigem.setText(produto.origem)
                etAlcool.setText(produto.alcool.toString())
                etTipo.setText(produto.tipo)
                btnSalvar.text = "Atualizar"
            },
            onExcluir = { produto ->
                viewModel.deletar(produto)
            }
        )

        rvProdutos.layoutManager = LinearLayoutManager(this)
        rvProdutos.adapter = adapter

        viewModel.todosProdutos.observe(this, Observer { produtos ->
            listaCompleta = produtos
            adapter.submitList(produtos)
        })

        etBusca.doOnTextChanged { texto, _, _, _ ->
            val busca = texto.toString().trim().lowercase()
            val filtrados = listaCompleta.filter { produto ->
                produto.nome.lowercase().contains(busca) || produto.id.lowercase().contains(busca)
            }
            adapter.submitList(filtrados)
        }

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val quantidade = etQuantidade.text.toString().toIntOrNull() ?: 0
            val preco = etPreco.text.toString().toDoubleOrNull() ?: 0.0
            val idProduto = etId.text.toString()
            val origem = etOrigem.text.toString()
            val alcool = etAlcool.text.toString().toDoubleOrNull() ?: 0.0
            val tipo = etTipo.text.toString()

            if (nome.isBlank()) {
                Toast.makeText(this, "Nome é obrigatório", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val produto = Produto(
                codigo = produtoEditando?.codigo ?: 0,
                id = idProduto,
                nome = nome,
                quantidade = quantidade,
                preco = preco,
                origem = origem,
                alcool = alcool,
                tipo = tipo
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
            etId.text.clear()
            etOrigem.text.clear()
            etAlcool.text.clear()
            etTipo.text.clear()

        }
    }
}
