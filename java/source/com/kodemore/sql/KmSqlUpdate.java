/*
  Copyright (c) 2005-2014 www.kodemore.com

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
import com.kodemore.utility.Kmu;

/**
 * I provide convenience methods for composing an UPDATE statement.
 * By default, the expected count is ignored.  If the number of rows
 * to be updated is known (or a min or max count) then the expected
 * count should be set accordingly.
 */
public class KmSqlUpdate
    extends KmSqlConditionalStatement
    implements KmSqlUpdateIF
{
    //##################################################
    //# variables
    //##################################################

    private String      _table;
    private KmSqlBuffer _values;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlUpdate(KmSqlAdaptor a)
    {
        super(a);
        _table = null;
        _values = newBuffer();
    }

    //##################################################
    //# execute
    //##################################################

    @Override
    public int execute(KmSqlConnection con)
    {
        return _executeUpdate(con);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getTable()
    {
        return _table;
    }

    public void setTable(String table)
    {
        _table = table;
    }

    public boolean hasTable()
    {
        return Kmu.hasValue(getTable());
    }

    //##################################################
    //# validate
    //##################################################

    public void validate()
    {
        if ( !hasTable() )
            throw Kmu.newFatal("Must specify a table to update.");

        if ( _values.isEmpty() )
            throw Kmu.newFatal("Must specify the values to update.");
    }

    //##################################################
    //# printing
    //##################################################

    @Override
    public String getSqlString()
    {
        KmSqlBuffer out;
        out = newBuffer();
        out.printLiteral("UPDATE ");
        out.printLiteral(_table);
        out.printLiteral(" SET ");
        out.printBuffer(_values);

        printWhereConditionsOn(out);

        return out.toString();
    }

    //##################################################
    //# values
    //##################################################

    public void setValue(String column, String value)
    {
        if ( value == null )
        {
            setNullValue(column);
            return;
        }
        _values.startColumn();
        _values.printColumn(column);
        _values.printEqual();
        _values.printValue(value);
    }

    public void setValue(String column, KmDate value)
    {
        getAdaptor().getDateAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmTime value)
    {
        getAdaptor().getTimeAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmTimestamp value)
    {
        getAdaptor().getTimestampAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmMoney value)
    {
        getAdaptor().getMoneyAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmKilogram value)
    {
        getAdaptor().getKilogramAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmQuantity value)
    {
        getAdaptor().getQuantityAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmRate value)
    {
        getAdaptor().getRateAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmCost value)
    {
        getAdaptor().getCostAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmWeight value)
    {
        getAdaptor().getWeightAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmDayFrequency value)
    {
        getAdaptor().getDayFrequencyAdaptor().update(this, column, value);
    }

    public void setValue(String column, KmBlob value)
    {
        getAdaptor().getByteArrayAdaptor().update(this, column, value);
    }

    public void setValue(String column, Boolean value)
    {
        getAdaptor().getBooleanAdaptor().update(this, column, value);
    }

    public void setValue(String column, boolean value)
    {
        getAdaptor().getBooleanAdaptor().update(this, column, value);
    }

    public void setValue(String column, Integer value)
    {
        getAdaptor().getIntegerAdaptor().update(this, column, value);
    }

    public void setValue(String column, double value)
    {
        getAdaptor().getDoubleAdaptor().update(this, column, value);
    }

    public void setValue(String column, Double value)
    {
        getAdaptor().getDoubleAdaptor().update(this, column, value);
    }

    public void setValue(String column, long value)
    {
        getAdaptor().getLongAdaptor().update(this, column, value);
    }

    //##################################################
    //# convenience
    //##################################################

    public void setTrue(String column)
    {
        setValue(column, true);
    }

    public void setFalse(String column)
    {
        setValue(column, false);
    }

    public void setNullValue(String column)
    {
        _values.startColumn();
        _values.printColumn(column);
        _values.printEqual();
        _values.printNull();
    }

    //##################################################
    //# literals
    //##################################################

    public void setLiteral(String column, String value)
    {
        _values.printColumn(column);
        _values.printEqual();
        _values.printLiteral(value);
    }

    public void setLiteral(String s)
    {
        _values.startColumn();
        _values.printLiteral(s);
    }

    //##################################################
    //# private
    //##################################################

    public KmSqlBuffer _getValueBuffer()
    {
        return _values;
    }

}
