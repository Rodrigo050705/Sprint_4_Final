package com.example.estoqueapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.estoqueapp.model.Produto

class ProdutoAdapter(
    val onEditar: (Produto) -> Unit,
    val onExcluir: (Produto) -> Unit
) : ListAdapter<Produto, ProdutoAdapter.ProdutoViewHolder>(ProdutoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = getItem(position)
        holder.bind(produto)
    }

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(produto: Produto) {
            val info = """
            ID: ${produto.id}
            ${produto.nome} - ${produto.quantidade} und - R$ %.2f
            Origem: ${produto.origem} | Teor: ${produto.alcool}%% | Tipo: ${produto.tipo}
            """.trimIndent().format(produto.preco)

            itemView.findViewById<TextView>(R.id.tvInfo).text = info

            itemView.findViewById<Button>(R.id.btnEditar).setOnClickListener { onEditar(produto) }
            itemView.findViewById<Button>(R.id.btnExcluir).setOnClickListener { onExcluir(produto) }
        }
    }
}

class ProdutoDiffCallback : DiffUtil.ItemCallback<Produto>() {
    override fun areItemsTheSame(oldItem: Produto, newItem: Produto) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Produto, newItem: Produto) = oldItem == newItem
}
