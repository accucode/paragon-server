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
import com.kodemore.collection.KmList;
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
 * I provide convenience methods for composing an INSERT statement.
 */
public class KmSqlInsert
    extends KmSqlStatement
    implements KmSqlUpdateIF
{
    //##################################################
    //# variables
    //##################################################

    private String         _table;
    private KmList<String> _columns;
    private KmSqlBuffer    _valueBuffer;
    private int            _rowCount;
    private boolean        _isFirstColumn;
    private String         _onDuplicateKeyUpdate;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create a new sql insert statement.
     */
    public KmSqlInsert(KmSqlAdaptor a)
    {
        super(a);
        _table = null;
        _columns = new KmList<>();
        _valueBuffer = newBuffer();
        _rowCount = 0;
        _isFirstColumn = true;
    }

    //##################################################
    //# execute
    //##################################################

    @Override
    public int execute(KmSqlConnection con)
    {
        if ( _rowCount == 0 )
            return 0;
        validate();
        return _executeUpdate(con);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getTable()
    {
        return _table;
    }

    public void setTable(String s)
    {
        _table = s;
    }

    public boolean hasTable()
    {
        return Kmu.hasValue(getTable());
    }

    public String getColumns()
    {
        return _columns.toString();
    }

    public boolean hasColumns()
    {
        return _columns.isNotEmpty();
    }

    public void startNewRow()
    {
        if ( _rowCount > 0 )
        {
            _valueBuffer.printCloseParen();
            _valueBuffer.printListDelimiter();
            _valueBuffer.printNewLine();
            _valueBuffer.printOpenParen();
        }
        _rowCount++;
        _isFirstColumn = true;
    }

    public void onDuplicateKeyUpdate(String s)
    {
        _onDuplicateKeyUpdate = s;
    }

    public void onDuplicateKeyUpdateColumnNoChange(String column)
    {
        if ( column == null )
        {
            _onDuplicateKeyUpdate = null;
            return;
        }
        String s = column + "=" + column;
        onDuplicateKeyUpdate(s);
    }

    //##################################################
    //# printing
    //##################################################

    @Override
    public String getSqlString()
    {
        KmSqlBuffer f = newBuffer();
        f.printLiteral("INSERT");
        f.printLiteral(" INTO ");
        f.printLiteral(_table);
        f.printSpace();
        f.printOpenParen();
        f.printColumns(_columns);
        f.printCloseParen();
        f.printLiteral(" VALUES ");
        f.printOpenParen();
        f.printBuffer(_valueBuffer);
        f.printCloseParen();
        if ( _onDuplicateKeyUpdate != null )
        {
            f.printLiteral(" ON DUPLICATE KEY UPDATE ");
            f.printLiteral(_onDuplicateKeyUpdate);
        }
        return f.toString();
    }

    //##################################################
    //# validation
    //##################################################

    public void validate()
    {
        if ( !hasTable() )
            throw newFatal("Must specify a table to insert.");

        if ( !hasColumns() )
            throw newFatal("Must specify the columns to update.");
    }

    //##################################################
    //# string
    //##################################################

    public void setStringValue(String column, String e)
    {
        addStringColumn(column);
        addStringValue(e);
    }

    public void addStringColumn(String column)
    {
        getAdaptor().getStringAdaptor().addColumnTo(this, column);
    }

    public void addStringValue(String e)
    {
        getAdaptor().getStringAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# date
    //##################################################

    public void setDateValue(String column, KmDate e)
    {
        addDateColumn(column);
        addDateValue(e);
    }

    public void addDateColumn(String column)
    {
        getAdaptor().getDateAdaptor().addColumnTo(this, column);
    }

    public void addDateValue(KmDate e)
    {
        getAdaptor().getDateAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# time
    //##################################################

    public void setTimeValue(String column, KmTime e)
    {
        addTimeColumn(column);
        addTimeValue(e);
    }

    public void addTimeColumn(String column)
    {
        getAdaptor().getTimeAdaptor().addColumnTo(this, column);
    }

    public void addTimeValue(KmTime e)
    {
        getAdaptor().getTimeAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# timestamp
    //##################################################

    public void setTimestampValue(String column, KmTimestamp e)
    {
        addTimestampColumn(column);
        addTimestampValue(e);
    }

    public void addTimestampColumn(String column)
    {
        getAdaptor().getTimestampAdaptor().addColumnTo(this, column);
    }

    public void addTimestampValue(KmTimestamp e)
    {
        getAdaptor().getTimestampAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# money
    //##################################################

    public void setMoneyValue(String column, KmMoney e)
    {
        addMoneyColumn(column);
        addMoneyValue(e);
    }

    public void addMoneyColumn(String column)
    {
        getAdaptor().getMoneyAdaptor().addColumnTo(this, column);
    }

    public void addMoneyValue(KmMoney e)
    {
        getAdaptor().getMoneyAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# kilogram
    //##################################################

    public void setKilogramValue(String column, KmKilogram e)
    {
        addKilogramColumn(column);
        addKilogramValue(e);
    }

    public void addKilogramColumn(String column)
    {
        getAdaptor().getKilogramAdaptor().addColumnTo(this, column);
    }

    public void addKilogramValue(KmKilogram e)
    {
        getAdaptor().getKilogramAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# quantity
    //##################################################

    public void setQuantityValue(String column, KmQuantity e)
    {
        addQuantityColumn(column);
        addQuantityValue(e);
    }

    public void addQuantityColumn(String column)
    {
        getAdaptor().getQuantityAdaptor().addColumnTo(this, column);
    }

    public void addQuantityValue(KmQuantity e)
    {
        getAdaptor().getQuantityAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# weight
    //##################################################

    public void setWeightValue(String column, KmWeight e)
    {
        addWeightColumn(column);
        addWeightValue(e);
    }

    public void addWeightColumn(String column)
    {
        getAdaptor().getWeightAdaptor().addColumnTo(this, column);
    }

    public void addWeightValue(KmWeight e)
    {
        getAdaptor().getWeightAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# rate
    //##################################################

    public void setRateValue(String column, KmRate e)
    {
        addRateColumn(column);
        addRateValue(e);
    }

    public void addRateColumn(String column)
    {
        getAdaptor().getRateAdaptor().addColumnTo(this, column);
    }

    public void addRateValue(KmRate e)
    {
        getAdaptor().getRateAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# cost
    //##################################################

    public void setCostValue(String column, KmCost e)
    {
        addCostColumn(column);
        addCostValue(e);
    }

    public void addCostColumn(String column)
    {
        getAdaptor().getCostAdaptor().addColumnTo(this, column);
    }

    public void addCostValue(KmCost e)
    {
        getAdaptor().getCostAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# day frequency
    //##################################################

    public void setDayFrequencyValue(String column, KmDayFrequency e)
    {
        addDayFrequencyColumn(column);
        addDayFrequencyValue(e);
    }

    public void addDayFrequencyColumn(String column)
    {
        getAdaptor().getDayFrequencyAdaptor().addColumnTo(this, column);
    }

    public void addDayFrequencyValue(KmDayFrequency e)
    {
        getAdaptor().getDayFrequencyAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# boolean
    //##################################################

    public void setBooleanValue(String column, Boolean e)
    {
        addBooleanColumn(column);
        addBooleanValue(e);
    }

    public void addBooleanColumn(String column)
    {
        getAdaptor().getBooleanAdaptor().addColumnTo(this, column);
    }

    public void addBooleanValue(Boolean e)
    {
        getAdaptor().getBooleanAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# integer
    //##################################################

    public void setIntegerValue(String column, Integer e)
    {
        addIntegerColumn(column);
        addIntegerValue(e);
    }

    public void addIntegerColumn(String column)
    {
        getAdaptor().getIntegerAdaptor().addColumnTo(this, column);
    }

    public void addIntegerValue(Integer e)
    {
        getAdaptor().getIntegerAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# long
    //##################################################

    public void setLongValue(String column, Long e)
    {
        addLongColumn(column);
        addLongValue(e);
    }

    public void addLongColumn(String column)
    {
        getAdaptor().getLongAdaptor().addColumnTo(this, column);
    }

    public void addLongValue(Long e)
    {
        getAdaptor().getLongAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# double
    //##################################################

    public void setDoubleValue(String column, Double e)
    {
        addDoubleColumn(column);
        addDoubleValue(e);
    }

    public void addDoubleColumn(String column)
    {
        getAdaptor().getDoubleAdaptor().addColumnTo(this, column);
    }

    public void addDoubleValue(Double e)
    {
        getAdaptor().getDoubleAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# byte array
    //##################################################

    public void setByteArrayValue(String column, KmBlob e)
    {
        addByteArrayColumn(column);
        addByteArrayValue(e);
    }

    public void addByteArrayColumn(String column)
    {
        getAdaptor().getByteArrayAdaptor().addColumnTo(this, column);
    }

    public void addByteArrayValue(KmBlob e)
    {
        getAdaptor().getByteArrayAdaptor().addValueTo(this, e);
    }

    //##################################################
    //# protected (for use by other library classes)
    //##################################################

    public KmSqlBuffer _getValueBuffer()
    {
        return _valueBuffer;
    }

    public void _nextValue()
    {
        if ( _rowCount == 0 )
            startNewRow();

        if ( _isFirstColumn )
            _isFirstColumn = false;
        else
            _valueBuffer.printListDelimiter();
    }

    public void _addColumn(String name)
    {
        _columns.add(name);
    }

}
