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

package com.kodemore.sql.adaptor.ms;

import java.sql.Timestamp;

import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.sql.adaptor.basic.KmSqlBasicTimestampAdaptor;
import com.kodemore.time.KmTimestamp;

public class KmSqlMsTimestampAdaptor
    extends KmSqlBasicTimestampAdaptor
{
    @Override
    public KmTimestamp getValue(KmSqlResultSet rs, int column, KmTimestamp def)
    {
        Timestamp jt = rs._getTimestamp(column);
        if ( rs.wasNull() )
            return def;

        return KmTimestamp.fromJavaDate(jt);
    }

    @Override
    public void printOn(KmSqlBuffer out, KmTimestamp value)
    {
        out.pad4(value.getYear());
        out.printDash();
        out.pad2(value.getMonth());
        out.printDash();
        out.pad2(value.getDay());
        out.printSpace();
        out.pad2(value.getHour());
        out.printColon();
        out.pad2(value.getMinute());
        out.printColon();
        out.pad2(value.getSecond());
        out.printColon();
        out.pad3(value.getSecond());
    }

}
