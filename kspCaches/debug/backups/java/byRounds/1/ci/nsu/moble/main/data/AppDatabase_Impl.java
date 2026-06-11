package ci.nsu.moble.main.data;

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
  private volatile DepositDao _depositDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `deposit_calculations` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `initialAmount` REAL NOT NULL, `periodMonths` INTEGER NOT NULL, `interestRate` REAL NOT NULL, `monthlyTopUp` REAL, `finalAmount` REAL NOT NULL, `interestEarned` REAL NOT NULL, `calculationDate` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0175cd46eaa2ce59b176ddf4f8e6a4e5')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `deposit_calculations`");
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
        final HashMap<String, TableInfo.Column> _columnsDepositCalculations = new HashMap<String, TableInfo.Column>(8);
        _columnsDepositCalculations.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("initialAmount", new TableInfo.Column("initialAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("periodMonths", new TableInfo.Column("periodMonths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("interestRate", new TableInfo.Column("interestRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("monthlyTopUp", new TableInfo.Column("monthlyTopUp", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("finalAmount", new TableInfo.Column("finalAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("interestEarned", new TableInfo.Column("interestEarned", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDepositCalculations.put("calculationDate", new TableInfo.Column("calculationDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDepositCalculations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDepositCalculations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDepositCalculations = new TableInfo("deposit_calculations", _columnsDepositCalculations, _foreignKeysDepositCalculations, _indicesDepositCalculations);
        final TableInfo _existingDepositCalculations = TableInfo.read(db, "deposit_calculations");
        if (!_infoDepositCalculations.equals(_existingDepositCalculations)) {
          return new RoomOpenHelper.ValidationResult(false, "deposit_calculations(ci.nsu.moble.main.data.DepositCalculation).\n"
                  + " Expected:\n" + _infoDepositCalculations + "\n"
                  + " Found:\n" + _existingDepositCalculations);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "0175cd46eaa2ce59b176ddf4f8e6a4e5", "464429bd024d4201699d1c63585e9e2c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "deposit_calculations");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `deposit_calculations`");
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
    _typeConvertersMap.put(DepositDao.class, DepositDao_Impl.getRequiredConverters());
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
  public DepositDao depositDao() {
    if (_depositDao != null) {
      return _depositDao;
    } else {
      synchronized(this) {
        if(_depositDao == null) {
          _depositDao = new DepositDao_Impl(this);
        }
        return _depositDao;
      }
    }
  }
}
