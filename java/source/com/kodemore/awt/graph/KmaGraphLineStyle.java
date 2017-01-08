/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

public class KmaGraphLineStyle
{
    //##################################################
    //# variables
    //##################################################

    private boolean  _visible;
    private Color    _color;
    private double[] _dashes;
    private double   _thickness;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphLineStyle()
    {
        _visible = true;
        _color = Color.black;
        _dashes = null;
        _thickness = 1;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean isVisible()
    {
        return _visible;
    }

    public boolean isHidden()
    {
        return !isVisible();
    }

    public void setVisible(boolean e)
    {
        _visible = e;
    }

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color e)
    {
        _color = e;
    }

    public double[] getDashes()
    {
        return _dashes;
    }

    public float[] getFloatDashes()
    {
        if ( _dashes == null )
            return null;

        int n = _dashes.length;
        float[] arr = new float[n];

        for ( int i = 0; i < n; i++ )
            arr[i] = (float)_dashes[i];

        return arr;
    }

    public void setDashes(double[] e)
    {
        _dashes = e;
    }

    public double getThickness()
    {
        return _thickness;
    }

    public void setThickness(double e)
    {
        _thickness = e;
    }

    //##################################################
    //# graphics
    //##################################################

    public void applyTo(KmaGraphics g)
    {
        if ( !isVisible() )
            return;

        g.setColor(getColor());
        g.setStroke(getStroke());
    }

    public Stroke getStroke()
    {
        if ( _dashes == null )
            return new BasicStroke((float)_thickness);

        float miterLimit = 1.0f;
        float dashPhase = 0.0f;

        return new BasicStroke(
            (float)_thickness,
            BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND,
            miterLimit,
            getFloatDashes(),
            dashPhase);
    }

}
