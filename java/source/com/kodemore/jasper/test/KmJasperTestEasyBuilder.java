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

import com.kodemore.jasper.KmJasperDataSourceIF;
import com.kodemore.jasper.KmJasperEchoDataSource;
import com.kodemore.jasper.KmJasperFieldWrapper;
import com.kodemore.jasper.KmJasperGroup;
import com.kodemore.jasper.KmJasperLocalFont;
import com.kodemore.jasper.KmJasperReport;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.KmJasperStyle;
import com.kodemore.jasper.easy.KmJasperEasyBuilder;
import com.kodemore.jasper.field.KmJasperField;

public class KmJasperTestEasyBuilder
    implements KmJasperTestConstantsIF
{
    public static void main(String[] args)
    {
        new KmJasperTestEasyBuilder().run();
    }

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

        KmJasperField cityField = builder.addStringField("city");
        KmJasperField firstNameField = builder.addStringField("first");
        KmJasperField lastNameField = builder.addStringField("last");
        KmJasperField quantityField = builder.addIntegerField("qty");

        KmJasperGroup group;
        group = builder.addGroup(cityField);
        group.getHeader().setHeightInches(.25);

        KmJasperEasyBuilder easy;
        easy = builder.getEasyBuilder();

        easy.addColumn(cityField, "City");
        easy.addColumn(firstNameField, "First Name");
        easy.addColumn(lastNameField, "Last Name");
        easy.addColumn(quantityField, "Quantity").addGroupTotal(group);

        KmJasperLocalFont headerFont;
        headerFont = easy.getPageHeaderFont();
        headerFont.setBold();
        headerFont.setUnderline();

        KmJasperLocalFont footerFont;
        footerFont = easy.getFormats().getGroupFooterFormat().getFont();
        footerFont.setFamilyCourier();
        footerFont.setBold();
        footerFont.setSize(16);

        KmJasperStyle footerStyle;
        footerStyle = easy.getFormats().getGroupFooterFormat().getStyle();
        footerStyle.getBorder().getTopPen();
        footerStyle.getBorder().getBottomPen();
        footerStyle.getFillColor().setYellow();

        easy.build();

        return builder;
    }

    private KmJasperDataSourceIF getDataSource()
    {
        return new KmJasperEchoDataSource(100)
        {
            @Override
            public Object getFieldValue(KmJasperFieldWrapper f)
            {
                if ( f.hasName("city") )
                    return "city-" + getIndex() / 10;

                return super.getFieldValue(f);
            }
        };
    }

}
