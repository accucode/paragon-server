package com.kodemore.sql.formatter;

import com.kodemore.excel.KmExcelBook;
import com.kodemore.excel.KmExcelCell;
import com.kodemore.excel.KmExcelFont;
import com.kodemore.excel.KmExcelRow;
import com.kodemore.excel.KmExcelSheet;
import com.kodemore.excel.KmExcelStyle;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;

public class KmSqlResultFormatterExcelSimple
    extends KmSqlResultFormatterExcel
{
    //##################################################
    //# variables
    //##################################################

    private KmExcelBook  _book;
    private KmExcelSheet _sheet;

    private KmExcelStyle _headerStyle;

    //##################################################
    //# process
    //##################################################

    @Override
    public void begin(KmSqlResultComposer c)
    {
        _book = new KmExcelBook();
        _sheet = _book.addSheet();

        createHeaderStyle();

        KmExcelRow row;
        row = _sheet.addRow();

        printHeaderOn(row, "schema");
        printHeaderOn(row, "sql");
        printHeaderOn(row, "status");
        printHeaderOn(row, "seconds");
        printHeaderOn(row, "result");
    }

    @Override
    public byte[] endBytes()
    {
        return _book.toBytes();
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
            return formatNull();

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
        KmExcelRow row = _sheet.addRow();

        printCellOn(row, schema);
        printCellOn(row, sql);
        printCellOn(row, status);
        printCellOn(row, formatSeconds(timer));
        printCellOn(row, result);
    }

    //##################################################
    //# support
    //##################################################

    private void createHeaderStyle()
    {
        KmExcelFont font;
        font = _book.createFont();
        font.setPointHeight(12);
        font.setColorBlack();
        font.setBold();

        KmExcelStyle style;
        style = _book.createStyle();
        style.setFont(font);
        style.setFormatText();

        _headerStyle = style;
    }

    private void printHeaderOn(KmExcelRow row, String header)
    {
        KmExcelCell cell;
        cell = row.addCell();
        cell.setValue(header);
        cell.setStyle(_headerStyle);
    }

    private void printCellOn(KmExcelRow row, String value)
    {
        row.addCell().setValue(value);
    }
}
