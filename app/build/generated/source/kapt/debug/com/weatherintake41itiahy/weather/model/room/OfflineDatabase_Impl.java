package com.weatherintake41itiahy.weather.model.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OfflineDatabase_Impl extends OfflineDatabase {
  private volatile WeatherDAO _weatherDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `WeatherEntity` (`city` TEXT NOT NULL, `latLng` TEXT NOT NULL, `sunrise` INTEGER NOT NULL, `sunset` INTEGER NOT NULL, `timeZone` TEXT NOT NULL, `isTheCurrent` INTEGER NOT NULL, `listOfHourly` TEXT NOT NULL, `listOfDaily` TEXT NOT NULL, PRIMARY KEY(`city`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AlertEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `city` TEXT NOT NULL, `weatherState` TEXT NOT NULL, `from` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `desc` TEXT NOT NULL, `listDays` TEXT NOT NULL, `more` INTEGER NOT NULL, `notify` INTEGER NOT NULL, `unitCount` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2b11c38e52e785d2c699c22a858343fe')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `WeatherEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `AlertEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWeatherEntity = new HashMap<String, TableInfo.Column>(8);
        _columnsWeatherEntity.put("city", new TableInfo.Column("city", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("latLng", new TableInfo.Column("latLng", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("sunrise", new TableInfo.Column("sunrise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("sunset", new TableInfo.Column("sunset", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("timeZone", new TableInfo.Column("timeZone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("isTheCurrent", new TableInfo.Column("isTheCurrent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("listOfHourly", new TableInfo.Column("listOfHourly", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherEntity.put("listOfDaily", new TableInfo.Column("listOfDaily", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWeatherEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWeatherEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWeatherEntity = new TableInfo("WeatherEntity", _columnsWeatherEntity, _foreignKeysWeatherEntity, _indicesWeatherEntity);
        final TableInfo _existingWeatherEntity = TableInfo.read(_db, "WeatherEntity");
        if (! _infoWeatherEntity.equals(_existingWeatherEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "WeatherEntity(com.weatherintake41itiahy.weather.model.entity.WeatherEntity).\n"
                  + " Expected:\n" + _infoWeatherEntity + "\n"
                  + " Found:\n" + _existingWeatherEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsAlertEntity = new HashMap<String, TableInfo.Column>(10);
        _columnsAlertEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("weatherState", new TableInfo.Column("weatherState", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("from", new TableInfo.Column("from", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("desc", new TableInfo.Column("desc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("listDays", new TableInfo.Column("listDays", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("more", new TableInfo.Column("more", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("notify", new TableInfo.Column("notify", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertEntity.put("unitCount", new TableInfo.Column("unitCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlertEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlertEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlertEntity = new TableInfo("AlertEntity", _columnsAlertEntity, _foreignKeysAlertEntity, _indicesAlertEntity);
        final TableInfo _existingAlertEntity = TableInfo.read(_db, "AlertEntity");
        if (! _infoAlertEntity.equals(_existingAlertEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "AlertEntity(com.weatherintake41itiahy.weather.model.entity.AlertEntity).\n"
                  + " Expected:\n" + _infoAlertEntity + "\n"
                  + " Found:\n" + _existingAlertEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "2b11c38e52e785d2c699c22a858343fe", "8c74f60d404a42a2ed3bccff8a5b48b8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "WeatherEntity","AlertEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `WeatherEntity`");
      _db.execSQL("DELETE FROM `AlertEntity`");
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
  public WeatherDAO WeatherDAO() {
    if (_weatherDAO != null) {
      return _weatherDAO;
    } else {
      synchronized(this) {
        if(_weatherDAO == null) {
          _weatherDAO = new WeatherDAO_Impl(this);
        }
        return _weatherDAO;
      }
    }
  }
}
