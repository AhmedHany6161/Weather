package com.weatherintake41itiahy.weather.model.room;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.weatherintake41itiahy.weather.model.entity.AlertEntity;
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity;
import com.weatherintake41itiahy.weather.model.entity.converters.DailyConverter;
import com.weatherintake41itiahy.weather.model.entity.converters.HourlyConverter;
import com.weatherintake41itiahy.weather.model.entity.converters.ListConverter;
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily;
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDAO_Impl implements WeatherDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherEntity> __insertionAdapterOfWeatherEntity;

  private final EntityInsertionAdapter<AlertEntity> __insertionAdapterOfAlertEntity;

  private final EntityDeletionOrUpdateAdapter<WeatherEntity> __deletionAdapterOfWeatherEntity;

  private final EntityDeletionOrUpdateAdapter<AlertEntity> __updateAdapterOfAlertEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteHome;

  public WeatherDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherEntity = new EntityInsertionAdapter<WeatherEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `WeatherEntity` (`city`,`latLng`,`sunrise`,`sunset`,`timeZone`,`isTheCurrent`,`listOfHourly`,`listOfDaily`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherEntity value) {
        if (value.getCity() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCity());
        }
        if (value.getLatLng() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLatLng());
        }
        stmt.bindLong(3, value.getSunrise());
        stmt.bindLong(4, value.getSunset());
        if (value.getTimeZone() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTimeZone());
        }
        final int _tmp;
        _tmp = value.isTheCurrent() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final String _tmp_1;
        _tmp_1 = HourlyConverter.convertToString(value.getListOfHourly());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = DailyConverter.stringToDaily(value.getListOfDaily());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
        }
      }
    };
    this.__insertionAdapterOfAlertEntity = new EntityInsertionAdapter<AlertEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AlertEntity` (`id`,`city`,`weatherState`,`from`,`duration`,`desc`,`listDays`,`more`,`notify`,`unitCount`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlertEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCity() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCity());
        }
        if (value.getWeatherState() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWeatherState());
        }
        stmt.bindLong(4, value.getFrom());
        stmt.bindLong(5, value.getDuration());
        if (value.getDesc() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDesc());
        }
        final String _tmp;
        _tmp = ListConverter.stringToList(value.getListDays());
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.getMore() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.getNotify() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        stmt.bindLong(10, value.getUnitCount());
      }
    };
    this.__deletionAdapterOfWeatherEntity = new EntityDeletionOrUpdateAdapter<WeatherEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `WeatherEntity` WHERE `city` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherEntity value) {
        if (value.getCity() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCity());
        }
      }
    };
    this.__updateAdapterOfAlertEntity = new EntityDeletionOrUpdateAdapter<AlertEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `AlertEntity` SET `id` = ?,`city` = ?,`weatherState` = ?,`from` = ?,`duration` = ?,`desc` = ?,`listDays` = ?,`more` = ?,`notify` = ?,`unitCount` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlertEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCity() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCity());
        }
        if (value.getWeatherState() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWeatherState());
        }
        stmt.bindLong(4, value.getFrom());
        stmt.bindLong(5, value.getDuration());
        if (value.getDesc() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDesc());
        }
        final String _tmp;
        _tmp = ListConverter.stringToList(value.getListDays());
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.getMore() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.getNotify() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        stmt.bindLong(10, value.getUnitCount());
        stmt.bindLong(11, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM WeatherEntity ";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteHome = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM WeatherEntity where isTheCurrent=1";
        return _query;
      }
    };
  }

  @Override
  public Object setWeather(final WeatherEntity weather, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeatherEntity.insert(weather);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object setAlert(final AlertEntity alertEntity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAlertEntity.insert(alertEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final WeatherEntity weather, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWeatherEntity.handle(weather);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateAlert(final AlertEntity alertEntity, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAlertEntity.handle(alertEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object deleteHome(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteHome.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteHome.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Flow<List<WeatherEntity>> getFavoriteWeather() {
    final String _sql = "SELECT * FROM WeatherEntity where isTheCurrent=0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"WeatherEntity"}, new Callable<List<WeatherEntity>>() {
      @Override
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfLatLng = CursorUtil.getColumnIndexOrThrow(_cursor, "latLng");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfTimeZone = CursorUtil.getColumnIndexOrThrow(_cursor, "timeZone");
          final int _cursorIndexOfIsTheCurrent = CursorUtil.getColumnIndexOrThrow(_cursor, "isTheCurrent");
          final int _cursorIndexOfListOfHourly = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfHourly");
          final int _cursorIndexOfListOfDaily = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfDaily");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WeatherEntity _item;
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpLatLng;
            _tmpLatLng = _cursor.getString(_cursorIndexOfLatLng);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            final String _tmpTimeZone;
            _tmpTimeZone = _cursor.getString(_cursorIndexOfTimeZone);
            final boolean _tmpIsTheCurrent;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsTheCurrent);
            _tmpIsTheCurrent = _tmp != 0;
            final List<Hourly> _tmpListOfHourly;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfListOfHourly);
            _tmpListOfHourly = HourlyConverter.convertToList(_tmp_1);
            final List<Daily> _tmpListOfDaily;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfListOfDaily);
            _tmpListOfDaily = DailyConverter.dailyToString(_tmp_2);
            _item = new WeatherEntity(_tmpCity,_tmpLatLng,_tmpSunrise,_tmpSunset,_tmpTimeZone,_tmpIsTheCurrent,_tmpListOfHourly,_tmpListOfDaily);
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

  @Override
  public Flow<WeatherEntity> getHomeWeather() {
    final String _sql = "SELECT * FROM WeatherEntity where isTheCurrent=1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"WeatherEntity"}, new Callable<WeatherEntity>() {
      @Override
      public WeatherEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfLatLng = CursorUtil.getColumnIndexOrThrow(_cursor, "latLng");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfTimeZone = CursorUtil.getColumnIndexOrThrow(_cursor, "timeZone");
          final int _cursorIndexOfIsTheCurrent = CursorUtil.getColumnIndexOrThrow(_cursor, "isTheCurrent");
          final int _cursorIndexOfListOfHourly = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfHourly");
          final int _cursorIndexOfListOfDaily = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfDaily");
          final WeatherEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpLatLng;
            _tmpLatLng = _cursor.getString(_cursorIndexOfLatLng);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            final String _tmpTimeZone;
            _tmpTimeZone = _cursor.getString(_cursorIndexOfTimeZone);
            final boolean _tmpIsTheCurrent;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsTheCurrent);
            _tmpIsTheCurrent = _tmp != 0;
            final List<Hourly> _tmpListOfHourly;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfListOfHourly);
            _tmpListOfHourly = HourlyConverter.convertToList(_tmp_1);
            final List<Daily> _tmpListOfDaily;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfListOfDaily);
            _tmpListOfDaily = DailyConverter.dailyToString(_tmp_2);
            _result = new WeatherEntity(_tmpCity,_tmpLatLng,_tmpSunrise,_tmpSunset,_tmpTimeZone,_tmpIsTheCurrent,_tmpListOfHourly,_tmpListOfDaily);
          } else {
            _result = null;
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

  @Override
  public Flow<List<WeatherEntity>> getAllWeather() {
    final String _sql = "SELECT * FROM WeatherEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"WeatherEntity"}, new Callable<List<WeatherEntity>>() {
      @Override
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfLatLng = CursorUtil.getColumnIndexOrThrow(_cursor, "latLng");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfTimeZone = CursorUtil.getColumnIndexOrThrow(_cursor, "timeZone");
          final int _cursorIndexOfIsTheCurrent = CursorUtil.getColumnIndexOrThrow(_cursor, "isTheCurrent");
          final int _cursorIndexOfListOfHourly = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfHourly");
          final int _cursorIndexOfListOfDaily = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfDaily");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WeatherEntity _item;
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpLatLng;
            _tmpLatLng = _cursor.getString(_cursorIndexOfLatLng);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            final String _tmpTimeZone;
            _tmpTimeZone = _cursor.getString(_cursorIndexOfTimeZone);
            final boolean _tmpIsTheCurrent;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsTheCurrent);
            _tmpIsTheCurrent = _tmp != 0;
            final List<Hourly> _tmpListOfHourly;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfListOfHourly);
            _tmpListOfHourly = HourlyConverter.convertToList(_tmp_1);
            final List<Daily> _tmpListOfDaily;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfListOfDaily);
            _tmpListOfDaily = DailyConverter.dailyToString(_tmp_2);
            _item = new WeatherEntity(_tmpCity,_tmpLatLng,_tmpSunrise,_tmpSunset,_tmpTimeZone,_tmpIsTheCurrent,_tmpListOfHourly,_tmpListOfDaily);
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

  @Override
  public Object getWeatherVal(final String cityName, final Continuation<? super WeatherEntity> p1) {
    final String _sql = "SELECT * FROM WeatherEntity where  city == ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cityName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cityName);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<WeatherEntity>() {
      @Override
      public WeatherEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfLatLng = CursorUtil.getColumnIndexOrThrow(_cursor, "latLng");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfTimeZone = CursorUtil.getColumnIndexOrThrow(_cursor, "timeZone");
          final int _cursorIndexOfIsTheCurrent = CursorUtil.getColumnIndexOrThrow(_cursor, "isTheCurrent");
          final int _cursorIndexOfListOfHourly = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfHourly");
          final int _cursorIndexOfListOfDaily = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfDaily");
          final WeatherEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpLatLng;
            _tmpLatLng = _cursor.getString(_cursorIndexOfLatLng);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            final String _tmpTimeZone;
            _tmpTimeZone = _cursor.getString(_cursorIndexOfTimeZone);
            final boolean _tmpIsTheCurrent;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsTheCurrent);
            _tmpIsTheCurrent = _tmp != 0;
            final List<Hourly> _tmpListOfHourly;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfListOfHourly);
            _tmpListOfHourly = HourlyConverter.convertToList(_tmp_1);
            final List<Daily> _tmpListOfDaily;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfListOfDaily);
            _tmpListOfDaily = DailyConverter.dailyToString(_tmp_2);
            _result = new WeatherEntity(_tmpCity,_tmpLatLng,_tmpSunrise,_tmpSunset,_tmpTimeZone,_tmpIsTheCurrent,_tmpListOfHourly,_tmpListOfDaily);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  @Override
  public Flow<List<AlertEntity>> getAllAlerts() {
    final String _sql = "SELECT * FROM AlertEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"AlertEntity"}, new Callable<List<AlertEntity>>() {
      @Override
      public List<AlertEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfWeatherState = CursorUtil.getColumnIndexOrThrow(_cursor, "weatherState");
          final int _cursorIndexOfFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "from");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
          final int _cursorIndexOfListDays = CursorUtil.getColumnIndexOrThrow(_cursor, "listDays");
          final int _cursorIndexOfMore = CursorUtil.getColumnIndexOrThrow(_cursor, "more");
          final int _cursorIndexOfNotify = CursorUtil.getColumnIndexOrThrow(_cursor, "notify");
          final int _cursorIndexOfUnitCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unitCount");
          final List<AlertEntity> _result = new ArrayList<AlertEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlertEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpWeatherState;
            _tmpWeatherState = _cursor.getString(_cursorIndexOfWeatherState);
            final int _tmpFrom;
            _tmpFrom = _cursor.getInt(_cursorIndexOfFrom);
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final String _tmpDesc;
            _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            final List<String> _tmpListDays;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfListDays);
            _tmpListDays = ListConverter.listToString(_tmp);
            final boolean _tmpMore;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMore);
            _tmpMore = _tmp_1 != 0;
            final boolean _tmpNotify;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNotify);
            _tmpNotify = _tmp_2 != 0;
            final int _tmpUnitCount;
            _tmpUnitCount = _cursor.getInt(_cursorIndexOfUnitCount);
            _item = new AlertEntity(_tmpId,_tmpCity,_tmpWeatherState,_tmpFrom,_tmpDuration,_tmpDesc,_tmpListDays,_tmpMore,_tmpNotify,_tmpUnitCount);
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

  @Override
  public Object getAllAlertsVal(final Continuation<? super List<AlertEntity>> p0) {
    final String _sql = "SELECT * FROM AlertEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<AlertEntity>>() {
      @Override
      public List<AlertEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfWeatherState = CursorUtil.getColumnIndexOrThrow(_cursor, "weatherState");
          final int _cursorIndexOfFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "from");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
          final int _cursorIndexOfListDays = CursorUtil.getColumnIndexOrThrow(_cursor, "listDays");
          final int _cursorIndexOfMore = CursorUtil.getColumnIndexOrThrow(_cursor, "more");
          final int _cursorIndexOfNotify = CursorUtil.getColumnIndexOrThrow(_cursor, "notify");
          final int _cursorIndexOfUnitCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unitCount");
          final List<AlertEntity> _result = new ArrayList<AlertEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AlertEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpWeatherState;
            _tmpWeatherState = _cursor.getString(_cursorIndexOfWeatherState);
            final int _tmpFrom;
            _tmpFrom = _cursor.getInt(_cursorIndexOfFrom);
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final String _tmpDesc;
            _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            final List<String> _tmpListDays;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfListDays);
            _tmpListDays = ListConverter.listToString(_tmp);
            final boolean _tmpMore;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMore);
            _tmpMore = _tmp_1 != 0;
            final boolean _tmpNotify;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNotify);
            _tmpNotify = _tmp_2 != 0;
            final int _tmpUnitCount;
            _tmpUnitCount = _cursor.getInt(_cursorIndexOfUnitCount);
            _item = new AlertEntity(_tmpId,_tmpCity,_tmpWeatherState,_tmpFrom,_tmpDuration,_tmpDesc,_tmpListDays,_tmpMore,_tmpNotify,_tmpUnitCount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
