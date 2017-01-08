/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.sql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.kodemore.collection.KmBlob;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmCost;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.types.KmKilogram;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.types.KmRate;
import com.kodemore.types.KmWeight;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * I provide a basic wrapper for the java.sql.ResultSet.
 */
public class KmSqlResultSet
    implements KmConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private ResultSet    _resultSet;
    private KmSqlAdaptor _adaptor;
    private int          _column;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlResultSet(KmSqlAdaptor a, ResultSet rs)
    {
        _resultSet = rs;
        _adaptor = a;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean next()
    {
        try
        {
            _column = 1;
            return _resultSet.next();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public boolean wasNull()
    {
        try
        {
            return _resultSet.wasNull();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public ResultSetMetaData getMetaData()
    {
        try
        {
            return _resultSet.getMetaData();
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# integer
    //##################################################

    public Integer getInteger()
    {
        return getIntegerAt(_column++);
    }

    public Integer getInteger(Integer def)
    {
        return getIntegerAt(_column++, def);
    }

    public Integer getIntegerAt(int column)
    {
        return getIntegerAt(column, null);
    }

    public Integer getIntegerAt(int column, Integer def)
    {
        return _adaptor.getIntegerAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# integer (primitive)
    //##################################################

    public int get_int()
    {
        return get_intAt(_column++);
    }

    public int get_int(int def)
    {
        return get_intAt(_column++, def);
    }

    public int get_intAt(int column)
    {
        return get_intAt(column, UNDEFINED_INT);
    }

    public int get_intAt(int column, int def)
    {
        return getIntegerAt(column, def);
    }

    //##################################################
    //# long
    //##################################################

    public Long getLong()
    {
        return getLongAt(_column++);
    }

    public Long getLong(Long def)
    {
        return getLongAt(_column++, def);
    }

    public Long getLongAt(int column)
    {
        return getLongAt(column, null);
    }

    public Long getLongAt(int column, Long def)
    {
        return _adaptor.getLongAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# long (primitive)
    //##################################################

    public long get_long()
    {
        return get_longAt(_column++);
    }

    public long get_long(long def)
    {
        return get_longAt(_column++, def);
    }

    public long get_longAt(int column)
    {
        return get_longAt(column, UNDEFINED_LONG);
    }

    public long get_longAt(int column, long def)
    {
        return getLongAt(column, def);
    }

    //##################################################
    //# double
    //##################################################

    public Double getDouble()
    {
        return getDoubleAt(_column++);
    }

    public Double getDouble(Double def)
    {
        return getDoubleAt(_column++, def);
    }

    public Double getDoubleAt(int column)
    {
        return getDoubleAt(column, null);
    }

    public Double getDoubleAt(int column, Double def)
    {
        return _adaptor.getDoubleAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# double (primitive)
    //##################################################

    public double get_double()
    {
        return get_doubleAt(_column++);
    }

    public double get_double(double def)
    {
        return get_doubleAt(_column++, def);
    }

    public double get_doubleAt(int column)
    {
        return get_doubleAt(column, Double.NaN);
    }

    public double get_doubleAt(int column, double def)
    {
        return getDoubleAt(column, def);
    }

    //##################################################
    //# boolean
    //##################################################

    public Boolean getBoolean()
    {
        return getBooleanAt(_column++);
    }

    public Boolean getBoolean(Boolean def)
    {
        return getBooleanAt(_column++, def);
    }

    public Boolean getBooleanAt(int column)
    {
        return getBooleanAt(column, null);
    }

    public Boolean getBooleanAt(int column, Boolean def)
    {
        return _adaptor.getBooleanAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# boolean (primitive)
    //##################################################

    public boolean get_boolean()
    {
        return get_booleanAt(_column++);
    }

    public boolean get_boolean(boolean def)
    {
        return get_booleanAt(_column++, def);
    }

    public boolean get_booleanAt(int column)
    {
        return get_booleanAt(column, false);
    }

    public boolean get_booleanAt(int column, boolean def)
    {
        return getBooleanAt(column, def);
    }

    //##################################################
    //# string
    //##################################################

    public String getString()
    {
        return getStringAt(_column++);
    }

    public String getString(String def)
    {
        return getStringAt(_column++, def);
    }

    public String getStringAt(int column)
    {
        return getStringAt(column, null);
    }

    public String getStringAt(int column, String def)
    {
        return _adaptor.getStringAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# date
    //##################################################

    public KmDate getDate()
    {
        return getDate(null);
    }

    public KmDate getDate(KmDate def)
    {
        KmDate e = getDateAt(_column, def);
        _column += _adaptor.getDateAdaptor().getColumnCount();
        return e;
    }

    public KmDate getDateAt(int column)
    {
        return getDateAt(column, null);
    }

    public KmDate getDateAt(int column, KmDate def)
    {
        return _adaptor.getDateAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# time
    //##################################################

    public KmTime getTime()
    {
        return getTimeAt(_column++);
    }

    public KmTime getTime(KmTime def)
    {
        return getTimeAt(_column++, def);
    }

    public KmTime getTimeAt(int column)
    {
        return getTimeAt(column, null);
    }

    public KmTime getTimeAt(int column, KmTime def)
    {
        return _adaptor.getTimeAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# timestamp
    //##################################################

    public KmTimestamp getTimestamp()
    {
        return getTimestampAt(_column++);
    }

    public KmTimestamp getTimestamp(KmTimestamp def)
    {
        return getTimestampAt(_column++, def);
    }

    public KmTimestamp getTimestampAt(int column)
    {
        return getTimestampAt(column, null);
    }

    public KmTimestamp getTimestampAt(int column, KmTimestamp def)
    {
        return _adaptor.getTimestampAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# money
    //##################################################

    public KmMoney getMoney()
    {
        KmMoney e = getMoneyAt(_column);
        _column += 2;
        return e;
    }

    public KmMoney getMoney(KmMoney def)
    {
        KmMoney e = getMoneyAt(_column, def);
        _column += 2;
        return e;
    }

    public KmMoney getMoneyAt(int column)
    {
        return getMoneyAt(column, null);
    }

    public KmMoney getMoneyAt(int column, KmMoney def)
    {
        return _adaptor.getMoneyAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# kilogram
    //##################################################

    public KmKilogram getKilogram()
    {
        return getKilogramAt(_column++);
    }

    public KmKilogram getKilogram(KmKilogram def)
    {
        return getKilogramAt(_column++, def);
    }

    public KmKilogram getKilogramAt(int column)
    {
        return getKilogramAt(column, null);
    }

    public KmKilogram getKilogramAt(int column, KmKilogram def)
    {
        return _adaptor.getKilogramAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# quantity
    //##################################################

    public KmQuantity getQuantity()
    {
        return getQuantityAt(_column++);
    }

    public KmQuantity getQuantity(KmQuantity def)
    {
        return getQuantityAt(_column++, def);
    }

    public KmQuantity getQuantityAt(int column)
    {
        return getQuantityAt(column, null);
    }

    public KmQuantity getQuantityAt(int column, KmQuantity def)
    {
        return _adaptor.getQuantityAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# weight
    //##################################################

    public KmWeight getWeight()
    {
        return getWeightAt(_column++);
    }

    public KmWeight getWeight(KmWeight def)
    {
        return getWeightAt(_column++, def);
    }

    public KmWeight getWeightAt(int column)
    {
        return getWeightAt(column, null);
    }

    public KmWeight getWeightAt(int column, KmWeight def)
    {
        return _adaptor.getWeightAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# rate
    //##################################################

    public KmRate getRate()
    {
        return getRateAt(_column++);
    }

    public KmRate getRate(KmRate def)
    {
        return getRateAt(_column++, def);
    }

    public KmRate getRateAt(int column)
    {
        return getRateAt(column, null);
    }

    public KmRate getRateAt(int column, KmRate def)
    {
        return _adaptor.getRateAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# cost
    //##################################################

    public KmCost getCost()
    {
        return getCostAt(_column++);
    }

    public KmCost getCost(KmCost def)
    {
        return getCostAt(_column++, def);
    }

    public KmCost getCostAt(int column)
    {
        return getCostAt(column, null);
    }

    public KmCost getCostAt(int column, KmCost def)
    {
        return _adaptor.getCostAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# day frequency
    //##################################################

    public KmDayFrequency getDayFrequency()
    {
        return getDayFrequencyAt(_column++);
    }

    public KmDayFrequency getDayFrequency(KmDayFrequency def)
    {
        return getDayFrequencyAt(_column++, def);
    }

    public KmDayFrequency getDayFrequencyAt(int column)
    {
        return getDayFrequencyAt(column, null);
    }

    public KmDayFrequency getDayFrequencyAt(int column, KmDayFrequency def)
    {
        return _adaptor.getDayFrequencyAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# bytes array
    //##################################################

    public KmBlob getByteArray()
    {
        return getByteArrayAt(_column++);
    }

    public KmBlob getByteArray(KmBlob def)
    {
        return getByteArrayAt(_column++, def);
    }

    public KmBlob getByteArrayAt(int column)
    {
        return getByteArrayAt(column, null);
    }

    public KmBlob getByteArrayAt(int column, KmBlob def)
    {
        return _adaptor.getByteArrayAdaptor().getValue(this, column, def);
    }

    //##################################################
    //# protected (for use by other library classes)
    //##################################################

    public int _getInt(int column)
    {
        try
        {
            return _resultSet.getInt(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public long _getLong(int column)
    {
        try
        {
            return _resultSet.getLong(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public double _getDouble(int column)
    {
        try
        {
            return _resultSet.getDouble(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public String _getString(int column)
    {
        try
        {
            return _resultSet.getString(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public Date _getDate(int column)
    {
        try
        {
            return _resultSet.getDate(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public Timestamp _getTimestamp(int column)
    {
        try
        {
            return _resultSet.getTimestamp(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public Object _getObjectAt(int column)
    {
        try
        {
            return _resultSet.getObject(column);
        }
        catch ( SQLException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
