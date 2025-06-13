package com.example.estoqueapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0014B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/example/estoqueapp/ProdutoAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/estoqueapp/model/Produto;", "Lcom/example/estoqueapp/ProdutoAdapter$ProdutoViewHolder;", "onEditar", "Lkotlin/Function1;", "", "onExcluir", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnEditar", "()Lkotlin/jvm/functions/Function1;", "getOnExcluir", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ProdutoViewHolder", "app_debug"})
public final class ProdutoAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.estoqueapp.model.Produto, com.example.estoqueapp.ProdutoAdapter.ProdutoViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.estoqueapp.model.Produto, kotlin.Unit> onEditar = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.estoqueapp.model.Produto, kotlin.Unit> onExcluir = null;
    
    public ProdutoAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.estoqueapp.model.Produto, kotlin.Unit> onEditar, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.estoqueapp.model.Produto, kotlin.Unit> onExcluir) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<com.example.estoqueapp.model.Produto, kotlin.Unit> getOnEditar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<com.example.estoqueapp.model.Produto, kotlin.Unit> getOnExcluir() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.estoqueapp.ProdutoAdapter.ProdutoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.estoqueapp.ProdutoAdapter.ProdutoViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/estoqueapp/ProdutoAdapter$ProdutoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/estoqueapp/ProdutoAdapter;Landroid/view/View;)V", "bind", "", "produto", "Lcom/example/estoqueapp/model/Produto;", "app_debug"})
    public final class ProdutoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ProdutoViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.estoqueapp.model.Produto produto) {
        }
    }
}