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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.Collection;
import java.util.Iterator;

/**
 * Provide a more convenient interface.
 * In particular provide better scaling and translation support.
 * Using the normal translation and scaling features of Graphics
 * means that there is no good way to position and draw text.
 * Also, setting the scaling factors of Graphics affect the line
 * thicknesses and such which is usually not desired.
 */
public class KmaGraphics
{
    //##################################################
    //# variables
    //##################################################

    private Graphics2D _graphics;

    private double     _scaleX;
    private double     _scaleY;
    private double     _translationX;
    private double     _translationY;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphics()
    {
        this(null);
    }

    public KmaGraphics(Graphics2D g)
    {
        _graphics = g;
        _scaleX = 1;
        _scaleY = 1;
        _translationX = 0;
        _translationY = 0;
    }

    //##################################################
    //# accessing
    //##################################################

    public Graphics2D getGraphics()
    {
        return _graphics;
    }

    public void setGraphics(Graphics2D e)
    {
        _graphics = e;
    }

    //##################################################
    //# scale
    //##################################################

    public double getScaleX()
    {
        return _scaleX;
    }

    public void setScaleX(double e)
    {
        if ( e == 0 )
            throw new RuntimeException("Cannot set x scale to 0.");

        _scaleX = e;
    }

    public double getScaleY()
    {
        return _scaleY;
    }

    public void setScaleY(double e)
    {
        _scaleY = e;
    }

    public void setScale(double x, double y)
    {
        if ( x == 0 )
            throw new RuntimeException("Cannot set x scale to 0.");

        _scaleX = x;
        _scaleY = y;
    }

    /**
     * This method will preserve the physical location of the
     * origin (0,0) by adjusting the translation.
     */
    public void scale(double dx, double dy)
    {
        _scaleX /= dx;
        _scaleY /= dy;
        _translationX /= dx;
        _translationY /= dy;
    }

    //##################################################
    //# translation
    //##################################################

    public double getTranslationX()
    {
        return _translationX;
    }

    public void setTranslationX(double e)
    {
        _translationX = e;
    }

    public double getTranslationY()
    {
        return _translationY;
    }

    public void setTranslationY(double e)
    {
        _translationY = e;
    }

    public void setTranslation(double x, double y)
    {
        _translationX = x;
        _translationY = y;
    }

    public void translate(double dx, double dy)
    {
        _translationX -= dx;
        _translationY -= dy;
    }

    //##################################################
    //# draw
    //##################################################

    public void drawPoint(double x, double y, int r)
    {
        int xx = xToPhysical(x);
        int yy = yToPhysical(y);
        _graphics.drawOval(xx - r / 2, yy - r / 2, xx + r / 2 + 1, yy + r / 2 + 1);
    }

    public void drawPoint(double x, double y)
    {
        int xx = xToPhysical(x);
        int yy = yToPhysical(y);
        _graphics.drawOval(xx, yy, xx, yy);
    }

    public void drawString(String s, double x, double y)
    {
        int xx = xToPhysical(x);
        int yy = yToPhysical(y);
        _graphics.drawString(s, xx, yy);
    }

    public void drawLine(double x1, double y1, double x2, double y2)
    {
        int xx1 = xToPhysical(x1);
        int xx2 = xToPhysical(x2);
        int yy1 = yToPhysical(y1);
        int yy2 = yToPhysical(y2);
        Line2D e = new Line2D.Double(xx1, yy1, xx2, yy2);
        _graphics.draw(e);
    }

    public void drawPath(Collection<KmaGraphPoint> v)
    {
        GeneralPath gp = _newGeneralPath(v);
        _graphics.draw(gp);
    }

    //##################################################
    //# conversion
    //##################################################

    public int xToPhysical(double x)
    {
        return (int)Math.round((x - _translationX) / _scaleX);
    }

    public double xToLogical(int x)
    {
        return x * _scaleX + _translationX;
    }

    public int yToPhysical(double y)
    {
        return (int)Math.round((y - _translationY) / _scaleY);
    }

    public double yToLogical(int y)
    {
        return y * _scaleY + _translationY;
    }

    //##################################################
    //# delegation
    //##################################################

    public FontMetrics getFontMetrics(Font f)
    {
        return _graphics.getFontMetrics(f);
    }

    public void fillPhysical(Shape e)
    {
        _graphics.fill(e);
    }

    public void drawPhysical(Shape e)
    {
        _graphics.draw(e);
    }

    public void drawPhysical(KmaGraphPixelBounds e)
    {
        int x1 = e.getLeft();
        int x2 = e.getRight();
        int y1 = e.getBottom();
        int y2 = e.getTop();

        drawPhysicalLine(x1, y1, x2, y1);
        drawPhysicalLine(x1, y2, x2, y2);
        drawPhysicalLine(x1, y1, x1, y2);
        drawPhysicalLine(x2, y1, x2, y2);
    }

    public void drawPhysicalLine(int x1, int y1, int x2, int y2)
    {
        _graphics.drawLine(x1, y1, x2, y2);
    }

    public void setFont(Font f)
    {
        _graphics.setFont(f);
    }

    public void setStroke(Stroke s)
    {
        _graphics.setStroke(s);
    }

    public void setStroke(double w)
    {
        BasicStroke s = new BasicStroke((float)w);
        setStroke(s);
    }

    //##################################################
    //# color
    //##################################################

    public void setColor(Color c)
    {
        _graphics.setColor(c);
    }

    public void setRed()
    {
        setColor(Color.red);
    }

    public void setBlue()
    {
        setColor(Color.blue);
    }

    public void setCyan()
    {
        setColor(Color.cyan);
    }

    public void setGray()
    {
        setColor(Color.gray);
    }

    public void setLightGray()
    {
        setColor(Color.lightGray);
    }

    public void setGreen()
    {
        setColor(Color.green);
    }

    public void setYellow()
    {
        setColor(Color.yellow);
    }

    public void setBlack()
    {
        setColor(Color.black);
    }

    public void setWhite()
    {
        setColor(Color.white);
    }

    //##################################################
    //# copy
    //##################################################

    public KmaGraphics getCopy()
    {
        KmaGraphics g;
        g = new KmaGraphics();
        g.setScale(_scaleX, _scaleY);
        g.setTranslation(_translationX, _translationY);
        g.setGraphics((Graphics2D)_graphics.create());
        return g;
    }

    //##################################################
    //# private
    //##################################################

    public GeneralPath _newGeneralPath(Collection<KmaGraphPoint> v)
    {
        GeneralPath gp = null;

        Iterator<KmaGraphPoint> i = v.iterator();
        while ( i.hasNext() )
        {
            KmaGraphPoint p = i.next();
            double x = p.getX();
            double y = p.getY();
            int xx = xToPhysical(x);
            int yy = yToPhysical(y);

            if ( gp == null )
            {
                gp = new GeneralPath();
                gp.moveTo(xx, yy);
            }
            else
                gp.lineTo(xx, yy);
        }

        return gp;
    }

}
