/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.awt.grid;

import javax.swing.SwingConstants;

public class KmaGridFitSizeModel
    extends KmaGridAbstractSizeModel
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridFitSizeModel create(KmaGrid g, int i)
    {
        KmaGridFitSizeModel m;
        m = new KmaGridFitSizeModel();
        m.setGrid(g);
        m.setOrientation(i);
        return m;
    }

    //##################################################
    //# variables
    //##################################################

    private int _orientation;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridFitSizeModel()
    {
        setHorizontal();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getOrientation()
    {
        return _orientation;
    }

    public void setOrientation(int o)
    {
        _orientation = o;
    }

    public void setHorizontal()
    {
        setOrientation(SwingConstants.HORIZONTAL);
    }

    public void setVertical()
    {
        setOrientation(SwingConstants.VERTICAL);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public int getSizeAt(int i)
    {
        int size = 0;
        int count = 0;
        if ( getOrientation() == SwingConstants.VERTICAL )
        {
            count = getGrid().getRowCount();
            size = getGrid().getClientBounds().height;
        }
        else
        {
            count = getGrid().getColumnCount();
            size = getGrid().getClientBounds().width;
        }
        if ( getGrid().hasGridLines() )
            size -= count - 1;
        if ( size < 0 )
            size = 0;
        int n = size / count;
        if ( i == count - 1 )
            n += size % count;
        return n;
    }

    //##################################################
    //# change notification
    //##################################################

    @Override
    public void sizeChanged()
    {
        // ignored
    }

    @Override
    public void modelChanged()
    {
        // ignored
    }

}
