/*
  Copyright (c) 2005-2018 www.kodemore.com

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
import com.kodemore.utility.KmHtmlLineEnding;

/**
 * I am used as a common superclass for elements that do
 * not have any children.  That is, my subclasses do not
 * expose a general list of child controls.  However,
 * some subclasses may still manage and generate child
 * elements in the html structure.
 */
public abstract class ScElement
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _htmlId;
    private ScLocalCss    _css;
    private ScLocalStyle  _style;

    /**
     * The PLAIN TEXT message to display as the hover text (tooltip).
     */
    private ScLocalString _hoverText;

    //##################################################
    //# constructor
    //##################################################

    public ScElement()
    {
        _htmlId = new ScLocalString(getKeyToken());
        _css = new ScLocalCss();
        _style = new ScLocalStyle();
        _hoverText = new ScLocalString();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    //##################################################
    //# post dom
    //##################################################

    @Override
    public final ScHtmlIdAjax getPostDomScript()
    {
        return ScHtmlIdAjax.createOnDelegate(this, super.getPostDomScript());
    }

    @Override
    public final ScHtmlIdAjax getPostRenderScript()
    {
        return ScHtmlIdAjax.createOnDelegate(this, super.getPostRenderScript());
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    public void ajaxSetAttribute(String key, String value)
    {
        _htmlIdAjax().setAttribute(key, value);
    }

    public ScHtmlIdAjax createDetachedAjax()
    {
        return ScHtmlIdAjax.createDetached(this);
    }

    //##################################################
    //# css
    //##################################################

    public String getCss()
    {
        return _css.getValue();
    }

    public void setCss(String e)
    {
        _css.setValue(e);
    }

    public KmCssDefaultBuilder css()
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

    public String getStyle()
    {
        return _style.getValue();
    }

    public void setStyle(String e)
    {
        _style.setValue(e);
    }

    public KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    protected KmStyleBuilder formatStyle()
    {
        return style();
    }

    //##################################################
    //# hover text
    //##################################################

    public void setHoverText(String e)
    {
        _hoverText.setValue(e);
    }

    public String getHoverText()
    {
        return _hoverText.getValue();
    }

    public boolean hasHoverText()
    {
        return _hoverText.hasValue();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected abstract void renderControlOn(KmHtmlBuilder out);

    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.printAttribute("title", getHoverText(), KmHtmlLineEnding.BreakElement);
    }

    //##################################################
    //# visibility
    //##################################################

    @Override
    public final void setVisible(boolean e)
    {
        style().show(e);
    }

    @Override
    public final boolean isVisible()
    {
        return !style().hasHide();
    }

}
