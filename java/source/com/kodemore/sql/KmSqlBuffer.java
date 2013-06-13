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

import com.kodemore.collection.KmBlob;
import com.kodemore.collection.KmList;
import com.kodemore.collection.KmSetImpl;
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

public class KmSqlBuffer
    implements KmSqlConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmSqlAdaptor  _adaptor;
    private StringBuilder _buffer;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlBuffer(KmSqlAdaptor a)
    {
        _adaptor = a;
        _buffer = new StringBuilder();
    }

    //##################################################
    //# misc
    //##################################################

    public void escape(String s)
    {
        _adaptor.escape(this, s);
    }

    public void clear()
    {
        _buffer.setLength(0);
    }

    //##################################################
    //# print value
    //##################################################

    public void printValue(String e)
    {
        _adaptor.getStringAdaptor().printOn(this, e);
    }

    public void printValue(boolean e)
    {
        _adaptor.getBooleanAdaptor().printOn(this, e);
    }

    public void printValue(int e)
    {
        _adaptor.getIntegerAdaptor().printOn(this, e);
    }

    public void printValue(long e)
    {
        _adaptor.getLongAdaptor().printOn(this, e);
    }

    public void printValue(double e)
    {
        _adaptor.getDoubleAdaptor().printOn(this, e);
    }

    public void printValue(KmDate e)
    {
        _adaptor.getDateAdaptor().printOn(this, e);
    }

    public void printValue(KmTime e)
    {
        _adaptor.getTimeAdaptor().printOn(this, e);
    }

    public void printValue(KmTimestamp e)
    {
        _adaptor.getTimestampAdaptor().printOn(this, e);
    }

    public void printValue(KmKilogram e)
    {
        _adaptor.getKilogramAdaptor().printOn(this, e);
    }

    public void printValue(KmQuantity e)
    {
        _adaptor.getQuantityAdaptor().printOn(this, e);
    }

    public void printValue(KmRate e)
    {
        _adaptor.getRateAdaptor().printOn(this, e);
    }

    public void printValue(KmCost e)
    {
        _adaptor.getCostAdaptor().printOn(this, e);
    }

    public void printValue(KmMoney e)
    {
        _adaptor.getMoneyAdaptor().printOn(this, e);
    }

    public void printValue(KmWeight e)
    {
        _adaptor.getWeightAdaptor().printOn(this, e);
    }

    public void printValue(KmDayFrequency e)
    {
        _adaptor.getDayFrequencyAdaptor().printOn(this, e);
    }

    public void printValue(KmBlob e)
    {
        _adaptor.getByteArrayAdaptor().printOn(this, e);
    }

    public void printAnyValue(Object e)
    {
        if ( e instanceof String )
        {
            printValue((String)e);
            return;
        }
        if ( e instanceof Boolean )
        {
            printValue(((Boolean)e).booleanValue());
            return;
        }
        if ( e instanceof Integer )
        {
            printValue(((Integer)e).intValue());
            return;
        }
        if ( e instanceof Long )
        {
            printValue(((Long)e).longValue());
            return;
        }
        if ( e instanceof Double )
        {
            printValue(((Double)e).doubleValue());
            return;
        }
        if ( e instanceof KmDate )
        {
            printValue((KmDate)e);
            return;
        }
        if ( e instanceof KmTime )
        {
            printValue((KmTime)e);
            return;
        }
        if ( e instanceof KmTimestamp )
        {
            printValue((KmTimestamp)e);
            return;
        }
        if ( e instanceof KmKilogram )
        {
            printValue((KmKilogram)e);
            return;
        }
        if ( e instanceof KmQuantity )
        {
            printValue((KmQuantity)e);
            return;
        }
        if ( e instanceof KmWeight )
        {
            printValue((KmWeight)e);
            return;
        }
        if ( e instanceof KmDayFrequency )
        {
            printValue((KmDayFrequency)e);
            return;
        }
        if ( e instanceof KmBlob )
        {
            printValue((KmBlob)e);
            return;
        }
        if ( e instanceof KmMoney )
        {
            printValue((KmMoney)e);
            return;
        }
        if ( e instanceof KmRate )
        {
            printValue((KmRate)e);
            return;
        }
        if ( e instanceof KmCost )
        {
            printValue((KmCost)e);
            return;
        }

        error("Unknown type: (%s)", e.getClass().getName());
    }

    //##################################################
    //# print literal
    //##################################################

    public void printLiteral(char c)
    {
        _buffer.append(c);
    }

    public void printLiteral(String s)
    {
        _buffer.append(s);
    }

    //##################################################
    //# print column
    //##################################################

    public void printColumn(String column)
    {
        printLiteral(column);
    }

    public void printColumn(String prefix, String column)
    {
        if ( Kmu.hasValue(prefix) )
        {
            printLiteral(prefix);
            printDot();
        }
        printLiteral(column);
    }

    public void printColumn(String table, String column, String alias)
    {
        if ( Kmu.hasValue(table) )
        {
            printLiteral(table);
            printDot();
        }
        printLiteral(column);
        if ( Kmu.hasValue(alias) )
        {
            printLiteral(" as ");
            printLiteral(alias);
        }
    }

    public void printColumnIn(String table, String column, String alias)
    {
        printOpenParen();
        printColumn(table, column, alias);
        printCloseParen();
    }

    //##################################################
    //# print misc
    //##################################################

    public void printNull()
    {
        _buffer.append("null");
    }

    public void printBuffer(KmSqlBuffer f)
    {
        _buffer.append(f._buffer);
    }

    /**
     * This is used when printing in the context of a list of columns,
     * and the client wants to start a new column.  If the buffer is
     * empty, then do nothing.  Otherwise, print the column delimiter.
     */
    public void startColumn()
    {
        if ( isNotEmpty() )
            printListDelimiter();
    }

    public void printStatement(KmSqlStatement st)
    {
        _buffer.append(st.getSqlString());
    }

    public void printStatementIn(KmSqlStatement st)
    {
        printOpenParen();
        printStatement(st);
        printCloseParen();
    }

    public void printCondition(KmSqlCondition st)
    {
        _buffer.append(st.toString());
    }

    public void printConditionIn(KmSqlCondition st)
    {
        printOpenParen();
        printCondition(st);
        printCloseParen();
    }

    public void printSpace()
    {
        _buffer.append(CHAR_SPACE);
    }

    public void printDot()
    {
        _buffer.append(CHAR_DOT);
    }

    public void printTick()
    {
        _buffer.append(CHAR_TICK);
    }

    public void printDash()
    {
        _buffer.append(CHAR_DASH);
    }

    public void printOpenParen()
    {
        _buffer.append(CHAR_OPEN_PAREN);
    }

    public void printCloseParen()
    {
        _buffer.append(CHAR_CLOSE_PAREN);
    }

    public void printColon()
    {
        _buffer.append(CHAR_COLON);
    }

    public void printComma()
    {
        _buffer.append(CHAR_COMMA);
    }

    public void printListDelimiter()
    {
        _buffer.append(STRING_LIST_DELIMITER);
    }

    public void printOr()
    {
        _buffer.append(STRING_OR);
    }

    public void printAnd()
    {
        _buffer.append(STRING_AND);
    }

    public void printEqual()
    {
        _buffer.append(STRING_EQUAL);
    }

    public void printNewLine()
    {
        _buffer.append(STRING_NEW_LINE);
    }

    public void printHexString(byte[] bytes)
    {
        _buffer.append(Kmu.formatHexString(bytes));
    }

    public void printColumns(KmList<String> v)
    {
        if ( v.isEmpty() )
            return;
        for ( String e : v )
        {
            printLiteral(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printColumnsIn(KmList<String> v)
    {
        printOpenParen();
        printColumns(v);
        printCloseParen();
    }

    public void printIntegers(int arr[])
    {
        int n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printIntegersIn(int[] arr)
    {
        printOpenParen();
        printIntegers(arr);
        printCloseParen();
    }

    public void printLongs(long arr[])
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printLongsIn(long[] arr)
    {
        printOpenParen();
        printLongs(arr);
        printCloseParen();
    }

    public void printDoubles(double arr[])
    {
        double n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDoublesIn(double[] arr)
    {
        printOpenParen();
        printDoubles(arr);
        printCloseParen();
    }

    public void printStrings(String[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printStrings(KmList<String> v)
    {
        if ( v.isEmpty() )
            return;
        for ( String e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printStrings(KmSetImpl<String> v)
    {
        if ( v.isEmpty() )
            return;
        for ( String e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printStringsIn(String[] arr)
    {
        printOpenParen();
        printStrings(arr);
        printCloseParen();
    }

    public void printStringsIn(KmList<String> v)
    {
        printOpenParen();
        printStrings(v);
        printCloseParen();
    }

    public void printStringsIn(KmSetImpl<String> v)
    {
        printOpenParen();
        printStrings(v);
        printCloseParen();
    }

    public void printIntegers(Integer[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printIntegers(KmList<Integer> v)
    {
        if ( v.isEmpty() )
            return;
        for ( Integer e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printIntegers(KmSetImpl<Integer> v)
    {
        if ( v.isEmpty() )
            return;
        for ( Integer e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printIntegersIn(Integer[] arr)
    {
        printOpenParen();
        printIntegers(arr);
        printCloseParen();
    }

    public void printIntegersIn(KmList<Integer> v)
    {
        printOpenParen();
        printIntegers(v);
        printCloseParen();
    }

    public void printIntegersIn(KmSetImpl<Integer> v)
    {
        printOpenParen();
        printIntegers(v);
        printCloseParen();
    }

    public void printLongs(Long[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printLongs(KmList<Long> v)
    {
        if ( v.isEmpty() )
            return;
        for ( Long e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printLongs(KmSetImpl<Long> v)
    {
        if ( v.isEmpty() )
            return;
        for ( Long e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printLongsIn(Long[] arr)
    {
        printOpenParen();
        printLongs(arr);
        printCloseParen();
    }

    public void printLongsIn(KmList<Long> v)
    {
        printOpenParen();
        printLongs(v);
        printCloseParen();
    }

    public void printLongsIn(KmSetImpl<Long> v)
    {
        printOpenParen();
        printLongs(v);
        printCloseParen();
    }

    public void printDoubles(Double[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDoubles(KmList<Double> v)
    {
        if ( v.isEmpty() )
            return;
        for ( Double e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDoubles(KmSetImpl<Double> v)
    {
        if ( v.isEmpty() )
            return;
        for ( Double e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDoublesIn(Double[] arr)
    {
        printOpenParen();
        printDoubles(arr);
        printCloseParen();
    }

    public void printDoublesIn(KmList<Double> v)
    {
        printOpenParen();
        printDoubles(v);
        printCloseParen();
    }

    public void printDoublesIn(KmSetImpl<Double> v)
    {
        printOpenParen();
        printDoubles(v);
        printCloseParen();
    }

    public void printDates(KmDate[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDates(KmList<KmDate> v)
    {
        if ( v.isEmpty() )
            return;
        for ( KmDate e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDates(KmSetImpl<KmDate> v)
    {
        if ( v.isEmpty() )
            return;
        for ( KmDate e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printDatesIn(KmDate[] arr)
    {
        printOpenParen();
        printDates(arr);
        printCloseParen();
    }

    public void printDatesIn(KmList<KmDate> v)
    {
        printOpenParen();
        printDates(v);
        printCloseParen();
    }

    public void printDatesIn(KmSetImpl<KmDate> v)
    {
        printOpenParen();
        printDates(v);
        printCloseParen();
    }

    public void printTimes(KmTime[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printTimes(KmList<KmTime> v)
    {
        if ( v.isEmpty() )
            return;
        for ( KmTime e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printTimes(KmSetImpl<KmTime> v)
    {
        if ( v.isEmpty() )
            return;
        for ( KmTime e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printTimesIn(KmTime[] arr)
    {
        printOpenParen();
        printTimes(arr);
        printCloseParen();
    }

    public void printTimesIn(KmList<KmTime> v)
    {
        printOpenParen();
        printTimes(v);
        printCloseParen();
    }

    public void printTimesIn(KmSetImpl<KmTime> v)
    {
        printOpenParen();
        printTimes(v);
        printCloseParen();
    }

    public void printTimestamps(KmTimestamp[] arr)
    {
        long n = arr.length;
        if ( n == 0 )
            return;
        for ( int i = 0; i < n; i++ )
        {
            printValue(arr[i]);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printTimestamps(KmList<KmTimestamp> v)
    {
        if ( v.isEmpty() )
            return;
        for ( KmTimestamp e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printTimestamps(KmSetImpl<KmTimestamp> v)
    {
        if ( v.isEmpty() )
            return;
        for ( KmTimestamp e : v )
        {
            printValue(e);
            printListDelimiter();
        }
        trimListDelimiter();
    }

    public void printTimestampsIn(KmTimestamp[] arr)
    {
        printOpenParen();
        printTimestamps(arr);
        printCloseParen();
    }

    public void printTimestampsIn(KmList<KmTimestamp> v)
    {
        printOpenParen();
        printTimestamps(v);
        printCloseParen();
    }

    public void printTimestampsIn(KmSetImpl<KmTimestamp> v)
    {
        printOpenParen();
        printTimestamps(v);
        printCloseParen();
    }

    public void pad2(int i)
    {
        if ( i < 10 )
            _buffer.append("0");
        _buffer.append(i);
    }

    public void pad3(int i)
    {
        if ( i < 10 )
            _buffer.append("0");
        if ( i < 100 )
            _buffer.append("0");
        _buffer.append(i);
    }

    public void pad4(int i)
    {
        if ( i < 10 )
            _buffer.append("0");
        if ( i < 100 )
            _buffer.append("0");
        if ( i < 1000 )
            _buffer.append("0");
        _buffer.append(i);
    }

    public boolean isEmpty()
    {
        return _buffer.length() == 0;
    }

    public boolean isNotEmpty()
    {
        return _buffer.length() != 0;
    }

    /**
     * Remove the specified number of characters from the end the buffer.
     */
    public void trimSuffix(int suffix)
    {
        _buffer.setLength(_buffer.length() - suffix);
    }

    /**
     * Remove the specified number of characters from the end the buffer.
     * No checking is performed to see if the current suffix match the
     * value to be trimmed.
     */
    public void trimSuffix(String suffix)
    {
        trimSuffix(suffix.length());
    }

    public void trimListDelimiter()
    {
        trimSuffix(STRING_LIST_DELIMITER);
    }

    public void error(String s, Object... args)
    {
        Kmu.fatal(s, args);
    }

    public void unsupported()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString()
    {
        return _buffer.toString();
    }

}
