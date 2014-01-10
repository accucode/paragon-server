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

package com.kodemore.servlet.control;

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;

/**
 * I am used to 
 */
public class ScBorderLayout
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ScControl> _children;

    private int               _leftPixel;
    private int               _leftPercent;

    private int               _rightPixel;
    private int               _rightPercent;

    private int               _topPixel;
    private int               _topPercent;

    private int               _bottomPixel;
    private int               _bottomPercent;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _children = new KmList<ScControl>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<ScControl> getChildren()
    {
        return _children;
    }

    //##################################################
    //# left
    //##################################################

    public ScDiv addLeft(int px)
    {
        ScDiv e;
        e = addChild();
        e.style().width(px);

        applyTop(e);
        applyBottom(e);
        applyLeft(e);

        _leftPixel += px;
        return e;
    }

    public ScDiv addLeftPercent(int pct)
    {
        ScDiv e;
        e = addChild();
        e.style().widthPercent(pct);

        applyTop(e);
        applyBottom(e);
        applyLeft(e);

        _leftPercent += pct;
        return e;
    }

    //##################################################
    //# right
    //##################################################

    public ScDiv addRight(int px)
    {
        ScDiv e;
        e = addChild();
        e.style().width(px);

        applyTop(e);
        applyBottom(e);
        applyRight(e);

        _rightPixel += px;
        return e;
    }

    public ScDiv addRightPercent(int pct)
    {
        ScDiv e;
        e = addChild();
        e.style().widthPercent(pct);

        applyTop(e);
        applyBottom(e);
        applyRight(e);

        _rightPercent += pct;
        return e;
    }

    //##################################################
    //# top
    //##################################################

    public ScDiv addTop(int px)
    {
        ScDiv e;
        e = addChild();
        e.style().height(px);

        applyLeft(e);
        applyRight(e);
        applyTop(e);

        _topPixel += px;
        return e;
    }

    public ScDiv addTopPercent(int pct)
    {
        ScDiv e;
        e = addChild();
        e.style().heightPercent(pct);

        applyLeft(e);
        applyRight(e);
        applyTop(e);

        _topPercent += pct;
        return e;
    }

    //##################################################
    //# bottom
    //##################################################

    public ScDiv addBottom(int px)
    {
        ScDiv e;
        e = addChild();
        e.style().height(px);

        applyLeft(e);
        applyRight(e);
        applyBottom(e);

        _bottomPixel += px;
        return e;
    }

    public ScDiv addBottomPercent(int pct)
    {
        ScDiv e;
        e = addChild();
        e.style().heightPercent(pct);

        applyLeft(e);
        applyRight(e);
        applyBottom(e);

        _bottomPercent += pct;
        return e;
    }

    //##################################################
    //# center
    //##################################################

    public ScDiv addCenter()
    {
        ScDiv e = addChild();

        applyLeft(e);
        applyRight(e);
        applyTop(e);
        applyBottom(e);

        return e;
    }

    //##################################################
    //# apply
    //##################################################

    private void applyLeft(ScDiv e)
    {
        if ( _leftPercent > 0 )
            e.style().leftPercent(_leftPercent);
        else
            e.style().left(_leftPixel);
    }

    private void applyRight(ScDiv e)
    {
        if ( _rightPercent > 0 )
            e.style().rightPercent(_rightPercent);
        else
            e.style().right(_rightPixel);
    }

    private void applyTop(ScDiv e)
    {
        if ( _topPercent > 0 )
            e.style().topPercent(_topPercent);
        else
            e.style().top(_topPixel);
    }

    private void applyBottom(ScDiv e)
    {
        if ( _bottomPercent > 0 )
            e.style().bottomPercent(_bottomPercent);
        else
            e.style().bottom(_bottomPixel);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        for ( ScControl e : getChildren() )
            out.render(e);
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControl> getComponents()
    {
        KmCompositeIterator<ScControl> i;
        i = new KmCompositeIterator<ScControl>();

        i.addAll(super.getComponents());
        i.addAll(getChildren());

        return i;
    }

    //##################################################
    //# support
    //##################################################

    private ScDiv addChild()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().absolute().boxSizingBorder();

        _children.add(e);

        return e;
    }
}
