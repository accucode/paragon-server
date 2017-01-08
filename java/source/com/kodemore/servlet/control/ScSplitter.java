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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;

/**
 * I am used to create a draggable splitter between my TWO (2) children.
 *
 * Although I am subclassed from the general container hierarchy for convenience,
 * I should always be configured with exactly two children.
 */
public class ScSplitter
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If true, the two children will be oriented on on top of the other; top and bottom.
     * If false, the two children will be oriented side-by-side; left and right.
     * The default is false.
     */
    private ScLocalBoolean _vertical;

    /**
     * Limits the minimum size of both child panels (in pixels).
     * Defaults to 100px.
     */
    private ScLocalInteger _minimumSize;

    /**
     * The initial position of the splitter.  Can be set as either a pixel
     * or a percent (but NOT both).
     */
    private ScLocalInteger _pixelPosition;
    private ScLocalInteger _percentPosition;

    //##################################################
    //# constructor
    //##################################################

    public ScSplitter()
    {
        _vertical = new ScLocalBoolean(false);
        _minimumSize = new ScLocalInteger(100);

        _pixelPosition = new ScLocalInteger();
        _percentPosition = new ScLocalInteger();
        setPercentPosition(50);
    }

    //##################################################
    //# orientation
    //##################################################

    public boolean getVertical()
    {
        return _vertical.getValue();
    }

    public void setVertical(boolean e)
    {
        _vertical.setValue(e);
    }

    public void setVertical()
    {
        setVertical(true);
    }

    public void setHorizontal()
    {
        setVertical(false);
    }

    //##################################################
    //# minimum size
    //##################################################

    public int getMinimumSize()
    {
        return _minimumSize.getValue();
    }

    public void setMinimumSize(int e)
    {
        _minimumSize.setValue(e);
    }

    //##################################################
    //# position
    //##################################################

    public Integer getPixelPosition()
    {
        return _pixelPosition.getValue();
    }

    public void setPixelPosition(int e)
    {
        _pixelPosition.setValue(e);
        _percentPosition.clearValue();
    }

    public Integer getPercentPosition()
    {
        return _percentPosition.getValue();
    }

    public void setPercentPosition(int e)
    {
        _percentPosition.setValue(e);
        _pixelPosition.clearValue();
    }

    //##################################################
    //# children (should be TWO)
    //##################################################

    /**
     * Override the default add() in order to inject an extra DIV between
     * myself and each of my children.  The intermediate DIVs are used to
     * manage the split dragging and animations, and clients should generally
     * NOT access or style these intermediate DIVs.
     */
    @Override
    public <T extends ScControl> T add(T e)
    {
        return super.add(new ScDiv()).add(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        /*
         * The split library works best when applied first to the container, then
         * to any children that are also splitters.  This is only registering the
         * scripts on the postRender buffer, not actually adding them to the buffer
         * directly.
         */
        out.getPostRender().run("$('%s').split(%s);", getJquerySelector(), formatOptions());

        super.renderControlOn(out);
    }

    //##################################################
    //# options
    //##################################################

    private KmJsonMap formatOptions()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("orientation", formatOrientation());
        e.setInteger("limit", getMinimumSize());
        e.setObject("position", formatPosition());
        return e;
    }

    /*
     * The orientation values appear backwards but is actually correct.
     * We use orientation to indicate the relative orientation of the two child panels.
     * But the js library uses orientation to mean the direction of the dividing line.
     */
    private String formatOrientation()
    {
        if ( getVertical() )
            return "horizontal";

        return "vertical";
    }

    private Object formatPosition()
    {
        Integer px = getPixelPosition();
        if ( px != null )
            return px;

        Integer pct = getPercentPosition();
        if ( pct == null )
            pct = 50;

        return pct + "%";
    }

}
