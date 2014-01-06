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

package com.kodemore.awt.graph;

import com.kodemore.collection.KmList;

public class KmaGraph
{
    //##################################################
    //# variables
    //##################################################

    private KmaGraphStyledText        _title;

    private KmList<KmaGraphElementIF> _preGridLeftElements;
    private KmList<KmaGraphElementIF> _preGridRightElements;
    private KmList<KmaGraphElementIF> _postGridLeftElements;
    private KmList<KmaGraphElementIF> _postGridRightElements;

    private KmaGraphAxis              _leftAxis;
    private KmaGraphAxis              _rightAxis;
    private KmaGraphAxis              _bottomAxis;

    private KmaGraphLineStyle         _borderStyle;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraph()
    {
        _title = new KmaGraphStyledText();
        _preGridLeftElements = new KmList<KmaGraphElementIF>();
        _preGridRightElements = new KmList<KmaGraphElementIF>();
        _postGridLeftElements = new KmList<KmaGraphElementIF>();
        _postGridRightElements = new KmList<KmaGraphElementIF>();
        _leftAxis = new KmaGraphAxis();
        _rightAxis = new KmaGraphAxis();
        _bottomAxis = new KmaGraphAxis();
        _borderStyle = new KmaGraphLineStyle();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaGraphStyledText getTitle()
    {
        return _title;
    }

    public void setTitle(KmaGraphStyledText e)
    {
        _title = e;
    }

    public KmList<KmaGraphElementIF> getPreGridLeftElements()
    {
        return _preGridLeftElements;
    }

    public void setPreGridLeftElements(KmList<KmaGraphElementIF> e)
    {
        _preGridLeftElements = e;
    }

    public KmList<KmaGraphElementIF> getPreGridRightElements()
    {
        return _preGridRightElements;
    }

    public void setPreGridRightElements(KmList<KmaGraphElementIF> e)
    {
        _preGridRightElements = e;
    }

    public KmList<KmaGraphElementIF> getPostGridLeftElements()
    {
        return _postGridLeftElements;
    }

    public void setPostGridLeftElements(KmList<KmaGraphElementIF> e)
    {
        _postGridLeftElements = e;
    }

    public KmList<KmaGraphElementIF> getPostGridRightElements()
    {
        return _postGridRightElements;
    }

    public void setPostGridRightElements(KmList<KmaGraphElementIF> e)
    {
        _postGridRightElements = e;
    }

    public KmaGraphAxis getLeftAxis()
    {
        return _leftAxis;
    }

    public void setLeftAxis(KmaGraphAxis e)
    {
        _leftAxis = e;
    }

    public KmaGraphAxis getRightAxis()
    {
        return _rightAxis;
    }

    public void setRightAxis(KmaGraphAxis e)
    {
        _rightAxis = e;
    }

    public KmaGraphAxis getBottomAxis()
    {
        return _bottomAxis;
    }

    public void setBottomAxis(KmaGraphAxis e)
    {
        _bottomAxis = e;
    }

    public KmaGraphLineStyle getBorderStyle()
    {
        return _borderStyle;
    }

    public void setBorderStyle(KmaGraphLineStyle e)
    {
        _borderStyle = e;
    }
}
