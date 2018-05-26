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

package com.kodemore.freechart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.kodemore.file.KmFile;
import com.kodemore.utility.KmFiles;
import com.kodemore.utility.Kmu;

/**
 * I am used to create simple charts using the JFreeChart library.
 */
public abstract class KmAbstractChart
{
    //##################################################
    //# variables
    //##################################################

    private String  _title;
    private boolean _border;
    private int     _width;
    private int     _height;

    //##################################################
    //# constructor
    //##################################################

    public KmAbstractChart()
    {
        setSize(500, 300);
        setBorder(true);
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    //##################################################
    //# border
    //##################################################

    public boolean getBorder()
    {
        return _border;
    }

    public void setBorder(boolean e)
    {
        _border = e;
    }

    public void showBorder()
    {
        setBorder(true);
    }

    public void hideBorder()
    {
        setBorder(false);
    }

    //##################################################
    //# size
    //##################################################

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int e)
    {
        _width = e;
    }

    public int getHeight()
    {
        return _height;
    }

    public void setHeight(int e)
    {
        _height = e;
    }

    public void setSize(int i)
    {
        setSize(i, i);
    }

    public void setSize(int w, int h)
    {
        setWidth(w);
        setHeight(h);
    }

    //##################################################
    //# generate
    //##################################################

    public byte[] createPng()
    {
        return toPngBytes(createChart());
    }

    public void savePng(String path)
    {
        KmFiles.writeBytes(path, createPng());
    }

    public void savePng(KmFile file)
    {
        savePng(file.getRealPath());
    }

    //##################################################
    //# support
    //##################################################

    private JFreeChart createChart()
    {
        JFreeChart chart;
        chart = createAbstractChart();
        chart.setBorderVisible(getBorder());

        if ( hasTitle() )
            chart.setTitle(getTitle());

        return chart;
    }

    protected abstract JFreeChart createAbstractChart();

    protected byte[] toPngBytes(JFreeChart chart)
    {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream())
        {
            ChartUtilities.writeChartAsPNG(out, chart, getWidth(), getHeight());
            return out.toByteArray();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
