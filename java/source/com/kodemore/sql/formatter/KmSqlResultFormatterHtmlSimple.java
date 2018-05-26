package com.kodemore.sql.formatter;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

public class KmSqlResultFormatterHtmlSimple
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

        _out.open("table");
        _out.printAttribute("class", "sqlResultTable");
        _out.close();

        _out.begin("tr");
        printCell("schema", "#fff");
        printCell("sql", "#fff");
        printCell("seconds", "#fff");
        printCell("result", "#fff");
        _out.end("tr");
    }

    @Override
    public String end()
    {
        _out.end("table");
        _out.printBreak();
        return _out.toString();
    }

    //##################################################
    //# format select
    //##################################################

    @Override
    public void formatResultSet(String schema, String sql, KmSqlResultSet rs, KmTimer timer)
    {
        String color = COLOR_SELECT;
        String result = formatSimpleResult(rs);
        printResult(schema, sql, timer, result, color);
    }

    private String formatSimpleResult(KmSqlResultSet rs)
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
            return formatNull();

        return s;
    }

    //##################################################
    //# format update
    //##################################################

    @Override
    public void formatUpdate(String schema, String sql, int count, KmTimer timer, boolean rollback)
    {
        String color = COLOR_UPDATE;
        String result = "count: " + count;

        if ( rollback )
            result = result + " (ROLLED BACK)";

        printResult(schema, sql, timer, result, color);
    }

    //##################################################
    //# exception
    //##################################################

    @Override
    public void formatException(String schema, String sql, Exception ex)
    {
        String color = COLOR_ERROR;
        String result = ex.getMessage();
        printResult(schema, sql, null, result, color);
    }

    //##################################################
    //# support
    //##################################################

    private void printResult(String schema, String sql, KmTimer timer, String result, String color)
    {
        _out.begin("tr");
        printCell(schema, color);
        printCell(sql, color);
        printCell(formatSeconds(timer), color);
        printCell(result, color);
        _out.end("tr");
    }

    private void printCell(String value, String color)
    {
        String style = Kmu.format(
            "background-color: %s; padding: 2px; border: 1px solid #000;",
            color);

        _out.open("td");
        _out.printAttribute("style", style);
        _out.close();

        if ( value == null )
            _out.printNonBreakingSpace();
        else
            _out.print(value);

        _out.end("td");
    }
}
