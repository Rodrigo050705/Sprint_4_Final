package com.example.estoqueapp.database.dao;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ProdutoDao _produtoDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `produtos` (`codigo` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT NOT NULL, `nome` TEXT NOT NULL, `quantidade` INTEGER NOT NULL, `preco` REAL NOT NULL, `origem` TEXT NOT NULL, `alcool` REAL NOT NULL, `tipo` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5b9b0f152b6fd797af589a78f00e76e4')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `produtos`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsProdutos = new HashMap<String, TableInfo.Column>(8);
        _columnsProdutos.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("id", new TableInfo.Column("id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("quantidade", new TableInfo.Column("quantidade", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("preco", new TableInfo.Column("preco", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("origem", new TableInfo.Column("origem", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("alcool", new TableInfo.Column("alcool", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("tipo", new TableInfo.Column("tipo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProdutos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProdutos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProdutos = new TableInfo("produtos", _columnsProdutos, _foreignKeysProdutos, _indicesProdutos);
        final TableInfo _existingProdutos = TableInfo.read(db, "produtos");
        if (!_infoProdutos.equals(_existingProdutos)) {
          return new RoomOpenHelper.ValidationResult(false, "produtos(com.example.estoqueapp.model.Produto).\n"
                  + " Expected:\n" + _infoProdutos + "\n"
                  + " Found:\n" + _existingProdutos);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5b9b0f152b6fd797af589a78f00e76e4", "9f104098015d40e527bea0b0721811af");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "produtos");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `produtos`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProdutoDao.class, ProdutoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ProdutoDao produtoDao() {
    if (_produtoDao != null) {
      return _produtoDao;
    } else {
      synchronized(this) {
        if(_produtoDao == null) {
          _produtoDao = new ProdutoDao_Impl(this);
        }
        return _produtoDao;
      }
    }
  }
}
