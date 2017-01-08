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

package com.kodemore.sql.adaptor.db2;

import com.kodemore.sql.KmSqlBuffer;
import com.kodemore.sql.adaptor.basic.KmSqlBasicTimestampAdaptor;
import com.kodemore.time.KmTimestamp;

public class KmSqlDb2TimestampAdaptor
    extends KmSqlBasicTimestampAdaptor
{
    @Override
    public void printOn(KmSqlBuffer out, KmTimestamp value)
    {
        out.printTick();
        out.pad4(value.getYear());
        out.printDash();
        out.pad2(value.getMonth());
        out.printDash();
        out.pad2(value.getDay());
        out.printDash();
        out.pad2(value.getHour());
        out.printDot();
        out.pad2(value.getMinute());
        out.printDot();
        out.pad2(value.getSecond());
        out.printTick();
    }

}
