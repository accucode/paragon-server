package com.kodemore.sql.formatter;

import com.kodemore.csv.KmCsvBuilder;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;

public class KmSqlResultFormatterCsvNormal
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
        resultSetData(schema, sql, timer);
        resultSetHeaders(rs);
        resultSetRows(rs);
        _out.endRecord();
    }

    private void resultSetData(String schema, String sql, KmTimer timer)
    {
        _out.printField("Schema");
        _out.printField(schema);
        _out.endRecord();

        _out.printField("Sql");
        _out.printField(sql);
        _out.endRecord();

        _out.printField("Seconds");
        _out.printField(formatSeconds(timer));
        _out.endRecord();
    }

    private void resultSetHeaders(KmSqlResultSet rs)
    {
        for ( String s : getColumnNames(rs) )
            _out.printField(s);
        _out.endRecord();
    }

    private void resultSetRows(KmSqlResultSet rs)
    {
        while ( rs.next() )
            resultSetRow(rs);
    }

    private void resultSetRow(KmSqlResultSet rs)
    {
        int n = getColumnCount(rs);
        for ( int i = 0; i < n; i++ )
            resultSetValue(rs);
        _out.endRecord();
    }

    private void resultSetValue(KmSqlResultSet rs)
    {
        String value = rs.getString();
        if ( value == null )
            _out.printField("-null-");
        else
            _out.printField(value);
    }

    //##################################################
    //# format update
    //##################################################

    @Override
    public void formatUpdate(String schema, String sql, int count, KmTimer timer, boolean rollback)
    {
        updateData(schema, sql, timer);
        updateCount(count, rollback);

        _out.endRecord();
    }

    private void updateData(String schema, String sql, KmTimer timer)
    {
        _out.printField("Schema");
        _out.printField(schema);
        _out.endRecord();

        _out.printField("Sql");
        _out.printField(sql);
        _out.endRecord();

        _out.printField("Seconds");
        _out.printField(formatSeconds(timer));
        _out.endRecord();
    }

    private void updateCount(int i, boolean rollback)
    {
        String result = rollback
            ? i + " (ROLLED BACK)"
            : i + "";

        _out.printField("Update count");
        _out.printField(result);
        _out.endRecord();
    }

    //##################################################
    //# exception
    //##################################################

    @Override
    public void formatException(String schema, String sql, Exception ex)
    {
        _out.printField("Schema");
        _out.printField(schema);
        _out.endRecord();

        _out.printField("Sql");
        _out.printField(sql);
        _out.endRecord();

        _out.printField("Exception");
        _out.printField(ex.getMessage());
        _out.endRecord();

        _out.endRecord();
    }
}
