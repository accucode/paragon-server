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

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

/**
 * Export data as Excel (.xlsx).
 */
public class KmExcelBook
    implements Closeable
{
    //##################################################
    //# variables
    //##################################################

    private Workbook                   _inner;
    private KmMap<String,KmExcelFont>  _fonts;
    private KmMap<String,KmExcelStyle> _styles;

    //##################################################
    //# constructor
    //##################################################

    public KmExcelBook()
    {
        _inner = new XSSFWorkbook();
        _fonts = new KmMap<>();
        _styles = new KmMap<>();
    }

    //##################################################
    //# font
    //##################################################

    public KmExcelFont createFont()
    {
        Font e = _inner.createFont();
        return new KmExcelFont(e);
    }

    public KmExcelFont createFont(String key)
    {
        if ( hasFont(key) )
            throw new RuntimeException("Duplicate font key.");

        KmExcelFont e = createFont();
        _fonts.put(key, e);
        return e;
    }

    public KmExcelFont getFont(String key)
    {
        if ( !hasFont(key) )
            throw new RuntimeException("Unknown font key.");

        return _fonts.get(key);
    }

    public boolean hasFont(String key)
    {
        return _fonts.containsKey(key);
    }

    //##################################################
    //# style
    //##################################################

    public KmExcelStyle createStyle()
    {
        CellStyle e = _inner.createCellStyle();
        return new KmExcelStyle(this, e);
    }

    public KmExcelStyle createStyle(String key)
    {
        if ( hasStyle(key) )
            throw new RuntimeException("Duplicate style key.");

        KmExcelStyle e = createStyle();
        _styles.put(key, e);
        return e;
    }

    public KmExcelStyle getStyle(String key)
    {
        if ( !hasStyle(key) )
            throw new RuntimeException("Unknown style key.");

        return _styles.get(key);
    }

    public boolean hasStyle(String key)
    {
        return _styles.containsKey(key);
    }

    //##################################################
    //# book
    //##################################################

    protected Workbook getInner()
    {
        return _inner;
    }

    @Override
    public void close() throws IOException
    {
        _inner.close();
    }

    //##################################################
    //# sheet
    //##################################################

    public KmExcelSheet addSheet()
    {
        return new KmExcelSheet(this, _inner.createSheet());
    }

    public KmExcelSheet addSheet(String name)
    {
        return new KmExcelSheet(this, _inner.createSheet(name));
    }

    //##################################################
    //# formats
    //##################################################

    /**
     * Get the format index that matches the given format string.
     * Creates a new format if one is not found.
     * Aliases 'text' to the proper format.
     *
     * For example:
     *      #,##0
     *      $#,##0.00
     *      $#,##0.00);($#,##0.00)
     *      m/d/yy
     *
     * See also:
     * https://poi.apache.org/apidocs/org/apache/poi/ss/usermodel/BuiltinFormats.html
     */
    protected short getFormatIndexFor(String format)
    {
        // doesn't really 'create' a format, just returns the instance for this book.
        DataFormat df = _inner.createDataFormat();
        return df.getFormat(format);
    }

    //##################################################
    //# export
    //##################################################

    public byte[] toBytes()
    {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream())
        {
            getInner().write(out);
            return out.toByteArray();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }
}
