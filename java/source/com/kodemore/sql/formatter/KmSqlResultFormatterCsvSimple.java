package com.kodemore.sql.formatter;

import com.kodemore.csv.KmCsvBuilder;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;

public class KmSqlResultFormatterCsvSimple
    extends KmSqlResultFormatter
{
    //##################################################
    //# variables
    //##################################################

    private KmCsvBuilder _out;

    //##################################################
    //# process
    //##################################################

    @Override
    public void begin(KmSqlResultComposer c)
    {
        _out = new KmCsvBuilder();
        _out.printField("schema");
        _out.printField("sql");
        _out.printField("status");
        _out.printField("seconds");
        _out.printField("result");
        _out.endRecord();
    }

    @Override
    public String end()
    {
        return _out.toString();
    }

    //##################################################
    //# format select
    //##################################################

    @Override
    public void formatResultSet(String schema, String sql, KmSqlResultSet rs, KmTimer timer)
    {
        String result = format(rs);
        printResult(schema, sql, "select", timer, result);
    }

    private String format(KmSqlResultSet rs)
    {
        if ( !rs.next() )
            return "Empty";

        if ( getColumnCount(rs) > 1 )
            return "Too many columns.";

        String s = rs.getString();
        boolean wasNull = rs.wasNull();

        if ( rs.next() )
            return "Too many rows.";

        if ( wasNull )
            return "-null-";

        return s;
    }

    //##################################################
    //# format update
    //##################################################

    @Override
    public void formatUpdate(String schema, String sql, int count, KmTimer timer, boolean rollback)
    {
        String result = "count: " + count;

        if ( rollback )
            result = result + " (ROLLED BACK)";

        printResult(schema, sql, "update", timer, result);
    }

    //##################################################
    //# exception
    //##################################################

    @Override
    public void formatException(String schema, String sql, Exception ex)
    {
        String result = ex.getMessage();
        printResult(schema, sql, "error", null, result);
    }

    //##################################################
    //# support
    //##################################################

    private void printResult(String schema, String sql, String status, KmTimer timer, String result)
    {
        _out.printField(schema);
        _out.printField(sql);
        _out.printField(status);
        _out.printField(formatSeconds(timer));
        _out.printField(result);
        _out.endRecord();
    }
}
