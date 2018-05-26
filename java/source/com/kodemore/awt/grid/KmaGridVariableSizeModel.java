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

package com.kodemore.awt.grid;

import com.kodemore.collection.KmSparseArray;

public class KmaGridVariableSizeModel
    extends KmaGridAbstractSizeModel
{
    //##################################################
    //# variables
    //##################################################

    private int                    _defaultSize;
    private KmSparseArray<Integer> _sizes;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridVariableSizeModel()
    {
        _defaultSize = 50;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getDefaultSize()
    {
        return _defaultSize;
    }

    public void setDefaultSize(int i)
    {
        _defaultSize = i;
        getSizes().setDefaultValue(i);
    }

    public KmSparseArray<Integer> getSizes()
    {
        if ( _sizes == null )
            _sizes = new KmSparseArray<>();
        return _sizes;
    }

    //##################################################
    //# size model
    //##################################################

    @Override
    public int getSizeAt(int i)
    {
        int n = getDefaultSize();
        return getSizes().getValueAt(i, n);
    }

    public void setSizeAt(int i, int n)
    {
        getSizes().setValueAt(i, n);
    }

    //##################################################
    //# notification
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
