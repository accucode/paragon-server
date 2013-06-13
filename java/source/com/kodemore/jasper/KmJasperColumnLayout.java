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

package com.kodemore.jasper;

public class KmJasperColumnLayout
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperBand                  _band;

    private int                           _width;

    private int                           _nextX;
    private int                           _nextY;
    private KmJasperAbstractReportElement _previousElement;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperColumnLayout(KmJasperBand e)
    {
        _band = e;
        setWidth(200);

        moveTo(0, 0);
    }

    //##################################################
    //# setup
    //##################################################

    public void setWidth(int e)
    {
        _width = e;
    }

    //##################################################
    //# add
    //##################################################

    public KmJasperText addText(String value)
    {
        KmJasperText text;
        text = _band.addText(value);

        applySettingsTo(text);

        _previousElement = text;
        return text;
    }

    public void moveTo(int x, int y)
    {
        _nextX = x;
        _nextY = y;
        _previousElement = null;
    }

    private void applySettingsTo(KmJasperAbstractReportElement e)
    {
        e.setWidth(_width);
        e.setPosition(_nextX, _nextY);

        int x = _nextX;
        int y = _nextY;
        if ( _previousElement != null )
        {
            x = _previousElement.getX();
            y = _previousElement.getY() + getPreviousHeight();
        }
        e.setPosition(x, y);
    }

    private int getPreviousHeight()
    {
        if ( _previousElement.hasHeight() )
            return _previousElement.getHeight();

        if ( _previousElement instanceof KmJasperAbstractText )
        {
            KmJasperAbstractText text = (KmJasperAbstractText)_previousElement;
            if ( text.hasFont() )
            {
                int size = text.getFont().getEffectiveSize();
                return sizeToHeight(size);
            }
        }

        return getBuilder().getDefaultFont().getSize();
    }

    private int sizeToHeight(int size)
    {
        return (int)(size * 1.25);
    }

    private KmJasperBand getBand()
    {
        return _band;
    }

    private KmJasperReportBuilder getBuilder()
    {
        return getBand().getBuilder();
    }
}
