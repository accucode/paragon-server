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

public abstract class KmaGridAbstractSizeModel
    extends KmaGridModel
    implements KmaGridSizeModelIF
{
    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public int getLastPartialFit(int i, int j, int bounds)
    {
        int z = getCellGap();
        int n = 0;

        while ( i < j )
        {
            n += getSizeAt(i);
            if ( n >= bounds )
                break;

            n += z;
            i++;
        }

        return i;
    }

    @Override
    public int getLastCompleteFit(int i, int j, int bounds)
    {
        int z = i;
        int n = 0;
        int dn = getCellGap();

        while ( i < j )
        {
            n += getSizeAt(i);
            if ( n >= bounds )
                break;

            n += dn;
            i++;
        }

        if ( n > bounds )
            i--;

        if ( i < z )
            return -1;

        return i;
    }

    @Override
    public int getRangeSize(int i, int j)
    {
        int n = 0;

        while ( i <= j )
        {
            n += getSizeAt(i);
            i++;
        }

        return n;
    }

}
