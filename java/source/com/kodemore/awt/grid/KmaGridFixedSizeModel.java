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

public class KmaGridFixedSizeModel
    extends KmaGridAbstractSizeModel
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridFixedSizeModel create(KmaGrid g, int i)
    {
        KmaGridFixedSizeModel m;
        m = new KmaGridFixedSizeModel();
        m.setGrid(g);
        m.setSize(i);
        return m;
    }

    //##################################################
    //# variables
    //##################################################

    private int _size;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridFixedSizeModel()
    {
        _size = 100;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getSize()
    {
        return _size;
    }

    public void setSize(int i)
    {
        _size = i;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public int getSizeAt(int i)
    {
        return getSize();
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
