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
import com.kodemore.jasper.KmJasperFont;
import com.kodemore.jasper.KmJasperLocalFont;
import com.kodemore.jasper.KmJasperReport;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.KmJasperText;

public class KmJasperTestFonts
    implements KmJasperTestConstantsIF
{
    public static void main(String[] args)
    {
        new KmJasperTestFonts().run();
    }

    private void run()
    {
        KmJasperReportBuilder builder;
        builder = getBuilder();
        builder.dumpXml();

        KmJasperReport report;
        report = builder.compile();
        report.writePdfFile(OUTPUT_PDF_FILE);

        System.out.println("ok.");
    }

    private KmJasperReportBuilder getBuilder()
    {
        KmJasperReportBuilder builder;
        builder = new KmJasperReportBuilder();

        KmJasperFont defaultFont;
        defaultFont = builder.getDefaultFont();
        defaultFont.setSize(16);

        KmJasperFont headerFont;
        headerFont = builder.addFont();
        headerFont.setSize(24);
        headerFont.setBold();

        KmJasperBand band;
        band = builder.getBackground();

        int x = 0;
        int y = 0;
        int w = band.getWidth();
        int h = 100;

        KmJasperText text;
        KmJasperLocalFont font;

        // default

        y += h;
        text = band.addText("Default");
        text.setShape(x, y, w, h);

        y += h;
        text = band.addText("Default +underline");
        text.setShape(x, y, w, h);
        text.getFont().setUnderline();

        // header

        y += h;
        text = band.addText("Header");
        text.setShape(x, y, w, h);
        text.setFont(headerFont);

        y += h;
        text = band.addText("Header +underline");
        text.setShape(x, y, w, h);
        font = text.getFont();
        font.setFont(headerFont);
        font.setUnderline();

        return builder;
    }
}
