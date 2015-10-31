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

package com.kodemore.sql.adaptor.mySql;

import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.sql.KmSqlSelect;
import com.kodemore.sql.adaptor.KmSqlValueAdaptor;
import com.kodemore.time.KmTime;

public class KmSqlMySqlTimeAdaptor
    extends KmSqlValueAdaptor<KmTime>
{
    @Override
    public void select(KmSqlSelect st, String table, String column)
    {
        st.getColumnBuffer().printLiteral("time_to_sec");
        st.getColumnBuffer().printColumnIn(table, column, null);
    }

    @Override
    public KmTime getValue(KmSqlResultSet rs, int column, KmTime def)
    {
        int i = rs._getInt(column);
        if ( rs.wasNull() )
            return def;

        return KmTime.fromMySqlOrdinal(i);
    }

    @Override
    public void printOn(KmSqlBuffer out, KmTime value)
    {
        out.printLiteral("sec_to_time");
        out.printOpenParen();
        out.printValue(value.toMySqlOrdinal());
        out.printCloseParen();
    }

}
