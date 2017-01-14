/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import java.io.ByteArrayOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kodemore.collection.KmList;
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

    private CellStyle _headerStyle;

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
        try (Workbook book = new XSSFWorkbook())
        {
            return exportOn(book, filter);
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    private byte[] exportOn(Workbook book, KmFilterIF<T> filter) throws Exception
    {
        createHeaderStyle(book);

        Sheet sheet;
        sheet = book.createSheet();

        Row row;
        int rowIndex = 0;

        row = sheet.createRow(rowIndex);
        exportHeadersOn(row);
        rowIndex++;

        for ( T e : filter.getCursor() )
        {
            row = sheet.createRow(rowIndex);
            exportDataOn(row, e);
            rowIndex++;
        }

        autoSizeColumns(sheet);

        return save(book);
    }

    private void exportHeadersOn(Row row)
    {
        int colIndex = 0;

        KmList<ScGridColumn<T>> cols = getExportColumns();
        for ( ScGridColumn<T> col : cols )
        {
            exportHeaderOn(row, col, colIndex);
            colIndex++;
        }
    }

    private void exportHeaderOn(Row row, ScGridColumn<T> col, int colIndex)
    {
        Cell cell;
        cell = row.createCell(colIndex);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellStyle(_headerStyle);
        cell.setCellValue(col.getHeader());
    }

    private void exportDataOn(Row row, T e)
    {
        int colIndex = 0;

        KmList<ScGridColumn<T>> cols = getExportColumns();
        for ( ScGridColumn<T> col : cols )
        {
            exportCellOn(row, col, e, colIndex);
            colIndex++;
        }
    }

    private void exportCellOn(Row row, ScGridColumn<T> col, T e, int colIndex)
    {
        Object value = getExportValueFor(col, e);
        ScFormatter f = getFormatter();
        String s = f.formatAny(value);

        Cell cell;
        cell = row.createCell(colIndex);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(s);
    }

    //##################################################
    //# support
    //##################################################

    private void createHeaderStyle(Workbook book)
    {
        DataFormat format = book.createDataFormat();

        Font font;
        font = book.createFont();
        font.setFontHeightInPoints((short)12);
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        CellStyle style;
        style = book.createCellStyle();
        style.setFont(font);
        style.setDataFormat(format.getFormat("text"));
        _headerStyle = style;
    }

    private void autoSizeColumns(Sheet sheet)
    {
        int n = getExportColumns().size();
        for ( int i = 0; i < n; i++ )
            sheet.autoSizeColumn(i);
    }

    private byte[] save(Workbook book) throws Exception
    {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream())
        {
            book.write(out);
            return out.toByteArray();
        }
    }

}
