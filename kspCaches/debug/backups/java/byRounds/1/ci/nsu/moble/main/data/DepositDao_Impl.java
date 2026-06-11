package ci.nsu.moble.main.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DepositDao_Impl implements DepositDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DepositCalculation> __insertionAdapterOfDepositCalculation;

  public DepositDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDepositCalculation = new EntityInsertionAdapter<DepositCalculation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `deposit_calculations` (`id`,`initialAmount`,`periodMonths`,`interestRate`,`monthlyTopUp`,`finalAmount`,`interestEarned`,`calculationDate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DepositCalculation entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getInitialAmount());
        statement.bindLong(3, entity.getPeriodMonths());
        statement.bindDouble(4, entity.getInterestRate());
        if (entity.getMonthlyTopUp() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getMonthlyTopUp());
        }
        statement.bindDouble(6, entity.getFinalAmount());
        statement.bindDouble(7, entity.getInterestEarned());
        statement.bindLong(8, entity.getCalculationDate());
      }
    };
  }

  @Override
  public Object insertCalculation(final DepositCalculation calculation,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDepositCalculation.insert(calculation);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DepositCalculation>> getAllCalculations() {
    final String _sql = "SELECT * FROM deposit_calculations ORDER BY calculationDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"deposit_calculations"}, new Callable<List<DepositCalculation>>() {
      @Override
      @NonNull
      public List<DepositCalculation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfInitialAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "initialAmount");
          final int _cursorIndexOfPeriodMonths = CursorUtil.getColumnIndexOrThrow(_cursor, "periodMonths");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfMonthlyTopUp = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyTopUp");
          final int _cursorIndexOfFinalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "finalAmount");
          final int _cursorIndexOfInterestEarned = CursorUtil.getColumnIndexOrThrow(_cursor, "interestEarned");
          final int _cursorIndexOfCalculationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "calculationDate");
          final List<DepositCalculation> _result = new ArrayList<DepositCalculation>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DepositCalculation _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final double _tmpInitialAmount;
            _tmpInitialAmount = _cursor.getDouble(_cursorIndexOfInitialAmount);
            final int _tmpPeriodMonths;
            _tmpPeriodMonths = _cursor.getInt(_cursorIndexOfPeriodMonths);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final Double _tmpMonthlyTopUp;
            if (_cursor.isNull(_cursorIndexOfMonthlyTopUp)) {
              _tmpMonthlyTopUp = null;
            } else {
              _tmpMonthlyTopUp = _cursor.getDouble(_cursorIndexOfMonthlyTopUp);
            }
            final double _tmpFinalAmount;
            _tmpFinalAmount = _cursor.getDouble(_cursorIndexOfFinalAmount);
            final double _tmpInterestEarned;
            _tmpInterestEarned = _cursor.getDouble(_cursorIndexOfInterestEarned);
            final long _tmpCalculationDate;
            _tmpCalculationDate = _cursor.getLong(_cursorIndexOfCalculationDate);
            _item = new DepositCalculation(_tmpId,_tmpInitialAmount,_tmpPeriodMonths,_tmpInterestRate,_tmpMonthlyTopUp,_tmpFinalAmount,_tmpInterestEarned,_tmpCalculationDate);
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
  public Object getCalculationById(final long id,
      final Continuation<? super DepositCalculation> $completion) {
    final String _sql = "SELECT * FROM deposit_calculations WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<DepositCalculation>() {
      @Override
      @Nullable
      public DepositCalculation call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfInitialAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "initialAmount");
          final int _cursorIndexOfPeriodMonths = CursorUtil.getColumnIndexOrThrow(_cursor, "periodMonths");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfMonthlyTopUp = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyTopUp");
          final int _cursorIndexOfFinalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "finalAmount");
          final int _cursorIndexOfInterestEarned = CursorUtil.getColumnIndexOrThrow(_cursor, "interestEarned");
          final int _cursorIndexOfCalculationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "calculationDate");
          final DepositCalculation _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final double _tmpInitialAmount;
            _tmpInitialAmount = _cursor.getDouble(_cursorIndexOfInitialAmount);
            final int _tmpPeriodMonths;
            _tmpPeriodMonths = _cursor.getInt(_cursorIndexOfPeriodMonths);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final Double _tmpMonthlyTopUp;
            if (_cursor.isNull(_cursorIndexOfMonthlyTopUp)) {
              _tmpMonthlyTopUp = null;
            } else {
              _tmpMonthlyTopUp = _cursor.getDouble(_cursorIndexOfMonthlyTopUp);
            }
            final double _tmpFinalAmount;
            _tmpFinalAmount = _cursor.getDouble(_cursorIndexOfFinalAmount);
            final double _tmpInterestEarned;
            _tmpInterestEarned = _cursor.getDouble(_cursorIndexOfInterestEarned);
            final long _tmpCalculationDate;
            _tmpCalculationDate = _cursor.getLong(_cursorIndexOfCalculationDate);
            _result = new DepositCalculation(_tmpId,_tmpInitialAmount,_tmpPeriodMonths,_tmpInterestRate,_tmpMonthlyTopUp,_tmpFinalAmount,_tmpInterestEarned,_tmpCalculationDate);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
