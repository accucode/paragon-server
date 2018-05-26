/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.servlet.control;

import com.kodemore.excel.KmExcelBook;
import com.kodemore.excel.KmExcelCell;
import com.kodemore.excel.KmExcelFont;
import com.kodemore.excel.KmExcelRow;
import com.kodemore.excel.KmExcelSheet;
import com.kodemore.excel.KmExcelStyle;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.utility.ScFormatter;

/**
 * Export grid data as Excel.
 */
public class ScGridExcelExporter<T>
    extends ScGridExporter<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmExcelStyle _headerStyle;

    //##################################################
    //# constructor
    //##################################################

    public ScGridExcelExporter(ScGrid<T> grid)
    {
        super(grid);
    }

    //##################################################
    //# export
    //##################################################

    @Override
    protected byte[] export(KmFilterIF<T> filter)
    {
        try (KmExcelBook book = new KmExcelBook())
        {
            return exportOn(book, filter);
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    private byte[] exportOn(KmExcelBook book, KmFilterIF<T> filter) throws Exception
    {
        createHeaderStyle(book);

        KmExcelSheet sheet = book.addSheet();
        exportHeadersOn(sheet);
        exportDataOn(sheet, filter);
        sheet.autoSizeColumns();

        return book.toBytes();
    }

    //==================================================
    //= export :: headers
    //==================================================

    private void exportHeadersOn(KmExcelSheet sheet)
    {
        KmExcelRow row = sheet.addRow();

        for ( ScGridColumn<T> col : getExportColumns() )
            exportHeaderOn(row, col);
    }

    private void exportHeaderOn(KmExcelRow row, ScGridColumn<T> col)
    {
        KmExcelCell cell;
        cell = row.addCell();
        cell.setValue(col.getHeader());
        cell.setStyle(_headerStyle);
    }

    //==================================================
    //= export :: data
    //==================================================

    private void exportDataOn(KmExcelSheet sheet, KmFilterIF<T> filter)
    {
        for ( T e : filter.getCursor() )
            exportDataOn(sheet, e);
    }

    private void exportDataOn(KmExcelSheet sheet, T e)
    {
        KmExcelRow row = sheet.addRow();

        for ( ScGridColumn<T> col : getExportColumns() )
            exportCellOn(row, col, e);
    }

    private void exportCellOn(KmExcelRow row, ScGridColumn<T> col, T e)
    {
        Object value = getExportValueFor(col, e);
        ScFormatter f = getFormatter();
        String s = f.formatAny(value);

        row.addCell().setValue(s);
    }

    //##################################################
    //# support
    //##################################################

    private void createHeaderStyle(KmExcelBook book)
    {
        KmExcelFont font;
        font = book.createFont();
        font.setPointHeight(12);
        font.setColorBlack();
        font.setBold();

        KmExcelStyle style;
        style = book.createStyle();
        style.setFont(font);
        style.setFormatText();

        _headerStyle = style;
    }
}
