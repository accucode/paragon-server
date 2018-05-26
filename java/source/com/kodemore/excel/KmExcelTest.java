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

package com.kodemore.excel;

import com.kodemore.utility.KmFiles;
import com.kodemore.utility.Kmu;

/**
 * Export data as Excel.
 */
public class KmExcelTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new KmExcelTest().run();
    }

    //##################################################
    //# constants
    //##################################################

    private static final String HEADER = "header";

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        try (KmExcelBook book = new KmExcelBook())
        {
            run(book);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private void run(KmExcelBook book)
    {
        addHeaderStyle(book);
        addSheet(book, "aa");
        addSheet(book, "bb");
        write(book);
        System.out.println("ok.");
    }

    private void addHeaderStyle(KmExcelBook book)
    {
        KmExcelFont font;
        font = book.createFont();
        font.setColorBlue();
        font.setFamilyArial();
        font.setPointHeight(12);

        KmExcelStyle style;
        style = book.createStyle(HEADER);
        style.setFormatText();
        style.setBackgroundYellow();
        style.setFont(font);
    }

    private void addSheet(KmExcelBook book, String name)
    {
        KmExcelSheet sheet;
        sheet = book.addSheet(name);

        KmExcelRow row;
        KmExcelCell cell;

        // row 1

        row = sheet.addRow();

        cell = row.addCell();
        cell.setValue("hello1");

        cell = row.addCell();
        cell.setStyle(HEADER);
        cell.setValue("world1");

        // row 2

        row = sheet.addRow();

        cell = row.addCell();
        cell.setValue("hello2");

        cell = row.addCell();
        cell.setStyle(HEADER);
        cell.setValue("world2");

        sheet.autoSizeColumns();
    }

    private void write(KmExcelBook book)
    {
        KmFiles.writeBytes("/temp/out.xlsx", book.toBytes());
    }

}
