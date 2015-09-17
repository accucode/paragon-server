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

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

/**
 * I provide formatting sql conditions.  Multiple conditions may be strung
 * together using ANDs and ORs.
 */
public class KmSqlCondition
    implements KmSqlConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String EQUAL                 = " = ";
    public static final String NOT_EQUAL             = " <> ";
    public static final String LESS_THAN             = " < ";
    public static final String LESS_THAN_OR_EQUAL    = " <= ";
    public static final String GREATER_THAN          = " > ";
    public static final String GREATER_THAN_OR_EQUAL = " >= ";
    public static final String IN                    = " in ";
    public static final String NOT_IN                = " not in ";
    public static final String IS_NULL               = " is null";
    public static final String IS_NOT_NULL           = " is not null";
    public static final String EXISTS                = " exists";
    public static final String NOT_EXISTS            = " not exists";
    public static final String AND                   = " and ";
    public static final String OR                    = " or ";
    public static final String MINIMUM               = " min";
    public static final String LIKE                  = " like ";

    //##################################################
    //# variables
    //##################################################

    private KmSqlAdaptor _adaptor;
    private KmSqlBuffer  _buffer;
    private String       _join;
    private int          _count;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlCondition(KmSqlAdaptor a)
    {
        _adaptor = a;
        _buffer = a.newBuffer();
        _count = 0;
        and();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmSqlAdaptor getAdaptor()
    {
        return _adaptor;
    }

    public int getConditionCount()
    {
        return _count;
    }

    public void and()
    {
        _join = AND;
    }

    public void or()
    {
        _join = OR;
    }

    public void setCondition(String s)
    {
        _buffer.clear();
        _buffer.printLiteral(s);
        _count++;
    }

    //##################################################
    //# column comparison
    //##################################################

    public void isEqualColumn(String column1, String column2)
    {
        isEqualColumn(null, column1, null, column2);
    }

    public void isNotEqualColumn(String column1, String column2)
    {
        isNotEqualColumn(null, column1, null, column2);
    }

    public void isLessThanColumn(String column1, String column2)
    {
        isLessThanColumn(null, column1, null, column2);
    }

    public void isLessThanOrEqualColumn(String column1, String column2)
    {
        isLessThanOrEqualColumn(null, column1, null, column2);
    }

    public void isGreaterThanColumn(String column1, String column2)
    {
        isGreaterThanColumn(null, column1, null, column2);
    }

    public void isGreaterThanOrEqualColumn(String column1, String column2)
    {
        isGreaterThanOrEqualColumn(null, column1, null, column2);
    }

    //##################################################
    //# column comparison (alias)
    //##################################################

    public void isEqualColumn(String alias1, String column1, String alias2, String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printLiteral(EQUAL);
        _buffer.printColumn(alias2, column2);
    }

    public void isNotEqualColumn(String alias1, String column1, String alias2, String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printColumn(alias2, column2);
    }

    public void isLessThanColumn(String alias1, String column1, String alias2, String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printColumn(alias2, column2);
    }

    public void isLessThanOrEqualColumn(
        String alias1,
        String column1,
        String alias2,
        String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printColumn(alias2, column2);
    }

    public void isGreaterThanColumn(String alias1, String column1, String alias2, String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printColumn(alias2, column2);
    }

    public void isGreaterThanOrEqualColumn(
        String alias1,
        String column1,
        String alias2,
        String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printColumn(alias2, column2);
    }

    //##################################################
    //# null
    //##################################################

    public void isNull(String column)
    {
        isNull(null, column);
    }

    public void isNotNull(String column)
    {
        isNotNull(null, column);
    }

    //##################################################
    //# null (alias)
    //##################################################

    public void isNull(String alias, String column)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IS_NULL);
    }

    public void isNotNull(String alias, String column)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IS_NOT_NULL);
    }

    public void isNull(String alias, String column, boolean isNull)
    {
        if ( isNull )
            isNull(alias, column);
        else
            isNotNull(alias, column);
    }

    //##################################################
    //# boolean (primitive)
    //##################################################

    public void isEqual(String column, boolean value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, boolean value)
    {
        isNotEqual(null, column, value);
    }

    //##################################################
    //# boolean (primitive, alias)
    //##################################################

    public void isEqual(String alias, String column, boolean value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, boolean value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    //##################################################
    //# boolean (object)
    //##################################################

    public void isEqual(String column, Boolean value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, Boolean value)
    {
        isNotEqual(null, column, value);
    }

    //##################################################
    //# boolean (object, alias)
    //##################################################

    public void isEqual(String alias, String column, Boolean value)
    {
        if ( value == null )
            isNull(alias, column);
        else
            isEqual(alias, column, value.booleanValue());
    }

    public void isNotEqual(String alias, String column, Boolean value)
    {
        if ( value == null )
            isNotNull(alias, column);
        else
            isNotEqual(alias, column, value.booleanValue());
    }

    //##################################################
    //# boolean (convenience)
    //##################################################

    public void isTrue(String column)
    {
        isTrue(null, column);
    }

    public void isFalse(String column)
    {
        isFalse(null, column);
    }

    //##################################################
    //# boolean (convenience, alias)
    //##################################################

    public void isTrue(String alias, String column)
    {
        isEqual(alias, column, true);
    }

    public void isFalse(String alias, String column)
    {
        isEqual(alias, column, false);
    }

    //##################################################
    //# integer (primitive)
    //##################################################

    public void isEqual(String column, int value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, int value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, int value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, int value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, int value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, int value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, int value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, int value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# integer (primitive, alias)
    //##################################################

    public void isEqual(String alias, String column, int value)
    {
        if ( value == UNDEFINED_INT )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, int value)
    {
        if ( value == UNDEFINED_INT )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, int value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, int value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, int value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, int value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, int value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printIntegersIn(value);
    }

    public void isNotIn(String alias, String column, int value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printIntegersIn(value);
    }

    //##################################################
    //# integer (object)
    //##################################################

    public void isEqual(String column, Integer value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, Integer value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, Integer value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, Integer value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, Integer value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, Integer value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, Integer value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, Integer value[])
    {
        isNotIn(null, column, value);
    }

    public void isInIntegers(String column, KmList<Integer> value)
    {
        isInIntegers(null, column, value);
    }

    public void isNotInIntegers(String column, KmList<Integer> value)
    {
        isNotInIntegers(null, column, value);
    }

    public void isInIntegers(String column, KmSetImpl<Integer> value)
    {
        isInIntegers(null, column, value);
    }

    public void isNotInIntegers(String column, KmSetImpl<Integer> value)
    {
        isNotInIntegers(null, column, value);
    }

    //##################################################
    //# integer (object, alias)
    //##################################################

    public void isEqual(String alias, String column, Integer value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, Integer value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, Integer value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, Integer value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, Integer value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, Integer value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, Integer value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printIntegersIn(value);
    }

    public void isNotIn(String alias, String column, Integer value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printIntegersIn(value);
    }

    public void isInIntegers(String alias, String column, KmList<Integer> value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printIntegersIn(value);
    }

    public void isNotInIntegers(String alias, String column, KmList<Integer> value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printIntegersIn(value);
    }

    public void isInIntegers(String alias, String column, KmSetImpl<Integer> value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printIntegersIn(value);
    }

    public void isNotInIntegers(String alias, String column, KmSetImpl<Integer> value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printIntegersIn(value);
    }

    //##################################################
    //# long (primitive)
    //##################################################

    public void isEqual(String column, long value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, long value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, long value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, long value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, long value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, long value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, long value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, long value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# long (primitive, alias)
    //##################################################

    public void isEqual(String alias, String column, long value)
    {
        if ( value == UNDEFINED_LONG )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, long value)
    {
        if ( value == UNDEFINED_LONG )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, long value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printLongsIn(value);
    }

    public void isNotIn(String alias, String column, long value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printLongsIn(value);
    }

    //##################################################
    //# long (object)
    //##################################################

    public void isEqual(String column, Long value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, Long value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, Long value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, Long value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, Long value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, Long value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, Long value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, Long value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# long (object, alias)
    //##################################################

    public void isEqual(String alias, String column, Long value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, Long value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, Long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, Long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, Long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, Long value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, Long value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printLongsIn(value);
    }

    public void isNotIn(String alias, String column, Long value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printLongsIn(value);
    }

    //##################################################
    //# double (primitive)
    //##################################################

    public void isEqual(String column, double value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, double value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, double value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, double value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, double value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, double value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, double value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, double value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# double (primitive, alias)
    //##################################################

    public void isEqual(String alias, String column, double value)
    {
        if ( Double.isNaN(value) )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, double value)
    {
        if ( Double.isNaN(value) )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, double value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printDoublesIn(value);
    }

    public void isNotIn(String alias, String column, double value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printDoublesIn(value);
    }

    //##################################################
    //# double (object)
    //##################################################

    public void isEqual(String column, Double value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, Double value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, Double value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, Double value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, Double value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, Double value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, Double value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, Double value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# double (object, alias)
    //##################################################

    public void isEqual(String alias, String column, Double value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, Double value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, Double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, Double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, Double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, Double value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, Double value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printDoublesIn(value);
    }

    public void isNotIn(String alias, String column, Double value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printDoublesIn(value);
    }

    //##################################################
    //# string
    //##################################################

    public void isEqual(String column, String value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, String value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, String value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, String value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, String value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, String value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, String value[])
    {
        isIn(null, column, value);
    }

    public void isInStrings(String column, KmList<String> value)
    {
        isInStrings(null, column, value);
    }

    public void isInStrings(String column, KmSetImpl<String> value)
    {
        isInStrings(null, column, value);
    }

    public void isNotIn(String column, String value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# string (alias)
    //##################################################

    public void isEqual(String alias, String column, String value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, String value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, String value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, String value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, String value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, String value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, String value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printStringsIn(value);
    }

    public void isInStrings(String alias, String column, KmList<String> value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printStringsIn(value);
    }

    public void isInStrings(String alias, String column, KmSetImpl<String> value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printStringsIn(value);
    }

    public void isNotIn(String alias, String column, String value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printStringsIn(value);
    }

    //##################################################
    //# date
    //##################################################

    public void isEqual(String column, KmDate value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, KmDate value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, KmDate value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, KmDate value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, KmDate value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, KmDate value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, KmDate value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, KmDate value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# date (alias)
    //##################################################

    public void isEqual(String alias, String column, KmDate value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, KmDate value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, KmDate value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, KmDate value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, KmDate value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, KmDate value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, KmDate value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printDatesIn(value);
    }

    public void isNotIn(String alias, String column, KmDate value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printDatesIn(value);
    }

    //##################################################
    //# time
    //##################################################

    public void isEqual(String column, KmTime value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, KmTime value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, KmTime value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, KmTime value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, KmTime value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, KmTime value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, KmTime value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, KmTime value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# time (alias)
    //##################################################

    public void isEqual(String alias, String column, KmTime value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, KmTime value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, KmTime value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, KmTime value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, KmTime value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, KmTime value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, KmTime value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printTimesIn(value);
    }

    public void isNotIn(String alias, String column, KmTime value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printTimesIn(value);
    }

    //##################################################
    //# timestamp
    //##################################################

    public void isEqual(String column, KmTimestamp value)
    {
        isEqual(null, column, value);
    }

    public void isNotEqual(String column, KmTimestamp value)
    {
        isNotEqual(null, column, value);
    }

    public void isLessThan(String column, KmTimestamp value)
    {
        isLessThan(null, column, value);
    }

    public void isLessThanOrEqualTo(String column, KmTimestamp value)
    {
        isLessThanOrEqualTo(null, column, value);
    }

    public void isGreaterThan(String column, KmTimestamp value)
    {
        isGreaterThan(null, column, value);
    }

    public void isGreaterThanOrEqualTo(String column, KmTimestamp value)
    {
        isGreaterThanOrEqualTo(null, column, value);
    }

    public void isIn(String column, KmTimestamp value[])
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, KmTimestamp value[])
    {
        isNotIn(null, column, value);
    }

    //##################################################
    //# timestamp (alias)
    //##################################################

    public void isEqual(String alias, String column, KmTimestamp value)
    {
        if ( value == null )
        {
            isNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(EQUAL);
        _buffer.printValue(value);
    }

    public void isNotEqual(String alias, String column, KmTimestamp value)
    {
        if ( value == null )
        {
            isNotNull(alias, column);
            return;
        }
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_EQUAL);
        _buffer.printValue(value);
    }

    public void isLessThan(String alias, String column, KmTimestamp value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN);
        _buffer.printValue(value);
    }

    public void isLessThanOrEqualTo(String alias, String column, KmTimestamp value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isMinimumLessThanOrEqualTo(String alias, String column, KmTimestamp value)
    {
        _join();
        _buffer.printLiteral(MINIMUM);
        _buffer.printOpenParen();
        _buffer.printColumn(alias, column);
        _buffer.printCloseParen();
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isGreaterThan(String alias, String column, KmTimestamp value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN);
        _buffer.printValue(value);
    }

    public void isGreaterThanOrEqualTo(String alias, String column, KmTimestamp value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isMinimumGreaterThanOrEqualTo(String alias, String column, KmTimestamp value)
    {
        _join();
        _buffer.printLiteral(MINIMUM);
        _buffer.printOpenParen();
        _buffer.printColumn(alias, column);
        _buffer.printCloseParen();
        _buffer.printLiteral(GREATER_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void isIn(String alias, String column, KmTimestamp value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printTimestampsIn(value);
    }

    public void isNotIn(String alias, String column, KmTimestamp value[])
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printTimestampsIn(value);
    }

    public void isLessThanOrEqualToWithDaysOffset(
        String alias,
        String column,
        Integer offset,
        KmTimestamp value)
    {
        /*
         * note: this is mysql specific and works only for positive values of 'offset'.
         * it will create a where clause like the one below:
         *
         * select code from someTable where someColumn + interval 5 day <= '2007-11-03';
         */
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(" + interval " + offset + " day ");
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(value);
    }

    public void datediffColumnWithOffsetIsLessThanOrEqualTo(
        String alias,
        String column,
        Integer offset,
        KmTimestamp value,
        Integer diff)
    {
        /*
         * note: this is mysql specific and works only for positive values of 'offset'.
         * it will create a where clause like the one below:
         *
         * select code from someTable where datediff('2007-11-03', someColumn + interval 5 day) <= 1;
         */
        _join();
        _buffer.printLiteral("datediff(");
        _buffer.printValue(value);
        _buffer.printLiteral(",");
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(" + interval " + offset + " day ");
        _buffer.printLiteral(")");
        _buffer.printLiteral(LESS_THAN_OR_EQUAL);
        _buffer.printValue(diff);
    }

    //##################################################
    //# like
    //##################################################

    public void isLike(String alias, String column, String s)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(LIKE);
        _buffer.printValue(s);
    }

    public void hasSubstring(String alias, String column, String s)
    {
        s = Kmu.replaceAll(s, "\\", "\\\\");
        s = Kmu.replaceAll(s, "%", "\\%");
        s = Kmu.replaceAll(s, "_", "\\_");
        s = "%" + s + "%";
        isLike(alias, column, s);
    }

    public void hasPrefix(String alias, String column, String s)
    {
        s = Kmu.replaceAll(s, "\\", "\\\\");
        s = Kmu.replaceAll(s, "%", "\\%");
        s = Kmu.replaceAll(s, "_", "\\_");
        s = s + "%";
        isLike(alias, column, s);
    }

    //##################################################
    //# exists
    //##################################################

    public void exists(KmSqlStatement st)
    {
        _join();
        _buffer.printLiteral(EXISTS);
        _buffer.printOpenParen();
        _buffer.printStatement(st);
        _buffer.printCloseParen();
    }

    public void notExists(KmSqlStatement st)
    {
        _join();
        _buffer.printLiteral(NOT_EXISTS);
        _buffer.printOpenParen();
        _buffer.printStatement(st);
        _buffer.printCloseParen();
    }

    //##################################################
    //# utility
    //##################################################

    public void literal(String e)
    {
        _join();
        _buffer.printLiteral(e);
    }

    public void condition(KmSqlCondition e)
    {
        _join();
        _condition(e);
    }

    public void notCondition(KmSqlCondition e)
    {
        _join();
        _buffer.printLiteral("not ");
        _condition(e);
    }

    private void _condition(KmSqlCondition e)
    {
        _buffer.printOpenParen();
        _buffer.printLiteral(e.toString());
        _buffer.printCloseParen();
    }

    public void _join()
    {
        if ( _count > 0 )
        {
            _buffer.printSpace();
            _buffer.printLiteral(_join);
            _buffer.printSpace();
        }
        _count++;
    }

    //##################################################
    //# in select
    //##################################################

    public void isIn(String column, KmSqlSelect value)
    {
        isIn(null, column, value);
    }

    public void isNotIn(String column, KmSqlSelect value)
    {
        isNotIn(null, column, value);
    }

    public void isIn(String alias, String column, KmSqlSelect value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(IN);
        _buffer.printStatementIn(value);
    }

    public void isNotIn(String alias, String column, KmSqlSelect value)
    {
        _join();
        _buffer.printColumn(alias, column);
        _buffer.printLiteral(NOT_IN);
        _buffer.printStatementIn(value);
    }

    //##################################################
    //# column testing
    //##################################################

    public void columnsAreEqual(String alias1, String column1, String alias2, String column2)
    {
        _join();
        _buffer.printColumn(alias1, column1);
        _buffer.printEqual();
        _buffer.printColumn(alias2, column2);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _buffer.toString();
    }

    public void printOn(KmSqlBuffer f)
    {
        f.printBuffer(_buffer);
    }

}
