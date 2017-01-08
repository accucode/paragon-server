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

import com.kodemore.filter.KmFilterIF;
import com.kodemore.html.KmHtmlBuilder;

import com.app.file.MyResourceFiles;

/**
 * Export grid data as HTML.
 */
public class ScGridHtmlExporter<T>
    extends ScGridExporter<T>
{
    //##################################################
    //# constructor
    //##################################################

    public ScGridHtmlExporter(ScGrid<T> grid)
    {
        super(grid);
    }

    //##################################################
    //# export
    //##################################################

    @Override
    protected byte[] export(KmFilterIF<T> filter)
    {
        String style = MyResourceFiles.getInstance().getDataExportStyle().readString();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();

        out.beginHead();
        out.printMetaCharsetUtf8();
        out.printLiteral(style);
        out.endHead();

        out.beginBody();

        exportTableOn(out, filter);

        out.endBody();
        out.endHtml();

        return out.toString().getBytes();
    }

    private void exportTableOn(KmHtmlBuilder out, KmFilterIF<T> filter)
    {
        out.openTable();
        out.printAttribute("class", "exportTable");
        out.close();

        exportHeadersOn(out);
        exportDataOn(out, filter);

        out.endTable();
    }

    private void exportHeadersOn(KmHtmlBuilder out)
    {
        out.beginTableRow();

        for ( ScGridColumn<T> col : getExportColumns() )
            exportHeaderOn(out, col);

        out.endTableRow();
    }

    private void exportHeaderOn(KmHtmlBuilder out, ScGridColumn<T> col)
    {
        out.beginTableHeader();
        out.print(col.getHeader());
        out.endTableHeader();
    }

    private void exportDataOn(KmHtmlBuilder out, KmFilterIF<T> filter)
    {
        for ( T model : filter.getCursor() )
            exportRowOn(out, model);
    }

    private void exportRowOn(KmHtmlBuilder out, T model)
    {
        out.beginTableRow();

        for ( ScGridColumn<T> col : getExportColumns() )
            exportCellOn(out, col, model);

        out.beginTableRow();
    }

    private void exportCellOn(KmHtmlBuilder out, ScGridColumn<T> col, T model)
    {
        Object value = getExportValueFor(col, model);

        out.beginTableData();
        out.print(value);
        out.endTableData();
    }
}
