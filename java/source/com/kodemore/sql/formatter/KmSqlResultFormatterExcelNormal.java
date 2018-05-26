package com.kodemore.sql.formatter;

import com.kodemore.excel.KmExcelBook;
import com.kodemore.excel.KmExcelCell;
import com.kodemore.excel.KmExcelFont;
import com.kodemore.excel.KmExcelRow;
import com.kodemore.excel.KmExcelSheet;
import com.kodemore.excel.KmExcelStyle;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.utility.KmTimer;

public class KmSqlResultFormatterExcelNormal
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
        createHeaderStyle();
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
        _sheet = _book.addSheet();

        if ( showsSqlData() )
            resultSetData(schema, sql, timer);

        resultSetHeaders(rs);
        resultSetRows(rs);

        _sheet.autoSizeColumns();
    }

    private void resultSetData(String schema, String sql, KmTimer timer)
    {
        KmExcelRow row;

        row = _sheet.addRow();
        printCellOn(row, "Schema");
        printCellOn(row, schema);

        row = _sheet.addRow();
        printCellOn(row, "Sql");
        printCellOn(row, sql);

        row = _sheet.addRow();
        printCellOn(row, "Seconds");
        printCellOn(row, formatSeconds(timer));

        _sheet.addRow();
    }

    private void resultSetHeaders(KmSqlResultSet rs)
    {
        KmExcelRow row = _sheet.addRow();

        for ( String s : getColumnNames(rs) )
            printHeaderOn(row, s);
    }

    private void resultSetRows(KmSqlResultSet rs)
    {
        while ( rs.next() )
            resultSetRow(rs);
    }

    private void resultSetRow(KmSqlResultSet rs)
    {
        KmExcelRow row = _sheet.addRow();

        int n = getColumnCount(rs);
        for ( int i = 0; i < n; i++ )
            resultSetValue(row, rs);
    }

    private void resultSetValue(KmExcelRow row, KmSqlResultSet rs)
    {
        String value = rs.getString();
        if ( value == null )
            printCellOn(row, formatNull());
        else
            printCellOn(row, value);
    }

    //##################################################
    //# format update
    //##################################################

    @Override
    public void formatUpdate(String schema, String sql, int count, KmTimer timer, boolean rollback)
    {
        if ( showsSqlData() )
            updateData(schema, sql, timer);

        updateCount(count, rollback);
    }

    private void updateData(String schema, String sql, KmTimer timer)
    {
        KmExcelRow row;
        row = _sheet.addRow();
        printCellOn(row, "Schema");
        printCellOn(row, schema);

        row = _sheet.addRow();
        printCellOn(row, "Sql");
        printCellOn(row, sql);

        row = _sheet.addRow();
        printCellOn(row, "Seconds");
        printCellOn(row, formatSeconds(timer));
    }

    private void updateCount(int i, boolean rollback)
    {
        String result = rollback
            ? i + " (ROLLED BACK)"
            : i + "";

        KmExcelRow row;
        row = _sheet.addRow();

        printCellOn(row, "Update count");
        printCellOn(row, result);
    }

    //##################################################
    //# exception
    //##################################################

    @Override
    public void formatException(String schema, String sql, Exception ex)
    {
        KmExcelRow row;
        row = _sheet.addRow();
        printCellOn(row, "Schema");
        printCellOn(row, schema);

        row = _sheet.addRow();
        printCellOn(row, "Sql");
        printCellOn(row, sql);

        row = _sheet.addRow();
        printCellOn(row, "Exception");
        printCellOn(row, ex.getMessage());
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
