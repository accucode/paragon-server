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

package com.kodemore.jasper.test;

import com.kodemore.jasper.KmJasperBand;
import com.kodemore.jasper.KmJasperDataSourceIF;
import com.kodemore.jasper.KmJasperEchoDataSource;
import com.kodemore.jasper.KmJasperFieldWrapper;
import com.kodemore.jasper.KmJasperGroup;
import com.kodemore.jasper.KmJasperReport;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.field.KmJasperField;

public class KmJasperTestBands
    implements KmJasperTestConstantsIF
{
    public static void main(String[] args)
    {
        new KmJasperTestBands().run();
    }

    private KmJasperField _idField;
    private KmJasperField _groupField;
    private KmJasperField _detailField;

    private void run()
    {
        KmJasperReportBuilder builder;
        builder = getBuilder();
        builder.dumpXml();

        KmJasperReport report;
        report = builder.compile();
        report.setDataSource(getDataSource());
        report.writePdfFile(OUTPUT_PDF_FILE);

        System.out.println("ok.");
    }

    private KmJasperReportBuilder getBuilder()
    {
        KmJasperReportBuilder builder;
        builder = new KmJasperReportBuilder();

        _idField = builder.addIntegerField("id");
        _groupField = builder.addIntegerField("group");
        _detailField = builder.addStringField("detail");

        KmJasperGroup group;
        group = builder.addGroup();
        group.setExpressionField(_groupField);
        group.getHeader().addText("Group Header");
        group.getFooter().addText("Group Footer");

        builder.getTitle().addText("Title");
        builder.getPageHeader().addText("Page Header");
        builder.getColumnHeader().addText("Column Header");

        KmJasperBand columnFooter;
        columnFooter = builder.getColumnFooter();
        columnFooter.setHeight(20); // explicit height is required
        columnFooter.addText("Column Footer");

        KmJasperBand pageFooter;
        pageFooter = builder.getPageFooter();
        pageFooter.setHeight(20); // explicit height is required
        pageFooter.addText("Page Footer");

        builder.getSummary().addText("Summary");

        KmJasperBand detail;
        detail = builder.getDetail();
        detail.addText(_idField).setX(50);
        detail.addText(_groupField).setX(100);
        detail.addText(_detailField).setX(150);

        return builder;
    }

    private KmJasperDataSourceIF getDataSource()
    {
        return new KmJasperEchoDataSource(100)
        {
            @Override
            public Object getFieldValue(KmJasperFieldWrapper f)
            {
                if ( f.matches(_groupField) )
                    return getIndex() / 10;

                return super.getFieldValue(f);
            }
        };
    }
}
