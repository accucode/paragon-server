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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import com.kodemore.awt.KmaFrame;
import com.kodemore.collection.KmList;

public class KmaGraphPainter
{
    //##################################################
    //# constants
    //##################################################

    private static boolean      DEBUG_OUTLINE = false;

    //##################################################
    //# variables
    //##################################################

    private KmaGraph            _graph;

    private Color               _backgroundColor;

    private Rectangle           _bounds;
    private Insets              _margin;

    private KmaGraphPixelBounds _topBounds;
    private KmaGraphPixelBounds _leftBounds;
    private KmaGraphPixelBounds _rightBounds;
    private KmaGraphPixelBounds _bottomBounds;
    private KmaGraphPixelBounds _gridBounds;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphPainter()
    {
        _graph = new KmaGraph();
        _bounds = new Rectangle(0, 0, 200, 200);
        _margin = new Insets(25, 25, 25, 25);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaGraph getGraph()
    {
        return _graph;
    }

    public void setGraph(KmaGraph e)
    {
        _graph = e;
    }

    public Color getBackgroundColor()
    {
        return _backgroundColor;
    }

    public void setBackgroundColor(Color e)
    {
        _backgroundColor = e;
    }

    public boolean hasBackgroundColor()
    {
        return _backgroundColor != null;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmaGraphPixelBounds getTopBounds(KmaGraphics g)
    {
        if ( _topBounds == null )
            _topBounds = computeTopBounds(g);
        return _topBounds;
    }

    public KmaGraphPixelBounds getLeftBounds(KmaGraphics g)
    {
        if ( _leftBounds == null )
            _leftBounds = computeLeftBounds(g);
        return _leftBounds;
    }

    public KmaGraphPixelBounds getRightBounds(KmaGraphics g)
    {
        if ( _rightBounds == null )
            _rightBounds = computeRightBounds(g);
        return _rightBounds;
    }

    public KmaGraphPixelBounds getBottomBounds(KmaGraphics g)
    {
        if ( _bottomBounds == null )
            _bottomBounds = computeBottomBounds(g);
        return _bottomBounds;
    }

    public KmaGraphPixelBounds getGridBounds(KmaGraphics g)
    {
        if ( _gridBounds == null )
            _gridBounds = computeGridBounds(g);
        return _gridBounds;
    }

    //##################################################
    //# setup
    //##################################################

    public Rectangle getBounds()
    {
        return _bounds;
    }

    public Rectangle getBoundsCopy()
    {
        return (Rectangle)getBounds().clone();
    }

    public void setBounds(Rectangle e)
    {
        _bounds = e;
        _resetBounds();
    }

    public Insets getMargin()
    {
        return _margin;
    }

    public void setMargin(Insets e)
    {
        _margin = e;
        _resetBounds();
    }

    public void _resetBounds()
    {
        _leftBounds = null;
        _rightBounds = null;
        _bottomBounds = null;
        _topBounds = null;
        _gridBounds = null;
    }

    //##################################################
    //# compute margin
    //##################################################

    public void computeMargin()
    {
        BufferedImage i = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        KmaGraphics g = new KmaGraphics(i.createGraphics());
        computeMargin(g);
    }

    public void computeMargin(KmaGraphics g)
    {
        _margin = new Insets(
            computeTopMargin(g),
            computeLeftMargin(g),
            computeBottomMargin(g),
            computeRightMargin(g));
    }

    public int computeTopMargin(KmaGraphics g)
    {
        if ( !getGraph().getTitle().getStyle().isVisible() )
            return 0;
        Font f = getGraph().getTitle().getStyle().getFont().getFont();
        FontMetrics fm = g.getFontMetrics(f);
        return fm.getHeight();
    }

    public int computeBottomMargin(KmaGraphics g)
    {
        KmaGraphAxis a = getGraph().getBottomAxis();
        if ( !a.isVisible() )
            return 0;

        Font f;
        FontMetrics fm;
        int h = 0;

        f = a.getTitle().getStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        h += fm.getHeight();

        f = a.getLabelStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        h += fm.getHeight();

        return h;
    }

    public int computeLeftMargin(KmaGraphics g)
    {
        KmaGraphAxis a = getGraph().getLeftAxis();
        if ( !a.isVisible() )
            return 0;

        Font f;
        FontMetrics fm;
        String s;
        double d;
        int w = 0;

        f = a.getTitle().getStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        s = a.getTitle().getText();
        w += fm.stringWidth(s + "w");

        f = getGraph().getLeftAxis().getLabelStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        d = a.getMaximum();
        s = a.getLabelStyle().format(d);
        w += fm.stringWidth(s + "w");

        return w;
    }

    public int computeRightMargin(KmaGraphics g)
    {
        KmaGraphAxis a = getGraph().getRightAxis();
        if ( !a.isVisible() )
            return 0;

        Font f;
        FontMetrics fm;
        String s;
        double d;
        int w = 0;

        f = a.getTitle().getStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        s = a.getTitle().getText();
        w += fm.stringWidth(s + "w");

        f = a.getLabelStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        d = a.getMaximum();
        s = a.getLabelStyle().format(d);
        w += fm.stringWidth(s + "w");

        return w;
    }

    //##################################################
    //# compute bounds
    //##################################################

    public KmaGraphPixelBounds computeTopBounds(KmaGraphics g)
    {
        int x = _bounds.x + _margin.left;
        int y = _bounds.y;
        int w = _bounds.width - _margin.left - _margin.right;
        int h = _margin.top;
        return new KmaGraphPixelBounds(x, y, w, h);
    }

    public KmaGraphPixelBounds computeBottomBounds(KmaGraphics g)
    {
        int x = _bounds.x + _margin.left;
        int y = _bounds.y + _bounds.height - _margin.bottom;
        int w = _bounds.width - _margin.left - _margin.right;
        int h = _margin.bottom;
        return new KmaGraphPixelBounds(x, y, w, h);
    }

    public KmaGraphPixelBounds computeLeftBounds(KmaGraphics g)
    {
        int x = _bounds.x;
        int y = _bounds.y + _margin.top;
        int w = _margin.left;
        int h = _bounds.height - _margin.top - _margin.bottom;
        return new KmaGraphPixelBounds(x, y, w, h);
    }

    public KmaGraphPixelBounds computeRightBounds(KmaGraphics g)
    {
        int x = _bounds.x + _bounds.width - _margin.right;
        int y = _bounds.y + _margin.top;
        int w = _margin.right;
        int h = _bounds.height - _margin.top - _margin.bottom;
        return new KmaGraphPixelBounds(x, y, w, h);
    }

    public KmaGraphPixelBounds computeGridBounds(KmaGraphics g)
    {
        int x = _bounds.x + _margin.left;
        int y = _bounds.y + _margin.top;
        int w = _bounds.width - _margin.left - _margin.right;
        int h = _bounds.height - _margin.top - _margin.bottom;
        return new KmaGraphPixelBounds(x, y, w, h);
    }

    //##################################################
    //# paint
    //##################################################

    public void paintOn(Graphics2D g)
    {
        KmaGraphics gg = new KmaGraphics();
        gg.setGraphics(g);
        paintOn(gg);
    }

    public void paintOn(KmaGraphics g)
    {
        draw(g);
    }

    public void draw(KmaGraphics g)
    {
        g = g.getCopy();

        computeAutoUnits();
        clearClientArea(g);
        drawTitle(g);
        drawBottomAxis(g);
        drawLeftAxis(g);
        drawRightAxis(g);
        drawPreGrid(g);
        drawGrid(g);
        drawPostGrid(g);
    }

    public void clearClientArea(KmaGraphics g)
    {
        Color c = getBackgroundColor();
        if ( c == null )
            return;
        g.setColor(c);
        g.fillPhysical(getBounds());
    }

    public void drawTitle(KmaGraphics g)
    {
        if ( DEBUG_OUTLINE )
        {
            g.setStroke(1);
            g.setRed();
            g.drawPhysical(getTopBounds(g));
            return;
        }

        KmaGraphStyledText st = getGraph().getTitle();
        KmaGraphTextStyle ts = st.getStyle();

        if ( !ts.isVisible() )
            return;
        Font f = ts.getFont().getFont();
        FontMetrics fm = g.getFontMetrics(f);
        String s = st.getText();
        int sw = fm.stringWidth(s);
        int a = fm.getAscent();
        KmaGraphPixelBounds b = getTopBounds(g);
        int x = b.getLeft() + (b.getWidth() - sw) / 2;
        int y = b.getBottom() + a - 1;
        ts.applyTo(g);
        g.drawString(s, x, y);
    }

    public void drawBottomAxis(KmaGraphics g)
    {
        if ( DEBUG_OUTLINE )
        {
            g.setStroke(1);
            g.setCyan();
            g.drawPhysical(getBottomBounds(g));
            return;
        }

        g = g.getCopy();

        KmaGraphAxis a = getGraph().getBottomAxis();
        KmaGraphPixelBounds b = getBottomBounds(g);
        KmaGraphStyledText st = a.getTitle();
        KmaGraphTextStyle ts = st.getStyle();
        Font f = ts.getFont().getFont();
        FontMetrics fm = g.getFontMetrics(f);
        String s = st.getText();
        int sw = fm.stringWidth(s);
        double x = b.getLeft() + (b.getWidth() - sw) / 2;
        double y = b.getBottom() + b.getHeight() - fm.getDescent() - 1;
        ts.applyTo(g);
        g.drawString(s, x, y);

        a.getLabelStyle().applyTo(g);
        f = a.getLabelStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        y = b.getBottom() + fm.getLeading() + fm.getAscent();

        applyBottomScale(g);

        double min = a.getMinimum();
        double max = a.getMaximum();
        double step = a.getMajorUnits();
        for ( x = min; x <= max; x += step )
        {
            if ( !a.isLabelVisible(x) )
                continue;
            s = a.getLabelStyle().format(x);
            sw = fm.stringWidth(s);
            int xx = g.xToPhysical(x) - sw / 2;
            g.getGraphics().drawString(s, xx, (int)y);
        }
    }

    public void drawLeftAxis(KmaGraphics g)
    {
        if ( DEBUG_OUTLINE )
        {
            g.setStroke(1);
            g.setGreen();
            g.drawPhysical(getLeftBounds(g));
            return;
        }

        g = g.getCopy();

        KmaGraphAxis a = getGraph().getLeftAxis();
        KmaGraphPixelBounds b = getLeftBounds(g);
        KmaGraphStyledText st = a.getTitle();
        KmaGraphTextStyle ts = st.getStyle();
        Font f = ts.getFont().getFont();
        FontMetrics fm = g.getFontMetrics(f);
        String s = st.getText();
        double x = b.getLeft();
        double y = b.getBottom() + b.getHeight() / 2;
        ts.applyTo(g);
        g.drawString(s, x, y);

        a.getLabelStyle().applyTo(g);
        f = a.getLabelStyle().getFont().getFont();
        fm = g.getFontMetrics(f);
        x = b.getLeft() + b.getWidth();

        applyLeftScale(g);

        double min = a.getMinimum();
        double max = a.getMaximum();
        double step = a.getMajorUnits();
        for ( y = min; y <= max; y += step )
        {
            if ( !a.isLabelVisible(y) )
                continue;
            s = a.getLabelStyle().format(y);
            int sw = fm.stringWidth(s);
            int yy = g.yToPhysical(y) + (fm.getDescent() + fm.getAscent()) / 3;
            g.getGraphics().drawString(s, (int)(x - sw), yy);
        }
    }

    public void drawRightAxis(KmaGraphics g)
    {
        if ( DEBUG_OUTLINE )
        {
            g.setStroke(1);
            g.setYellow();
            g.drawPhysical(getRightBounds(g));
            return;
        }

        g = g.getCopy();

        KmaGraphAxis a = getGraph().getRightAxis();
        KmaGraphPixelBounds b = getRightBounds(g);
        KmaGraphStyledText st = a.getTitle();
        KmaGraphTextStyle ts = st.getStyle();
        Font f = ts.getFont().getFont();
        FontMetrics fm = g.getFontMetrics(f);
        String s = st.getText();
        int sw = fm.stringWidth(s);
        double x = b.getLeft() + b.getWidth() - sw;
        double y = b.getBottom() + b.getHeight() / 2;
        ts.applyTo(g);
        g.drawString(s, x, y);

        a.getLabelStyle().applyTo(g);
        f = a.getLabelStyle().getFont().getFont();
        fm = g.getFontMetrics(f);

        applyRightScale(g);

        double min = a.getMinimum();
        double max = a.getMaximum();
        double step = a.getMajorUnits();
        x = b.getLeft() + 1;
        for ( y = min; y <= max; y += step )
        {
            if ( !a.isLabelVisible(y) )
                continue;
            s = a.getLabelStyle().format(y);
            int yy = g.yToPhysical(y) + (fm.getDescent() + fm.getAscent()) / 3;
            g.getGraphics().drawString(s, (int)x, yy);
        }
    }

    public void drawGrid(KmaGraphics g)
    {
        if ( DEBUG_OUTLINE )
        {
            g.setStroke(1);
            g.setBlack();
            g.drawPhysical(getGridBounds(g));
            return;
        }
        drawBottomLeftGrid(g);
    }

    public void drawBottomLeftGrid(KmaGraphics g)
    {
        g = g.getCopy();
        applyLeftScale(g);
        applyBottomScale(g);

        double min, max, step;
        double x, x1, x2;
        double y, y1, y2;

        KmaGraphAxis bottom = getGraph().getBottomAxis();
        KmaGraphAxis left = getGraph().getLeftAxis();

        step = bottom.getMinorUnits();
        min = bottom.getMinimum() + step;
        max = bottom.getMaximum();
        y1 = left.getMinimum();
        y2 = left.getMaximum();
        bottom.getMinorLineStyle().applyTo(g);
        for ( x = min; x < max; x += step )
            g.drawLine(x, y1, x, y2);

        step = left.getMinorUnits();
        min = left.getMinimum() + step;
        max = left.getMaximum();
        x1 = bottom.getMinimum();
        x2 = bottom.getMaximum();
        left.getMinorLineStyle().applyTo(g);
        for ( y = min; y < max; y += step )
            g.drawLine(x1, y, x2, y);

        step = bottom.getMajorUnits();
        min = bottom.getMinimum() + step;
        max = bottom.getMaximum();
        y1 = left.getMinimum();
        y2 = left.getMaximum();
        bottom.getMajorLineStyle().applyTo(g);
        for ( x = min; x < max; x += step )
            g.drawLine(x, y1, x, y2);

        step = left.getMajorUnits();
        min = left.getMinimum() + step;
        max = left.getMaximum();
        x1 = bottom.getMinimum();
        x2 = bottom.getMaximum();
        left.getMajorLineStyle().applyTo(g);
        for ( y = min; y < max; y += step )
            g.drawLine(x1, y, x2, y);

        getGraph().getBorderStyle().applyTo(g);
        g.drawLine(bottom.getMinimum(), left.getMinimum(), bottom.getMaximum(), left.getMinimum());
        g.drawLine(bottom.getMinimum(), left.getMaximum(), bottom.getMaximum(), left.getMaximum());
        g.drawLine(bottom.getMinimum(), left.getMinimum(), bottom.getMinimum(), left.getMaximum());
        g.drawLine(bottom.getMaximum(), left.getMinimum(), bottom.getMaximum(), left.getMaximum());
    }

    public void drawPreGrid(KmaGraphics g)
    {
        // ignored
    }

    public void drawPostGrid(KmaGraphics g)
    {
        drawPostGridLeft(g);
        drawPostGridRight(g);
    }

    public void drawPostGridLeft(KmaGraphics g)
    {
        g = g.getCopy();
        applyBottomScale(g);
        applyLeftScale(g);
        Iterator<KmaGraphElementIF> i = getGraph().getPostGridLeftElements().iterator();
        while ( i.hasNext() )
        {
            KmaGraphElementIF e = i.next();
            e.drawOn(g);
        }
    }

    public void drawPostGridRight(KmaGraphics g)
    {
        g = g.getCopy();
        applyBottomScale(g);
        applyRightScale(g);
        Iterator<KmaGraphElementIF> i = getGraph().getPostGridRightElements().iterator();
        while ( i.hasNext() )
        {
            KmaGraphElementIF e = i.next();
            e.drawOn(g);
        }
    }

    //##################################################
    //# auto units
    //##################################################

    public void computeAutoUnits()
    {
        computeBottomAutoUnits();
        computeLeftAutoUnits();
        computeRightAutoUnits();
    }

    public int getMaximumAutoUnits()
    {
        return 10;
    }

    public KmList<KmaGraphElementIF> getAllElements()
    {
        KmList<KmaGraphElementIF> v;
        v = new KmList<KmaGraphElementIF>();
        v.addAll(getLeftElements());
        v.addAll(getRightElements());
        return v;
    }

    public KmaGraphBounds getAllBounds()
    {
        return getBounds(getAllElements());
    }

    public double getMinimumBottom()
    {
        return getAllBounds().getLeft();
    }

    public double getMaximumBottom()
    {
        return getAllBounds().getRight();
    }

    public KmList<KmaGraphElementIF> getLeftElements()
    {
        KmList<KmaGraphElementIF> v;
        v = new KmList<KmaGraphElementIF>();
        v.addAll(getGraph().getPreGridLeftElements());
        v.addAll(getGraph().getPostGridLeftElements());
        return v;
    }

    public KmaGraphBounds getLeftBounds()
    {
        return getBounds(getLeftElements());
    }

    public double getMinimumLeft()
    {
        return getLeftBounds().getBottom();
    }

    public double getMaximumLeft()
    {
        return getLeftBounds().getTop();
    }

    public KmList<KmaGraphElementIF> getRightElements()
    {
        KmList<KmaGraphElementIF> v;
        v = new KmList<KmaGraphElementIF>();
        v.addAll(getGraph().getPreGridRightElements());
        v.addAll(getGraph().getPostGridRightElements());
        return v;
    }

    public KmaGraphBounds getRightBounds()
    {
        return getBounds(getRightElements());
    }

    public double getMinimumRight()
    {
        return getRightBounds().getBottom();
    }

    public double getMaximumRight()
    {
        return getRightBounds().getTop();
    }

    //##################################################
    //# utility
    //##################################################

    public Rectangle2D newRectangle(Rectangle2D r)
    {
        return new Rectangle2D.Double(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    public KmaGraphBounds getBounds(KmList<KmaGraphElementIF> v)
    {
        KmaGraphBounds b = new KmaGraphBounds();
        Iterator<KmaGraphElementIF> i = v.iterator();
        while ( i.hasNext() )
            b.add(i.next().getBounds());
        return b;
    }

    //##################################################
    //# auto units
    //##################################################

    public void computeBottomAutoUnits()
    {
        KmaGraphAutoScaler e = new KmaGraphAutoScaler();
        e.setMinimum(getMinimumBottom());
        e.setMaximum(getMaximumBottom());
        e.setMaximumDivisions(getMaximumAutoUnits());
        e.computeAutoUnits();
        KmaGraphAxis a = getGraph().getBottomAxis();
        a.setMinimum(e.getLower());
        a.setMaximum(e.getUpper());
        a.setMajorUnits(e.getMajorUnit());
        a.setMinorUnits(e.getMinorUnit());
    }

    public void computeLeftAutoUnits()
    {
        KmaGraphAutoScaler e = new KmaGraphAutoScaler();
        e.setMinimum(getMinimumLeft());
        e.setMaximum(getMaximumLeft());
        e.setMaximumDivisions(getMaximumAutoUnits());
        e.computeAutoUnits();
        KmaGraphAxis a = getGraph().getLeftAxis();
        a.setMinimum(e.getLower());
        a.setMaximum(e.getUpper());
        a.setMajorUnits(e.getMajorUnit());
        a.setMinorUnits(e.getMinorUnit());
    }

    public void computeRightAutoUnits()
    {
        KmaGraphAutoScaler e = new KmaGraphAutoScaler();
        e.setMinimum(getMinimumRight());
        e.setMaximum(getMaximumRight());
        e.setMaximumDivisions(getMaximumAutoUnits());
        e.computeAutoUnits();
        KmaGraphAxis a = getGraph().getRightAxis();
        a.setMinimum(e.getLower());
        a.setMaximum(e.getUpper());
        a.setMajorUnits(e.getMajorUnit());
        a.setMinorUnits(e.getMinorUnit());

        a.setMaximum(100);
        a.setMajorUnits(10);
        a.setMinorUnits(2);
        a.setMinimum(100 - getGraph().getLeftAxis().getMajorDivisions() * 10);
        a.setMaximumLabel(90);
        a.setMinimumLabel(50);
    }

    //##################################################
    //# scaling
    //##################################################

    public void applyHorizontalScale(KmaGraphics g)
    {
        g.translate(getGridBounds(g).getLeft(), 0);
    }

    public void applyVerticalScale(KmaGraphics g)
    {
        g.translate(0, getGridBounds(g).getTop());
        g.scale(1, -1);
    }

    public void applyBottomScale(KmaGraphics g)
    {
        KmaGraphAxis a = getGraph().getBottomAxis();
        double min = a.getMinimum();
        double max = a.getMaximum();
        double pixels = getGridBounds(g).getWidth();
        double range = max - min;
        double scale = pixels / range;
        applyHorizontalScale(g);
        g.scale(scale, 1);
        g.translate(-min, 0);
    }

    public void applyLeftScale(KmaGraphics g)
    {
        KmaGraphAxis a = getGraph().getLeftAxis();
        double min = a.getMinimum();
        double max = a.getMaximum();
        double pixels = getGridBounds(g).getHeight();
        double range = max - min;
        double scale = pixels / range;

        applyVerticalScale(g);
        g.scale(1, scale);
        g.translate(0, -min);
    }

    public void applyRightScale(KmaGraphics g)
    {
        KmaGraphAxis a = getGraph().getRightAxis();
        double min = a.getMinimum();
        double max = a.getMaximum();
        double yPixels = getGridBounds(g).getHeight();
        double yRange = max - min;
        double scale = yPixels / yRange;
        applyVerticalScale(g);
        g.scale(1, scale);
        g.translate(0, -min);
    }

    //##################################################
    //# utility
    //##################################################

    public void setSmoothStroke(KmaGraphics g, double w)
    {
        BasicStroke s = new BasicStroke((float)w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g.setStroke(s);
    }

    public void setSmoothDashedStroke(KmaGraphics g, double w)
    {
        float miterLimit = 1.0f;
        float dashArray[] =
                    {
            8.0f,
            6.0f
                    };
        float dashPhase = 0.0f;
        BasicStroke s = new BasicStroke(
            (float)w,
            BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND,
            miterLimit,
            dashArray,
            dashPhase);
        g.setStroke(s);
    }

    public void setDashStroke(KmaGraphics g, double w)
    {
        float miterLimit = 1.0f;
        float dashArray[] =
                    {
            1.0f,
            2.0f
                    };
        float dashPhase = 0.0f;
        BasicStroke s = new BasicStroke(
            (float)w,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_BEVEL,
            miterLimit,
            dashArray,
            dashPhase);
        g.setStroke(s);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmaGraphPanel p = new KmaGraphPanel();
        KmaGraph g = p.getPainter().getGraph();
        KmaGraphAxis left = g.getLeftAxis();
        KmaGraphAxis right = g.getRightAxis();
        KmaGraphAxis bottom = g.getBottomAxis();

        g.getTitle().setText("Title");
        g.getTitle().getStyle().getFont().setSize(24);

        bottom.getTitle().setText("bottom");
        bottom.getTitle().getStyle().getFont().setSize(12);
        bottom.getTitle().getStyle().getFont().beBold();
        bottom.getMinorLineStyle().setColor(Color.lightGray);
        bottom.getMajorLineStyle().setColor(Color.gray);

        left.getTitle().setText("left");
        left.getTitle().getStyle().getFont().setSize(12);
        left.getTitle().getStyle().getFont().beBold();
        left.getLabelStyle().getFont().setSize(10);
        left.getMinorLineStyle().setColor(Color.lightGray);
        left.getMajorLineStyle().setColor(Color.gray);

        right.getTitle().setText("right");
        right.getTitle().getStyle().getFont().setSize(12);
        right.getTitle().getStyle().getFont().beBold();

        p.getPainter().computeMargin();

        KmaGraphPathElement pe;
        pe = new KmaGraphPathElement();
        pe.getLineStyle().setColor(Color.red);
        pe.getLineStyle().setThickness(1);
        pe.addPoint(0, 0);
        pe.addPoint(0, 10);
        pe.addPoint(10, 0);
        pe.addPoint(0, 0);
        pe.addPoint(90, 90);
        p.getPainter().getGraph().getPostGridLeftElements().add(pe);

        pe = new KmaGraphPathElement();
        pe.getLineStyle().setColor(Color.blue);
        pe.getLineStyle().setThickness(1);
        pe.addPoint(50, 70);
        pe.addPoint(60, 75);
        pe.addPoint(80, 78);
        pe.addPoint(90, 60);
        p.getPainter().getGraph().getPostGridRightElements().add(pe);

        KmaFrame f;
        f = new KmaFrame();
        f.setBounds(100, 100, 600, 400);
        f.exitOnClose();
        f.installSingleComponent(p);
        f.setVisible(true);
    }

    //            if ( upper >= GPM_FORMAT_LIMIT )
    //            {
    //                int places = 0;
    //                if ( step < 1000 ) places = 1;
    //                if ( step < 100 ) places = 2;
    //                s = Kmu.formatDouble(gpm / 1000.0, places);
    //            }

}
