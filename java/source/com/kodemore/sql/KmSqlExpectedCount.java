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

/**
 * This is used to compare the expected update count to the actual
 * update count and to throw an exception when they don't match,
 * causing the transaction to abort the current unit of work.
 */
public class KmSqlExpectedCount
    implements KmSqlConstantsIF
{
    //##################################################
    //# static
    //##################################################

    public static final int MODE_IGNORE  = 0;
    public static final int MODE_EQUAL   = 1;
    public static final int MODE_MINIMUM = 2;
    public static final int MODE_MAXIMUM = 3;

    //##################################################
    //# variables
    //##################################################

    private int             _mode;
    private int             _expected;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlExpectedCount()
    {
        _mode = MODE_IGNORE;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void ignore()
    {
        _mode = MODE_IGNORE;
    }

    public void setCount(int i)
    {
        _mode = MODE_EQUAL;
        _expected = i;
    }

    public void setMaximum(int i)
    {
        _mode = MODE_MAXIMUM;
        _expected = i;
    }

    public void setMinimum(int i)
    {
        _mode = MODE_MINIMUM;
        _expected = i;
    }

    /**
     * Check the actual count against the expected count.  If it does
     * not match, throw an exception.
     */
    public void check(int count)
    {
        if ( isOk(count) )
            return;
        StringBuilder sb = new StringBuilder();
        sb.append("Expected update count ");
        if ( _mode == MODE_EQUAL )
            sb.append("= ");
        if ( _mode == MODE_MINIMUM )
            sb.append(">= ");
        if ( _mode == MODE_MAXIMUM )
            sb.append("<= ");
        sb.append(_expected);
        sb.append(", actual count = ");
        sb.append(count);
        sb.append(".");
        throw new RuntimeException(sb.toString());
    }

    /**
     * Determine if the count matches the expected value.
     */
    public boolean isOk(int count)
    {
        switch ( _mode )
        {
            case MODE_EQUAL:
                return count == _expected;
            case MODE_MINIMUM:
                return count >= _expected;
            case MODE_MAXIMUM:
                return count <= _expected;
        }
        return true;
    }

}
