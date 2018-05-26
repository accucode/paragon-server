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

import com.kodemore.collection.KmList;
import com.kodemore.csv.KmCsvBuilder;
import com.kodemore.filter.KmFilterIF;

/**
 * Export grid data as CSV.
 */
public class ScGridCsvExporter<T>
    extends ScGridExporter<T>
{
    //##################################################
    //# constructor
    //##################################################

    public ScGridCsvExporter(ScGrid<T> grid)
    {
        super(grid);
    }

    //##################################################
    //# export
    //##################################################

    @Override
    protected byte[] export(KmFilterIF<T> filter)
    {
        KmCsvBuilder out = new KmCsvBuilder();

        Iterable<T> cursor = filter.getCursor();
        exportOn(out, cursor);

        return out.toString().getBytes();
    }

    private void exportOn(KmCsvBuilder out, Iterable<T> cursor)
    {
        exportHeaders(out);
        exportData(out, cursor);
    }

    private void exportHeaders(KmCsvBuilder out)
    {
        for ( ScGridColumn<T> col : getExportColumns() )
            out.printField(col.getHeader());

        out.endRecord();
    }

    private void exportData(KmCsvBuilder out, Iterable<T> cursor)
    {
        KmList<ScGridColumn<T>> columns = getExportColumns();
        for ( T model : cursor )
        {
            for ( ScGridColumn<T> col : columns )
                exportCell(out, col, model);

            out.endRecord();
        }
    }

    private void exportCell(KmCsvBuilder out, ScGridColumn<T> col, T model)
    {
        Object value = getExportValueFor(col, model);
        out.printField(value);
    }
}
