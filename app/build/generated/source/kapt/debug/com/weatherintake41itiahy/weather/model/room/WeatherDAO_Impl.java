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
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity;
import com.weatherintake41itiahy.weather.model.entity.converters.DailyConverter;
import com.weatherintake41itiahy.weather.model.entity.converters.HourlyConverter;
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily;
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
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

  private final EntityDeletionOrUpdateAdapter<WeatherEntity> __deletionAdapterOfWeatherEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public WeatherDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherEntity = new EntityInsertionAdapter<WeatherEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `WeatherEntity` (`city`,`latLng`,`sunrise`,`sunset`,`isTheCurrent`,`listOfHourly`,`listOfDaily`) VALUES (?,?,?,?,?,?,?)";
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
        if (value.getSunrise() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSunrise());
        }
        if (value.getSunset() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSunset());
        }
        final Integer _tmp;
        _tmp = value.isTheCurrent() == null ? null : (value.isTheCurrent() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = HourlyConverter.convertToString(value.getListOfHourly());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = DailyConverter.stringToDaily(value.getListOfDaily());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
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
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM WeatherEntity ";
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
            final Long _tmpSunrise;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmpSunrise = null;
            } else {
              _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            }
            final Long _tmpSunset;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmpSunset = null;
            } else {
              _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            }
            final Boolean _tmpIsTheCurrent;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsTheCurrent)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsTheCurrent);
            }
            _tmpIsTheCurrent = _tmp == null ? null : _tmp != 0;
            final List<Hourly> _tmpListOfHourly;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfListOfHourly);
            _tmpListOfHourly = HourlyConverter.convertToList(_tmp_1);
            final List<Daily> _tmpListOfDaily;
            final String _tmp_2;
            _tmp_2 = _cursor.getString(_cursorIndexOfListOfDaily);
            _tmpListOfDaily = DailyConverter.dailyToString(_tmp_2);
            _item = new WeatherEntity(_tmpCity,_tmpLatLng,_tmpSunrise,_tmpSunset,_tmpIsTheCurrent,_tmpListOfHourly,_tmpListOfDaily);
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
  public Flow<WeatherEntity> getCurrentWeather() {
    final String _sql = "SELECT city,latLng,sunrise,sunset,isTheCurrent,listOfHourly FROM WeatherEntity where isTheCurrent=1";
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
          final int _cursorIndexOfIsTheCurrent = CursorUtil.getColumnIndexOrThrow(_cursor, "isTheCurrent");
          final int _cursorIndexOfListOfHourly = CursorUtil.getColumnIndexOrThrow(_cursor, "listOfHourly");
          final WeatherEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpLatLng;
            _tmpLatLng = _cursor.getString(_cursorIndexOfLatLng);
            final Long _tmpSunrise;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmpSunrise = null;
            } else {
              _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            }
            final Long _tmpSunset;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmpSunset = null;
            } else {
              _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            }
            final Boolean _tmpIsTheCurrent;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsTheCurrent)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsTheCurrent);
            }
            _tmpIsTheCurrent = _tmp == null ? null : _tmp != 0;
            final List<Hourly> _tmpListOfHourly;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfListOfHourly);
            _tmpListOfHourly = HourlyConverter.convertToList(_tmp_1);
            _result = new WeatherEntity(_tmpCity,_tmpLatLng,_tmpSunrise,_tmpSunset,_tmpIsTheCurrent,_tmpListOfHourly,null);
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
}
