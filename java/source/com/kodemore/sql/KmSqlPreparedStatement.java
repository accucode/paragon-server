/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I provide a simple wrapper for prepared statements.
 */
public class KmSqlPreparedStatement
    extends KmSqlStatement
{
    //##################################################
    //# variables
    //##################################################

    private int            _columnIndex;
    private String         _sql;
    private KmList<Object> _values;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlPreparedStatement(KmSqlConnection con, PreparedStatement ps, String sql)
    {
        super(con.getAdaptor());
        setStatement(new KmSqlStatementWrapper(con, ps));
        _sql = sql;
        _values = new KmList<Object>();
        _columnIndex = 1;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getSql()
    {
        return _sql;
    }

    public List<Object> getValues()
    {
        return _values;
    }

    //##################################################
    //# accessing
    //##################################################

    public void setValue(int column, String value)
    {
        try
        {
            KmSqlBuffer f = newBuffer();
            f.printValue(value);
            String s = f.toString();

            _setDebugValue(column, s);
            _getPreparedStatement().setString(column, value);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setValue(String value)
    {
        setValue(_columnIndex++, value);
    }

    public void setValue(int column, long value)
    {
        try
        {
            KmSqlBuffer f = newBuffer();
            f.printValue(value);
            String s = f.toString();

            _setDebugValue(column, s);
            _getPreparedStatement().setLong(column, value);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setValue(long value)
    {
        setValue(_columnIndex++, value);
    }

    public void setValue(int column, int value)
    {
        try
        {
            KmSqlBuffer f = newBuffer();
            f.printValue(value);
            String s = f.toString();

            _setDebugValue(column, s);
            _getPreparedStatement().setInt(column, value);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setValue(int value)
    {
        setValue(_columnIndex++, value);
    }

    public void setIdValue(int column, int value)
    {
        if ( value == -1 )
            setNullInteger(column);
        else
            setValue(column, value);
    }

    public void setValue(int column, double value)
    {
        try
        {
            KmSqlBuffer f = newBuffer();
            f.printValue(value);
            String s = f.toString();

            _setDebugValue(column, s);
            _getPreparedStatement().setDouble(column, value);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setValue(double value)
    {
        setValue(_columnIndex++, value);
    }

    public void setValue(int column, short value)
    {
        try
        {
            KmSqlBuffer f = newBuffer();
            f.printValue(value);
            String s = f.toString();

            _setDebugValue(column, s);
            _getPreparedStatement().setShort(column, value);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setValue(short value)
    {
        setValue(_columnIndex++, value);
    }

    public void setValue(int column, byte value)
    {
        try
        {
            KmSqlBuffer f = newBuffer();
            f.printValue(value);
            String s = f.toString();

            _setDebugValue(column, s);
            _getPreparedStatement().setByte(column, value);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setValue(byte value)
    {
        setValue(_columnIndex++, value);
    }

    public void setValue(int column, boolean value)
    {
        String s = value
            ? "Y"
            : "N";
        setValue(column, s);
    }

    public void setValue(boolean value)
    {
        setValue(_columnIndex++, value);
    }

    //##################################################
    //# null values
    //##################################################

    public void setNullInteger(int column)
    {
        try
        {
            _setDebugValue(column, "NULL");
            _getPreparedStatement().setNull(column, Types.INTEGER);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setNullDouble(int column)
    {
        try
        {
            _setDebugValue(column, "NULL");
            _getPreparedStatement().setNull(column, Types.DOUBLE);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# execute
    //##################################################

    public KmSqlResultSet executeQuery(KmSqlConnection con)
    {
        return _executeQuery(con);
    }

    public int executeUpdate(KmSqlConnection con)
    {
        return _executeUpdate(con);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getSqlString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Kmu.getSimpleClassName(this));
        sb.append(": ");
        sb.append(getSql());
        Iterator<Object> i = getValues().iterator();
        sb.append("; ");
        while ( i.hasNext() )
        {
            String s;
            s = (String)i.next();
            sb.append(s);
            if ( i.hasNext() )
                sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public String toString()
    {
        return getSqlString();
    }

    //##################################################
    //# utility
    //##################################################

    public PreparedStatement _getPreparedStatement()
    {
        return (PreparedStatement)getStatement()._getStatement();
    }

    public void resetColumnIndex()
    {
        _columnIndex = 1;
    }

    public void resetColumnIndex(int index)
    {
        _columnIndex = index;
    }

    //##################################################
    //# private
    //##################################################

    public void _setDebugValue(int column, String literal)
    {
        _ensureColumnIndex(column);
        _values.set(column - 1, literal);
    }

    public void _ensureColumnIndex(int column)
    {
        int i = column - 1;
        while ( _values.size() <= i )
            _values.add(null);
    }

}
