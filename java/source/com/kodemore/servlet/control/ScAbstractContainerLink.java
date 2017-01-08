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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalBoolean;

public abstract class ScAbstractContainerLink
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScSimpleContainer _container;

    /**
     * If true, the default, the link may receive tab focus.
     * If false, set the tabindex = -1 to disable tab focus.
     */
    private ScLocalBoolean    _focusable;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractContainerLink()
    {
        _container = new ScSimpleContainer();
        _focusable = new ScLocalBoolean(true);

        css().link();
    }

    //##################################################
    //# container
    //##################################################

    public ScContainer getContainer()
    {
        return _container;
    }

    //##################################################
    //# focus
    //##################################################

    public boolean getFocusable()
    {
        return _focusable.getValue();
    }

    public void setFocusable(boolean e)
    {
        _focusable.setValue(e);
    }

    public void setNoFocus()
    {
        setFocusable(false);
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public KmList<ScControl> getChildren()
    {
        return KmList.createWith(getContainer());
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("a");
        renderAttributesOn(out);
        out.close();

        out.render(_container);

        out.end("a");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("href", formatHref());
        out.printAttribute("target", formatTarget());
        out.printAttribute("onclick", formatOnClick());

        if ( !getFocusable() )
            out.printAttribute("tabindex", -1);
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return super.formatCss();
    }

    //##################################################
    //# render: overrides
    //##################################################

    protected abstract String formatTarget();

    protected abstract String formatHref();

    protected abstract String formatOnClick();

    //##################################################
    //# ajax
    //##################################################

    public void ajaxSetText(String value)
    {
        getRootScript().setText(this, value);
    }

}
