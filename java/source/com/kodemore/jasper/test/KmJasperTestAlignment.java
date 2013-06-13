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
import com.kodemore.jasper.KmJasperReport;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.KmJasperText;

public class KmJasperTestAlignment
    implements KmJasperTestConstantsIF
{
    public static void main(String[] args)
    {
        new KmJasperTestAlignment().run();
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
        builder.getDefaultStyle().getBorder().getPen();

        KmJasperBand band;
        band = builder.getBackground();

        int x = 0;
        int y = 0;
        int w = 150;
        int h = 150;

        KmJasperText text;

        // top

        text = band.addText("TopLeft");
        text.setShape(x, y, w, h);
        text.alignTop();
        text.alignLeft();

        x += w;
        text = band.addText("TopCenter");
        text.setShape(x, y, w, h);
        text.alignTop();
        text.alignCenter();

        x += w;
        text = band.addText("TopRight");
        text.setShape(x, y, w, h);
        text.alignTop();
        text.alignRight();

        // middle

        x = 0;
        y += h;
        text = band.addText("MiddleLeft");
        text.setShape(x, y, w, h);
        text.alignMiddle();
        text.alignLeft();

        x += w;
        text = band.addText("MiddleCenter");
        text.setShape(x, y, w, h);
        text.alignMiddle();
        text.alignCenter();

        x += w;
        text = band.addText("MiddleRight");
        text.setShape(x, y, w, h);
        text.alignMiddle();
        text.alignRight();

        // bottom

        x = 0;
        y += h;
        text = band.addText("BottomLeft");
        text.setShape(x, y, w, h);
        text.alignBottom();
        text.alignLeft();

        x += w;
        text = band.addText("BottomCenter");
        text.setShape(x, y, w, h);
        text.alignBottom();
        text.alignCenter();

        x += w;
        text = band.addText("BottomRight");
        text.setShape(x, y, w, h);
        text.alignBottom();
        text.alignRight();

        return builder;
    }

}
