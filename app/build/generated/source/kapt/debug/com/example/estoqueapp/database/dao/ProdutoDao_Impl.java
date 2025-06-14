package com.example.estoqueapp.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.estoqueapp.model.Produto;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ProdutoDao_Impl implements ProdutoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Produto> __insertionAdapterOfProduto;

  private final EntityDeletionOrUpdateAdapter<Produto> __deletionAdapterOfProduto;

  private final EntityDeletionOrUpdateAdapter<Produto> __updateAdapterOfProduto;

  public ProdutoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduto = new EntityInsertionAdapter<Produto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `produtos` (`codigo`,`id`,`nome`,`quantidade`,`preco`,`origem`,`alcool`,`tipo`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Produto entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getId());
        }
        if (entity.getNome() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNome());
        }
        statement.bindLong(4, entity.getQuantidade());
        statement.bindDouble(5, entity.getPreco());
        if (entity.getOrigem() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getOrigem());
        }
        statement.bindDouble(7, entity.getAlcool());
        if (entity.getTipo() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTipo());
        }
      }
    };
    this.__deletionAdapterOfProduto = new EntityDeletionOrUpdateAdapter<Produto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `produtos` WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Produto entity) {
        statement.bindLong(1, entity.getCodigo());
      }
    };
    this.__updateAdapterOfProduto = new EntityDeletionOrUpdateAdapter<Produto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `produtos` SET `codigo` = ?,`id` = ?,`nome` = ?,`quantidade` = ?,`preco` = ?,`origem` = ?,`alcool` = ?,`tipo` = ? WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Produto entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getId());
        }
        if (entity.getNome() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNome());
        }
        statement.bindLong(4, entity.getQuantidade());
        statement.bindDouble(5, entity.getPreco());
        if (entity.getOrigem() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getOrigem());
        }
        statement.bindDouble(7, entity.getAlcool());
        if (entity.getTipo() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTipo());
        }
        statement.bindLong(9, entity.getCodigo());
      }
    };
  }

  @Override
  public Object inserir(final Produto produto, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProduto.insert(produto);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletar(final Produto produto, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfProduto.handle(produto);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object atualizar(final Produto produto, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfProduto.handle(produto);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Produto>> listarTodos() {
    final String _sql = "SELECT * FROM produtos ORDER BY nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"produtos"}, false, new Callable<List<Produto>>() {
      @Override
      @Nullable
      public List<Produto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfQuantidade = CursorUtil.getColumnIndexOrThrow(_cursor, "quantidade");
          final int _cursorIndexOfPreco = CursorUtil.getColumnIndexOrThrow(_cursor, "preco");
          final int _cursorIndexOfOrigem = CursorUtil.getColumnIndexOrThrow(_cursor, "origem");
          final int _cursorIndexOfAlcool = CursorUtil.getColumnIndexOrThrow(_cursor, "alcool");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final List<Produto> _result = new ArrayList<Produto>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Produto _item;
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpQuantidade;
            _tmpQuantidade = _cursor.getInt(_cursorIndexOfQuantidade);
            final double _tmpPreco;
            _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
            final String _tmpOrigem;
            if (_cursor.isNull(_cursorIndexOfOrigem)) {
              _tmpOrigem = null;
            } else {
              _tmpOrigem = _cursor.getString(_cursorIndexOfOrigem);
            }
            final double _tmpAlcool;
            _tmpAlcool = _cursor.getDouble(_cursorIndexOfAlcool);
            final String _tmpTipo;
            if (_cursor.isNull(_cursorIndexOfTipo)) {
              _tmpTipo = null;
            } else {
              _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            }
            _item = new Produto(_tmpCodigo,_tmpId,_tmpNome,_tmpQuantidade,_tmpPreco,_tmpOrigem,_tmpAlcool,_tmpTipo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
