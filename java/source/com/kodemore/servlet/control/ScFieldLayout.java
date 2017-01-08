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
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.variable.ScLocalBoolean;

public class ScFieldLayout
    extends ScChildContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalBoolean _showsHelp;

    //##################################################
    //# constructor
    //##################################################

    public ScFieldLayout()
    {
        _showsHelp = new ScLocalBoolean(true);
    }

    //##################################################
    //# shows help
    //##################################################

    public boolean getShowsHelp()
    {
        return _showsHelp.getValue();
    }

    public void setShowsHelp(boolean e)
    {
        _showsHelp.setValue(e);
    }

    public void showHelp()
    {
        setShowsHelp(true);
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public final <T extends ScControl> T add(T e)
    {
        addWrapper(e);
        return e;
    }

    /**
     * Add an errorWrapper around e, then adds that wrapper
     * to myself. This is the same behavior as the more standard
     * add() method, but this returns the errorWrapper.
     */
    public final <T extends ScControl> ScErrorWrapper addWrapper(T e)
    {
        ScErrorWrapper w = e instanceof ScErrorWrapper
            ? (ScErrorWrapper)e
            : new ScErrorWrapper(e);

        return super.add(w);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderSimpleElementOn(out, "div");
    }

    @Override
    protected void renderChildOn(KmHtmlBuilder out, ScControl e)
    {
        out.beginDivCss(KmCssDefaultConstantsIF.fieldLayoutRow);

        // See add() above.
        ScErrorWrapper wrapper = (ScErrorWrapper)e;

        renderLabelOn(out, wrapper);
        renderFieldOn(out, wrapper);

        out.endDiv();
    }

    private void renderLabelOn(KmHtmlBuilder out, ScErrorWrapper wrapper)
    {
        if ( !wrapper.hasLabel() )
            return;

        if ( !isVisible(wrapper.getChild()) )
            return;

        out.beginSpanCss(KmCssDefaultConstantsIF.fieldLayoutLabel);
        out.print(wrapper.getLabel());
        out.endSpan();
    }

    private void renderFieldOn(KmHtmlBuilder out, ScErrorWrapper wrapper)
    {
        if ( wrapper.containsRequiredField() )
        {
            out.beginDivCss(KmCssDefaultConstantsIF.requiredStar);
            out.print("*");
            out.endDiv();
        }

        out.render(wrapper);
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return css().fieldLayout();
    }

    //##################################################
    //# visibility
    //##################################################

    private boolean isVisible(ScControl e)
    {
        if ( e instanceof ScVisibleIF )
            return ((ScVisibleIF)e).getVisible();

        return true;
    }
}
