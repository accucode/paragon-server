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

package com.kodemore.servlet.control;

import java.io.Serializable;

import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

/**
 * Multiple data sets displayed together in a single bar chart.
 * The slices can be displayed either side-by-side or stacked.
 */
public class ScChartMargin
    implements Serializable
{
    //##################################################
    //# variables
    //##################################################

    private Integer _left;
    private Integer _right;
    private Integer _top;
    private Integer _bottom;

    //##################################################
    //# left
    //##################################################

    public Integer getLeft()
    {
        return _left;
    }

    public void setLeft(Integer e)
    {
        _left = e;
    }

    public boolean hasLeft()
    {
        return _left != null;
    }

    public void addLeft(Integer e)
    {
        _left = hasLeft()
            ? _left + e
            : e;
    }

    //##################################################
    //# right
    //##################################################

    public Integer getRight()
    {
        return _right;
    }

    public void setRight(Integer e)
    {
        _right = e;
    }

    public boolean hasRight()
    {
        return _right != null;
    }

    public void addRight(Integer e)
    {
        _right = hasRight()
            ? _right + e
            : e;
    }

    //##################################################
    //# top
    //##################################################

    public Integer getTop()
    {
        return _top;
    }

    public void setTop(Integer e)
    {
        _top = e;
    }

    public boolean hasTop()
    {
        return _top != null;
    }

    public void addTop(Integer e)
    {
        _top = hasTop()
            ? _top + e
            : e;
    }

    //##################################################
    //# bottom
    //##################################################

    public Integer getBottom()
    {
        return _bottom;
    }

    public void setBottom(Integer e)
    {
        _bottom = e;
    }

    public boolean hasBottom()
    {
        return _bottom != null;
    }

    public void addBottom(Integer e)
    {
        _bottom = hasBottom()
            ? _bottom + e
            : e;
    }

    //##################################################
    //# conversion
    //##################################################

    public KmJsonMap toJson()
    {
        KmJsonMap e;
        e = new KmJsonMap();

        if ( hasLeft() )
            e.setInteger("left", getLeft());

        if ( hasRight() )
            e.setInteger("right", getRight());

        if ( hasTop() )
            e.setInteger("top", getTop());

        if ( hasBottom() )
            e.setInteger("bottom", getBottom());

        return e;
    }

    //##################################################
    //# copy
    //##################################################

    public ScChartMargin getCopy()
    {
        return Kmu.getSerializedCopy(this);
    }

}
