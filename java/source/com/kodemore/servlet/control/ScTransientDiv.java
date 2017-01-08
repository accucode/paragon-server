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
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;

/**
 * I provide a convenient way to add dynamic elements to a page.  The
 * intent is to provide a more intuitive alternative to the ScLiteral
 * element for dynamically generated content.
 *
 * The children are always transient; that is, they are not stored in the application
 * nor in the page session.  Any number of children can be added, and they will be
 * rendered onto the page, but the children are discarded as soon as the http request
 * is complete.
 *
 * Although my children are transient, the wrapping div is always rendered
 * even if there are no children.  This means that I always create an identifiable
 * element (div) in the client dom, and can be targeted for subsequent ajax such
 * as ajaxReplace() without the need to manage a separate wrapper.
 */
public class ScTransientDiv
    extends ScTransientContainer
    implements ScHtmlIdIF, ScStyledControlIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The ID of the outer html element.
     */
    private ScLocalString _htmlId;

    /**
     * The css classes.
     */
    private ScLocalCss    _css;

    /**
     * The inline css style.
     */
    private ScLocalStyle  _style;

    //##################################################
    //# constructor
    //##################################################

    public ScTransientDiv()
    {
        _htmlId = new ScLocalString(getKey());
        _css = new ScLocalCss();
        _style = new ScLocalStyle();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public final String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public final void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    public final void setHtmlId(ScHtmlIdIF e)
    {
        if ( e == null )
            setHtmlId((String)null);
        else
            setHtmlId(e.getHtmlId());
    }

    //##################################################
    //# css
    //##################################################

    public final String getCss()
    {
        return _css.getValue();
    }

    public final void setCss(String e)
    {
        _css.setValue(e);
    }

    @Override
    public final KmCssDefaultBuilder css()
    {
        return _css.toDefaultBuilder();
    }

    protected KmCssDefaultBuilder formatCss()
    {
        return css();
    }

    //##################################################
    //# style
    //##################################################

    public final String getStyle()
    {
        return _style.getValue();
    }

    public final void setStyle(String e)
    {
        _style.setValue(e);
    }

    @Override
    public final KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    protected KmStyleBuilder formatStyle()
    {
        return style();
    }

    //##################################################
    //# visible
    //##################################################

    @Override
    public boolean getVisible()
    {
        return !style().hasHide();
    }

    @Override
    public void setVisible(boolean e)
    {
        style().show(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderAttributesOn(out);
        out.close();

        renderChildrenOn(out);

        out.endDiv();
    }

    private void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public final ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

}
