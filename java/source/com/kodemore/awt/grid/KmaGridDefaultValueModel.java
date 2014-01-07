/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import java.awt.Dimension;

public class KmaGridDefaultValueModel
    extends Object
    implements KmaGridValueModelIF
{
    //##################################################
    //# variables
    //##################################################

    private Dimension  _size;
    private Object[][] _values;
    private Object[]   _rowHeaders;
    private Object[]   _columnHeaders;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridDefaultValueModel()
    {
        setSize(new Dimension());
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public int getRowCount()
    {
        return _size.height;
    }

    @Override
    public int getColumnCount()
    {
        return _size.width;
    }

    public void setSize(Dimension d)
    {
        _size = new Dimension(d);
        resetArray();
    }

    public void resetArray()
    {
        int h = _size.height;
        int w = _size.width;
        _values = new Object[w][h];
        _rowHeaders = new Object[h];
        _columnHeaders = new Object[w];
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Object getValueAt(int xx, int yy)
    {
        return _values[xx][yy];
    }

    public void setValueAt(int xx, int yy, Object value)
    {
        _values[xx][yy] = value;
    }

    @Override
    public Object getRowHeaderAt(int yy)
    {
        return _rowHeaders[yy];
    }

    public void setRowHeaderAt(int yy, Object value)
    {
        _rowHeaders[yy] = value;
    }

    @Override
    public Object getColumnHeaderAt(int xx)
    {
        return _columnHeaders[xx];
    }

    public void setColumnHeaderAt(int xx, Object value)
    {
        _columnHeaders[xx] = value;
    }

}
