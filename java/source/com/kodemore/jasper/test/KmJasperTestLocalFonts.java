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
import com.kodemore.jasper.KmJasperLocalFont;
import com.kodemore.jasper.KmJasperReport;
import com.kodemore.jasper.KmJasperReportBuilder;
import com.kodemore.jasper.KmJasperText;

public class KmJasperTestLocalFonts
    implements KmJasperTestConstantsIF
{
    public static void main(String[] args)
    {
        new KmJasperTestLocalFonts().run();
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

        KmJasperBand band;
        band = builder.getBackground();

        int x = 0;
        int y = 0;
        int w = band.getWidth();
        int h = 36;

        KmJasperText text;
        KmJasperLocalFont font;

        // default

        y += h;
        text = band.addText("Default");
        text.setPosition(x, y);
        text.setSize(w, h);

        y += h;
        text = band.addText("Default +10");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setSize(10);

        y += h;
        text = band.addText("Default +Italic +12");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setItalic();
        font.setSize(12);

        y += h;
        text = band.addText("Default +Italic +Underline +14");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setItalic();
        font.setUnderline();
        font.setSize(14);

        y += h;
        text = band.addText("Default +Italic +StrikeThrough +16");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setItalic();
        font.setStrikeThrough();
        font.setSize(16);

        // sans

        y += h;
        text = band.addText("Sans +10");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyHelvetica();
        font.setSize(10);

        y += h;
        text = band.addText("Sans +Italic +12");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyHelvetica();
        font.setItalic();
        font.setSize(12);

        y += h;
        text = band.addText("Sans +Italic +Underline +14");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyHelvetica();
        font.setItalic();
        font.setUnderline();
        font.setSize(14);

        y += h;
        text = band.addText("Sans +Italic +StrikeThrough +16");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyHelvetica();
        font.setItalic();
        font.setStrikeThrough();
        font.setSize(16);

        // serif

        y += h;
        text = band.addText("Serif +10");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyTimes();
        font.setSize(10);

        y += h;
        text = band.addText("Serif +Italic +12");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyTimes();
        font.setItalic();
        font.setSize(12);

        y += h;
        text = band.addText("Serif +Italic +Underline +14");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyTimes();
        font.setItalic();
        font.setUnderline();
        font.setSize(14);

        y += h;
        text = band.addText("Serif +Italic +StrikeThrough +16");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyTimes();
        font.setItalic();
        font.setStrikeThrough();
        font.setSize(16);

        // courier

        y += h;
        text = band.addText("Mono +10");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyCourier();
        font.setSize(10);

        y += h;
        text = band.addText("Mono +Italic +12");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyCourier();
        font.setItalic();
        font.setSize(12);

        y += h;
        text = band.addText("Mono +Italic +Underline +14");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyCourier();
        font.setItalic();
        font.setUnderline();
        font.setSize(14);

        y += h;
        text = band.addText("Mono +Italic +StrikeThrough +16");
        text.setPosition(x, y);
        text.setSize(w, h);
        font = text.getFont();
        font.setFamilyCourier();
        font.setItalic();
        font.setStrikeThrough();
        font.setSize(16);

        return builder;
    }
}
