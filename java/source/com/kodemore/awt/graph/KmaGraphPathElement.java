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

package com.kodemore.awt.graph;

import java.util.Iterator;

import com.kodemore.collection.KmList;

public class KmaGraphPathElement
    implements KmaGraphElementIF
{
    //##################################################
    //# variables
    //##################################################

    private KmaGraphLineStyle     _lineStyle;
    private KmList<KmaGraphPoint> _points;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphPathElement()
    {
        _lineStyle = new KmaGraphLineStyle();
        _points = new KmList<KmaGraphPoint>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaGraphLineStyle getLineStyle()
    {
        return _lineStyle;
    }

    public void setLineStyle(KmaGraphLineStyle e)
    {
        _lineStyle = e;
    }

    public KmList<KmaGraphPoint> getPoints()
    {
        return _points;
    }

    public void setPoints(KmList<KmaGraphPoint> e)
    {
        _points = e;
    }

    public void addPoint(double x, double y)
    {
        _points.add(new KmaGraphPoint(x, y));
    }

    public boolean hasPoints()
    {
        return !_points.isEmpty();
    }

    //##################################################
    //# graphics
    //##################################################

    @Override
    public KmaGraphBounds getBounds()
    {
        KmaGraphBounds b = new KmaGraphBounds();
        Iterator<KmaGraphPoint> i = getPoints().iterator();
        while ( i.hasNext() )
        {
            KmaGraphPoint p = i.next();
            b.add(p);
        }
        return b;
    }

    @Override
    public void drawOn(KmaGraphics g)
    {
        if ( getLineStyle().isHidden() )
            return;
        getLineStyle().applyTo(g);
        g.drawPath(_points);
    }

}
