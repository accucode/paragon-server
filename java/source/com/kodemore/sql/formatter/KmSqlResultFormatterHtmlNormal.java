package com.kodemore.sql.formatter;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;

public class KmSqlResultFormatterHtmlNormal
    extends KmSqlResultFormatter
{
    //##################################################
    //# variables
    //##################################################

    private KmHtmlBuilder _out;

    //##################################################
    //# process
    //##################################################

    @Override
    public void begin(KmSqlResultComposer c)
    {
        _out = new KmHtmlBuilder();
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
    public void formatResultSet(String schema, String sql, KmSqlResultSet rs, KmTimer t)
    {
        beginBlockSelect();
        resultSetSql(schema, sql, t);
        resultSetData(rs);
        endBlock();
    }

    private void resultSetSql(String schema, String sql, KmTimer timer)
    {
        addData(schema, sql, timer);
    }

    private void resultSetData(KmSqlResultSet rs)
    {
        _out.open("table");
        _out.printAttribute("class", "sqlResultTable");
        _out.close();

        resultSetHeaders(rs);
        resultSetRows(rs);

        _out.end("table");
    }

    private void resultSetHeaders(KmSqlResultSet rs)
    {
        _out.begin("tr");

        for ( String s : getColumnNames(rs) )
        {
            _out.open("td");
            _out.printAttribute("class", "sqlResultHeader");
            _out.close();
            _out.print(s);
            _out.end("td");
        }

        _out.end("tr");
    }

    private void resultSetRows(KmSqlResultSet rs)
    {
        int i = 0;
        while ( rs.next() )
            resultSetRow(rs, i++);
    }

    private void resultSetRow(KmSqlResultSet rs, int rowIndex)
    {
        _out.open("tr");
        _out.printAttribute("class", "sqlResultValue");
        _out.close();

        int n = getColumnCount(rs);
        for ( int i = 0; i < n; i++ )
            resultSetValue(rs);

        _out.end("tr");
    }

    private void resultSetValue(KmSqlResultSet rs)
    {
        _out.open("td");
        _out.printAttribute("class", "sqlResultValue");
        _out.close();

        String value = rs.getString();
        if ( value == null )
            _out.print("-null-");
        else
        {
            _out.print(value);
            _out.printNonBreakingSpace();
        }

        _out.end("td");
    }

    //##################################################
    //# format update
    //##################################################

    @Override
    protected void formatUpdate(String schema, String sql, int count, KmTimer timer)
    {
        beginBlockUpdate();
        addData(schema, sql, timer);
        _out.printBold("Count: " + count);
        endBlock();
    }

    //##################################################
    //# format exception
    //##################################################

    @Override
    protected void formatException(String schema, String sql, Exception ex)
    {
        beginBlockError();
        addData(schema, sql, null);
        _out.printBold(ex.getMessage());
        endBlock();
    }

    //##################################################
    //# support
    //##################################################

    private void addData(String schema, String sql, KmTimer timer)
    {
        _out.open("table");
        _out.printAttribute("class", "sqlResultData");
        _out.close();

        if ( schema != null )
        {
            _out.begin("tr");
            _out.begin("td");
            _out.print("Schema: ");
            _out.end("td");
            _out.begin("td");
            _out.print(schema);
            _out.end("td");
            _out.end("tr");
        }

        if ( sql != null )
        {
            _out.begin("tr");
            _out.begin("td");
            _out.print("Sql: ");
            _out.end("td");
            _out.begin("td");
            _out.print(sql);
            _out.end("td");
            _out.end("tr");
        }

        if ( timer != null )
        {
            _out.begin("tr");
            _out.begin("td");
            _out.print("Seconds: ");
            _out.end("td");
            _out.begin("td");
            _out.print(formatSeconds(timer));
            _out.end("td");
            _out.end("tr");
        }

        _out.end("table");
    }

    private void beginBlockSelect()
    {
        beginBlock("sqlResultSelect");
    }

    private void beginBlockUpdate()
    {
        beginBlock("sqlResultUpdate");
    }

    private void beginBlockError()
    {
        beginBlock("sqlResultError");
    }

    private void beginBlock(String css)
    {
        _out.beginTable();
        _out.beginTableRow();
        _out.beginTableDataCss(css);
    }

    private void endBlock()
    {
        _out.endTableData();
        _out.endTableRow();
        _out.endTable();

        _out.printBreak();
    }

}
