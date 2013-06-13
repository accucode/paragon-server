/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kodemore.jasper.KmJasperBand;
import com.kodemore.jasper.KmJasperConstantsIF;
import com.kodemore.jasper.KmJasperExpression;
import com.kodemore.jasper.KmJasperGroup;
import com.kodemore.jasper.KmJasperLocalFont;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.KmJasperStyle;
import com.kodemore.jasper.KmJasperText;
import com.kodemore.jasper.easy.KmJasperEasyColumn.WidthMode;
import com.kodemore.jasper.field.KmJasperField;

public class KmJasperEasyBuilder
    implements KmJasperConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperReportBuilder    _report;
    private List<KmJasperEasyColumn> _easyColumns;
    private KmJasperEasyFormatList   _formatList;
    private int                      _columnSpace;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperEasyBuilder(KmJasperReportBuilder report)
    {
        _report = report;
        _easyColumns = new ArrayList<KmJasperEasyColumn>();
        _formatList = new KmJasperEasyFormatList(_report);
        _columnSpace = 6;
    }

    public KmJasperReportBuilder getReport()
    {
        return _report;
    }

    //##################################################
    //# add columns
    //##################################################

    public KmJasperEasyColumn addColumn(KmJasperField field)
    {
        KmJasperEasyColumn e;
        e = new KmJasperEasyColumn(this, field);
        e.setTitle(field.getName());
        _easyColumns.add(e);
        return e;
    }

    public KmJasperEasyColumn addColumn(KmJasperField field, String title)
    {
        KmJasperEasyColumn e;
        e = addColumn(field);
        e.setTitle(title);
        return e;
    }

    public void build()
    {
        applyColumnWidths();
        applyColumnPositions();
        applyColumnHeaders();
        applyGroupFooters();
        applyDetails();
    }

    private List<KmJasperEasyColumn> getColumns()
    {
        return _easyColumns;
    }

    private void applyColumnWidths()
    {
        List<KmJasperEasyColumn> columns = getColumns();

        int rem = getReport().getPage().getClientWidth();

        int colSpace = _columnSpace;
        int totalColSpace = colSpace * columns.size() - 1;
        rem -= totalColSpace;

        List<KmJasperEasyColumn> fixedColumns = selectColumns(columns, WidthMode.Fixed);
        for ( KmJasperEasyColumn e : fixedColumns )
        {
            int i = e.getFixedWidth();
            e._setWidth(i);
            rem -= i;
        }

        int fixedRem = rem;
        List<KmJasperEasyColumn> percentColumns = selectColumns(columns, WidthMode.Percent);
        for ( KmJasperEasyColumn e : percentColumns )

        {
            double p = e.getPercentWidth();
            int i = (int)(fixedRem * p / 100);
            e._setWidth(i);
            rem -= i;
        }

        List<KmJasperEasyColumn> autoColumns = selectColumns(columns, WidthMode.Auto);
        int n = autoColumns.size();
        if ( n > 0 )
        {
            int i = rem / n;
            Iterator<KmJasperEasyColumn> itr = autoColumns.iterator();
            while ( itr.hasNext() )
            {
                KmJasperEasyColumn e = itr.next();
                if ( itr.hasNext() )
                {
                    e._setWidth(i);
                    rem -= i;
                }
                else
                    e._setWidth(rem);
            }
        }
    }

    private void applyColumnPositions()
    {
        int x = 0;
        for ( KmJasperEasyColumn e : getColumns() )
        {
            e.setX(x);
            x += e.getWidth() + _columnSpace;
        }
    }

    private void applyColumnHeaders()
    {
        KmJasperBand band;
        band = getReport().getPageHeader();

        for ( KmJasperEasyColumn e : getColumns() )
        {
            KmJasperText text;
            text = band.addText(e.getTitle());
            text.setX(e.getX());
            text.setWidth(e.getWidth());

            getFormats().getPageHeaderFormat().applyTo(text);
        }
    }

    private void applyGroupFooters()
    {
        for ( KmJasperEasyColumn col : getColumns() )
        {
            Map<KmJasperGroup,KmJasperExpression> exprs = col.getGroupExpressions();
            Set<KmJasperGroup> groups = exprs.keySet();
            for ( KmJasperGroup group : groups )
            {
                KmJasperExpression expr = exprs.get(group);

                KmJasperBand footer;
                footer = group.getFooter();

                KmJasperText text;
                text = footer.addText(expr);
                text.setX(col.getX());
                text.setWidth(col.getWidth());

                getFormats().getGroupFooterFormat().applyTo(text);
            }
        }
    }

    private void applyDetails()
    {
        KmJasperBand detail;
        detail = getReport().getDetail();

        for ( KmJasperEasyColumn e : getColumns() )
        {
            KmJasperText text;
            text = detail.addText(e.getField());
            text.setX(e.getX());
            text.setWidth(e.getWidth());

            getFormats().getDetailFormat().applyTo(text);
        }
    }

    private List<KmJasperEasyColumn> selectColumns(
        List<KmJasperEasyColumn> columns,
        KmJasperEasyColumn.WidthMode mode)
    {
        List<KmJasperEasyColumn> v = new ArrayList<KmJasperEasyColumn>();
        for ( KmJasperEasyColumn e : columns )
            if ( e.getWidthMode() == mode )
                v.add(e);
        return v;
    }

    //##################################################
    //# formats
    //##################################################

    public KmJasperEasyFormatList getFormats()
    {
        return _formatList;
    }

    public KmJasperLocalFont getPageHeaderFont()
    {
        return getFormats().getPageHeaderFormat().getFont();
    }

    public KmJasperStyle getPageHeaderStyle()
    {
        return getFormats().getPageHeaderFormat().getStyle();
    }

    public KmJasperLocalFont getDetailFont()
    {
        return getFormats().getDetailFormat().getFont();
    }

    public KmJasperStyle getDetailStyle()
    {
        return getFormats().getDetailFormat().getStyle();
    }

    public KmJasperLocalFont getGroupFooterFont()
    {
        return getFormats().getGroupFooterFormat().getFont();
    }

    public KmJasperStyle getGroupFooterStyle()
    {
        return getFormats().getGroupFooterFormat().getStyle();
    }

}
