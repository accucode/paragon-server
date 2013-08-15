/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.sql.adaptor;

import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.KmSqlInsert;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.sql.KmSqlSelect;
import com.kodemore.sql.KmSqlUpdate;

/**
 * I am responsible for custom adaptation between the database
 * and various types of 'primitive' models.  E.g.: how to store
 * and retrieve KmMoney, or KmTimestamp.
 */
public abstract class KmSqlValueAdaptor<T>
{
    /**
     * Return the number of database columns that are used for
     * this model.  Typically 1, but some models like Money, may
     * use multiple columns, e.g.: one for the value and a second
     * for the currency.
     */
    public int getColumnCount()
    {
        return 1;
    }

    /**
     * Add the appropriate column(s) to the select statement.
     */
    public void select(KmSqlSelect st, String table, String column)
    {
        st.getColumnBuffer().printColumn(table, column);
    }

    /**
     * Fetch the value from the result set.  In some cases this
     * may require fetch data from more than one column.
     */
    public abstract T getValue(KmSqlResultSet rs, int column, T def);

    /**
     * Add the appropriate clause to update this value.
     */
    public void update(KmSqlUpdate u, String column, T value)
    {
        if ( value == null )
        {
            u.setNullValue(column);
            return;
        }

        KmSqlBuffer out = u._getValueBuffer();
        out.startColumn();
        out.printColumn(column);
        out.printEqual();
        out.printAnyValue(value);
    }

    public abstract void printOn(KmSqlBuffer out, T value);

    public void addColumnTo(KmSqlInsert st, String column)
    {
        st._addColumn(column);
    }

    public void addValueTo(KmSqlInsert st, T value)
    {
        st._nextValue();
        if ( value == null )
            st._getValueBuffer().printNull();
        else
            st._getValueBuffer().printAnyValue(value);
    }
}
