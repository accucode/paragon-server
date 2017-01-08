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

package com.kodemore.sql.adaptor.mySql;

import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.adaptor.KmSqlValueAdaptor;
import com.kodemore.sql.adaptor.basic.KmSqlBasicAdaptor;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;

/**
 * I am responsible for custom adaptation between the database
 * and various types of 'primitive' models.  E.g.: how to store
 * and retrieve KmMoney, or KmTimestamp.
 */
public class KmSqlMySqlAdaptor
    extends KmSqlBasicAdaptor
{
    //##################################################
    //# buffer
    //##################################################

    @Override
    public String getLastIdSqlString()
    {
        return "SELECT LAST_INSERT_ID()";
    }

    //##################################################
    //# value adaptors
    //##################################################

    @Override
    public KmSqlValueAdaptor<KmDate> newDateAdaptor()
    {
        return new KmSqlMySqlDateAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmTime> newTimeAdaptor()
    {
        return new KmSqlMySqlTimeAdaptor();
    }

    @Override
    public KmSqlValueAdaptor<KmTimestamp> newTimestampAdaptor()
    {
        return new KmSqlMySqlTimestampAdaptor();
    }

    //##################################################
    //# escape
    //##################################################

    @Override
    protected void escape(KmSqlBuffer out, byte b)
    {
        if ( requiresEscape(b) )
            out.printLiteral(CHAR_BACKSLASH);

        if ( b >= 0 )
            out.printLiteral((char)b);
        else
            out.printLiteral((char)(256 + b));
    }

    private boolean requiresEscape(byte b)
    {
        return b == CHAR_NULL || b == CHAR_BACKSLASH || b == CHAR_TICK || b == CHAR_QUOTE;
        // || b == CHAR_OPEN_BRACE || b == CHAR_CLOSE_BRACE
    }
}
