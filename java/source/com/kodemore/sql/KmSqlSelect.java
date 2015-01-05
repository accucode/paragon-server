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

import com.kodemore.sql.adaptor.KmSqlAdaptor;
import com.kodemore.utility.Kmu;

/**
 * I provide convenience methods for creating a select statement.
 */
public class KmSqlSelect
    extends KmSqlConditionalStatement
{
    //##################################################
    //# constants
    //##################################################

    public static final String ALL        = "*";
    public static final String AS         = " AS ";
    public static final String COUNT      = "COUNT";
    public static final String DESCENDING = " DESC";
    public static final String DISTINCT   = "DISTINCT ";
    public static final String FROM       = " FROM ";
    public static final String GROUP_BY   = " GROUP BY ";
    public static final String HAVING     = " HAVING ";
    public static final String IF         = " IF ";
    public static final String MAX        = "MAX";
    public static final String MIN        = "MIN";
    public static final String ORDER_BY   = " ORDER BY ";
    public static final String SELECT     = "SELECT ";
    public static final String SUBSTRING  = "SUBSTRING";
    public static final String SUFFIX     = " SUFFIX ";
    public static final String SUM        = "SUM";
    public static final String LIMIT      = "LIMIT";

    //##################################################
    //# variables
    //##################################################

    private KmSqlBuffer        _columns;
    private KmSqlBuffer        _tables;
    private KmSqlBuffer        _groupBys;
    private KmSqlBuffer        _orderBys;
    private Integer            _rowLimit;
    private String             _suffix;
    private KmSqlCondition     _having;

    //##################################################
    //# constructor
    //##################################################

    public KmSqlSelect(KmSqlAdaptor a)
    {
        super(a);
        _columns = newBuffer();
        _tables = newBuffer();
        _groupBys = newBuffer();
        _orderBys = newBuffer();
        _rowLimit = null;
        _suffix = null;
        _having = new KmSqlCondition(a);
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getSqlString()
    {
        KmSqlBuffer f = newBuffer();
        f.printLiteral(SELECT);
        f.printBuffer(_columns);
        f.printLiteral(FROM);
        f.printBuffer(_tables);
        printWhereConditionsOn(f);
        if ( hasGroupBys() )
        {
            f.printLiteral(GROUP_BY);
            f.printBuffer(_groupBys);
        }
        printHavingConditionsOn(f);
        if ( hasOrderBys() )
        {
            f.printLiteral(ORDER_BY);
            f.printBuffer(_orderBys);
        }
        if ( hasRowLimit() )
        {
            f.printSpace();
            f.printLiteral(LIMIT);
            f.printSpace();
            f.printValue(_rowLimit);
        }
        if ( hasSuffix() )
        {
            f.printSpace();
            f.printLiteral(_suffix);
        }
        return f.toString();
    }

    public String getTables()
    {
        return _tables.toString();
    }

    public boolean hasTables()
    {
        return _tables.isNotEmpty();
    }

    public String getColumns()
    {
        return _columns.toString();
    }

    public boolean hasColumns()
    {
        return _columns.isNotEmpty();
    }

    public String getGroupBys()
    {
        return _groupBys.toString();
    }

    public boolean hasGroupBys()
    {
        return _groupBys.isNotEmpty();
    }

    public KmSqlCondition having()
    {
        return _having;
    }

    public void setHaving(KmSqlCondition c)
    {
        _having = c;
    }

    public boolean hasHaving()
    {
        return _having.getConditionCount() > 0;
    }

    public void printHavingConditionsOn(KmSqlBuffer b)
    {
        if ( hasHaving() )
        {
            b.printLiteral(HAVING);
            _having.printOn(b);
        }
    }

    public String getOrderBys()
    {
        return _orderBys.toString();
    }

    public boolean hasOrderBys()
    {
        return _orderBys.isNotEmpty();
    }

    public Integer getRowLimit()
    {
        return _rowLimit;
    }

    public void setRowLimit(Integer e)
    {
        _rowLimit = e;
    }

    public boolean hasRowLimit()
    {
        return _rowLimit != null;
    }

    public String getSuffix()
    {
        return _suffix;
    }

    public void setSuffix(String s)
    {
        _suffix = s;
    }

    public boolean hasSuffix()
    {
        return Kmu.hasValue(getSuffix());
    }

    //##################################################
    //# validate
    //##################################################

    public void validate()
    {
        if ( !hasTables() )
            throw newFatal("Must specify a table to select from.");

        if ( !hasColumns() )
            throw newFatal("Must specify a value to select.");
    }

    //##################################################
    //# select values
    //##################################################

    public void selectString(String table, String column)
    {
        _startColumn();
        getAdaptor().getStringAdaptor().select(this, table, column);
    }

    public void selectByteArray(String table, String column)
    {
        _startColumn();
        getAdaptor().getByteArrayAdaptor().select(this, table, column);
    }

    public void selectInteger(String table, String column)
    {
        _startColumn();
        getAdaptor().getIntegerAdaptor().select(this, table, column);
    }

    public void selectLong(String table, String column)
    {
        _startColumn();
        getAdaptor().getLongAdaptor().select(this, table, column);
    }

    public void selectDouble(String table, String column)
    {
        _startColumn();
        getAdaptor().getDoubleAdaptor().select(this, table, column);
    }

    public void selectBoolean(String table, String column)
    {
        _startColumn();
        getAdaptor().getBooleanAdaptor().select(this, table, column);
    }

    public void selectDate(String table, String column)
    {
        _startColumn();
        getAdaptor().getDateAdaptor().select(this, table, column);
    }

    public void selectTime(String table, String column)
    {
        _startColumn();
        getAdaptor().getTimeAdaptor().select(this, table, column);
    }

    public void selectTimestamp(String table, String column)
    {
        _startColumn();
        getAdaptor().getTimestampAdaptor().select(this, table, column);
    }

    public void selectMoney(String table, String column)
    {
        _startColumn();
        getAdaptor().getMoneyAdaptor().select(this, table, column);
    }

    public void selectWeight(String table, String column)
    {
        _startColumn();
        getAdaptor().getWeightAdaptor().select(this, table, column);
    }

    public void selectKilogram(String table, String column)
    {
        _startColumn();
        getAdaptor().getKilogramAdaptor().select(this, table, column);
    }

    public void selectQuantity(String table, String column)
    {
        _startColumn();
        getAdaptor().getQuantityAdaptor().select(this, table, column);
    }

    public void selectRate(String table, String column)
    {
        _startColumn();
        getAdaptor().getRateAdaptor().select(this, table, column);
    }

    public void selectCost(String table, String column)
    {
        _startColumn();
        getAdaptor().getCostAdaptor().select(this, table, column);
    }

    public void selectDayFrequency(String table, String column)
    {
        _startColumn();
        getAdaptor().getDayFrequencyAdaptor().select(this, table, column);
    }

    //##################################################
    //# select (convenience)
    //##################################################

    public void selectStar()
    {
        selectStar(null);
    }

    public void selectStar(String table)
    {
        _columns.printColumn(table, ALL, null);
    }

    public void selectCount()
    {
        selectCount(null, ALL);
    }

    public void selectCount(String table, String column)
    {
        _startColumn();
        _columns.printLiteral(COUNT);
        _printColumnIn(table, column, null);
    }

    public void selectCountDistinct(String table, String column)
    {
        _startColumn();
        _columns.printLiteral(COUNT);
        _columns.printOpenParen();
        _columns.printLiteral(DISTINCT);
        _printColumnIn(table, column, null);
        _columns.printCloseParen();
    }

    public void selectDistinct(String table, String column)
    {
        _startColumn();
        _columns.printLiteral(DISTINCT);
        _printColumnIn(table, column, null);
    }

    public void selectMinimum(String table, String column)
    {
        _startColumn();
        _columns.printLiteral(MIN);
        _printColumnIn(table, column, null);
    }

    public void selectMaximum(String table, String column)
    {
        _startColumn();
        _columns.printLiteral(MAX);
        _printColumnIn(table, column, null);
    }

    public void selectSum(String table, String column)
    {
        _startColumn();
        _columns.printLiteral(SUM);
        _printColumnIn(table, column, null);
    }

    public void selectSubstring(String table, String column, int startPosition, int length)
    {
        _startColumn();
        _columns.printLiteral(SUBSTRING);
        _printColumnIn(table, column, null, startPosition, length);
    }

    public void selectAs(String column, String alias)
    {
        _startColumn();
        _columns.printColumn(null, column, alias);
    }

    public void selectAs(String table, String column, String alias)
    {
        _startColumn();
        _columns.printColumn(table, column, alias);
    }

    public void selectColumn(String table, String column)
    {
        _startColumn();
        _columns.printColumn(table, column, null);
    }

    public void selectLiteral(String value)
    {
        _startColumn();
        _columns.printLiteral(value);
    }

    //##################################################
    //# select conditional
    //##################################################

    public void selectConditionalCountDistinct(
        KmSqlCondition cond,
        String trueTable,
        String trueColumn)
    {
        _startColumn();
        _columns.printLiteral(COUNT);
        _columns.printOpenParen();
        _columns.printLiteral(DISTINCT);
        _printIfIn(cond, trueTable, trueColumn, null);
        _columns.printCloseParen();
    }

    public void selectConditionalSum(KmSqlCondition cond, Integer trueValue, Integer falseValue)
    {
        _startColumn();
        _columns.printLiteral(SUM);
        _printIfIn(cond, trueValue, falseValue);
    }

    public void selectConditionalSum(
        KmSqlCondition cond,
        Integer trueValue,
        String falseTable,
        String falseColumn)
    {
        _startColumn();
        _columns.printLiteral(SUM);
        _printIfIn(cond, trueValue, falseTable, falseColumn);
    }

    public void selectConditionalSum(
        KmSqlCondition cond,
        String trueTable,
        String trueColumn,
        Integer falseValue)
    {
        _startColumn();
        _columns.printLiteral(SUM);
        _printIfIn(cond, trueTable, trueColumn, falseValue);
    }

    public void selectConditionalSum(
        KmSqlCondition cond,
        String trueTable,
        String trueColumn,
        String falseTable,
        String falseColumn)
    {
        _startColumn();
        _columns.printLiteral(SUM);
        _printIfIn(cond, trueTable, trueColumn, falseTable, falseColumn);
    }

    //##################################################
    //# private
    //##################################################

    public void _startColumn()
    {
        if ( _columns.isNotEmpty() )
            _nextColumn();
    }

    public void _nextColumn()
    {
        _columns.printListDelimiter();
    }

    public void _printColumnIn(String table, String column, String alias)
    {
        _columns.printOpenParen();
        _columns.printColumn(table, column, alias);
        _columns.printCloseParen();
    }

    public void _printColumnIn(String table, String column, String alias, Object... values)
    {
        _columns.printOpenParen();
        _columns.printColumn(table, column, alias);
        for ( Object e : values )
        {
            // kludge: use of object.toString()
            _columns.printComma();
            _columns.printLiteral(e.toString());
        }

        _columns.printCloseParen();
    }

    //##################################################
    //# print if
    //##################################################

    public void _printIfIn(KmSqlCondition cond, Integer trueValue, Integer falseValue)
    {
        _printOpenIfIn(cond);
        _columns.printLiteral(trueValue + "");
        _columns.printListDelimiter();
        _columns.printLiteral(falseValue + "");
        _printCloseIfIn();
    }

    public void _printIfIn(
        KmSqlCondition cond,
        Integer trueValue,
        String falseTable,
        String falseColumn)
    {
        _printOpenIfIn(cond);
        _columns.printLiteral(trueValue + "");
        _columns.printListDelimiter();
        _printColumn(falseTable, falseColumn, null);
        _printCloseIfIn();
    }

    public void _printIfIn(
        KmSqlCondition cond,
        String trueTable,
        String trueColumn,
        Integer falseValue)
    {
        _printOpenIfIn(cond);
        _printColumn(trueTable, trueColumn, null);
        _columns.printListDelimiter();
        _columns.printLiteral(falseValue + "");
        _printCloseIfIn();
    }

    public void _printIfIn(
        KmSqlCondition cond,
        String trueTable,
        String trueColumn,
        String falseTable,
        String falseColumn)
    {
        _printOpenIfIn(cond);
        _printColumn(trueTable, trueColumn, null);
        _columns.printListDelimiter();
        _printColumn(falseTable, falseColumn, null);
        _printCloseIfIn();
    }

    public void _printOpenIfIn(KmSqlCondition cond)
    {
        _columns.printOpenParen();
        _columns.printLiteral(IF);
        _columns.printOpenParen();
        _columns.printCondition(cond);
        _columns.printListDelimiter();
    }

    public void _printCloseIfIn()
    {
        _columns.printCloseParen();
        _columns.printCloseParen();
    }

    //##################################################
    //# from
    //##################################################

    public void from(String table)
    {
        _from(table, null);
    }

    public void from(String table, String alias)
    {
        _from(table, alias);
    }

    public void _from(String table, String alias)
    {
        if ( hasTables() )
            _tables.printListDelimiter();
        _tables.printLiteral(table);
        if ( Kmu.hasValue(alias) )
        {
            _tables.printSpace();
            _tables.printLiteral(alias);
        }
    }

    public void from(KmSqlSelect st, String alias)
    {
        if ( hasTables() )
            _tables.printListDelimiter();
        _tables.printOpenParen();
        _tables.printLiteral(st.getSqlString());
        _tables.printCloseParen();
        _tables.printLiteral(" as ");
        _tables.printLiteral(alias);
    }

    //##################################################
    //# where
    //##################################################

    public void join(String fromTable, String fromColumn, String toTable, String toColumn)
    {
        where().isEqualColumn(fromTable, fromColumn, toTable, toColumn);
    }

    //##################################################
    //# group by
    //##################################################

    public void groupBy(String alias, String column)
    {
        _groupBy(alias, column);
    }

    public void _groupBy(String table, String column)
    {
        if ( hasGroupBys() )
            _groupBys.printListDelimiter();
        _groupBys.printColumn(table, column);
    }

    public void groupBy(int selectColumnIndex)
    {
        if ( hasGroupBys() )
            _groupBys.printListDelimiter();
        _groupBys.printLiteral(selectColumnIndex + "");
    }

    public void groupBy(int... selectColumnIndices)
    {
        for ( int e : selectColumnIndices )
            groupBy(e);
    }

    //##################################################
    //# order by
    //##################################################

    public void orderBy(String alias, String column)
    {
        orderByAscending(alias, column);
    }

    public void orderByAscending(String table, String column)
    {
        _orderBy(table, column, false);
    }

    public void orderByDescending(String table, String column)
    {
        _orderBy(table, column, true);
    }

    public void _orderBy(String table, String column, boolean descending)
    {
        if ( hasOrderBys() )
            _orderBys.printListDelimiter();
        _orderBys.printColumn(table, column);
        if ( descending )
            _orderBys.printLiteral(DESCENDING);
    }

    //##################################################
    //# execute
    //##################################################

    public KmSqlResultSet execute(KmSqlConnection con)
    {
        return _executeQuery(con);
    }

    //##################################################
    //# formatter access
    //##################################################

    public KmSqlBuffer getColumnBuffer()
    {
        return _columns;
    }

    public void _printColumn(String table, String column, String alias)
    {
        _columns.printColumn(table, column, alias);
    }
}
