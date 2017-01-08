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

package com.kodemore.sql.adaptor.basic;

import com.kodemore.collection.KmBlob;
import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.sql.adaptor.KmSqlValueAdaptor;
import com.kodemore.utility.Kmu;

/**
 * Yes, this is a clumsy and inefficient implementation.
 * We should be able to generally just pass byte arrays back
 * and forth through the JDBC protocol.  However, sending
 * large blocks of random data occasionally turns up with
 * errors (the values sent to the db don't match the values
 * subsequently retrieved).  We suspect this is a problem
 * with the JDBC driver, or that there is some escape sequency
 * that we need to use.
 *
 * An example value that does not work correctly is:
 *      a{b}c"
 * The value actually stores fine but when it is read back the
 * resultSet converts the trailing quote to a tick:
 *      a{b}c'
 */
public class KmSqlBasicByteArrayAdaptor
    extends KmSqlValueAdaptor<KmBlob>
{
    @Override
    public KmBlob getValue(KmSqlResultSet rs, int column, KmBlob def)
    {
        String s = rs._getString(column);
        if ( rs.wasNull() )
            return def;

        byte[] bytes = Kmu.parseHexBytes(s);
        return new KmBlob(bytes);
    }

    @Override
    public void printOn(KmSqlBuffer out, KmBlob value)
    {
        String s = Kmu.formatHexString(value.getValue());
        out.printTick();
        out.printLiteral(s);
        out.printTick();
    }

}
