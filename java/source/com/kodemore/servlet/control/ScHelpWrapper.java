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
import com.kodemore.servlet.variable.ScLocalControl;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

public class ScHelpWrapper
    extends ScControl
    implements ScStyledControlIF
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv          _wrapperBox;
    private ScLocalControl _child;

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    //##################################################
    //# constructor
    //##################################################

    public ScHelpWrapper()
    {
        _child = new ScLocalControl();
        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _wrapperBox = new ScDiv();
        _wrapperBox.setParent(this);
        _wrapperBox.css().error();
        _wrapperBox.hide();
    }

    //##################################################
    //# child
    //##################################################

    public ScControl getChild()
    {
        return _child.getValue();
    }

    public void setChild(ScControl e)
    {
        if ( e != null )
            e.setParent(this);

        _child.setValue(e);
    }

    public boolean hasChild()
    {
        return _child.hasValue();
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

    @Override
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

    @Override
    public KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    protected KmStyleBuilder formatStyle()
    {
        return style();
    }

    //##################################################
    //# flavor
    //##################################################

    private String formatWrapperCss()
    {
        KmCssDefaultBuilder e;
        e = css();
        e.add("helpWrapper");
        return e.toString();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        if ( !hasChild() )
            return;

        out.openDiv();
        out.printAttribute("class", formatWrapperCss());
        out.printAttribute("style", getStyle());
        out.close();

        renderChildOn(out);

        renderHelpImageOn(out);

        out.endDiv();
    }

    private void renderHelpImageOn(KmHtmlBuilder out)
    {
        ScImage e;
        e = new ScImage();
        e.css().helpTriangle().helpTooltip();
        e.setSource(getUrls().getHelpTriangleUrl());
        e.setHoverText(getHelp());
        e.renderOn(out);
    }

    protected void renderChildOn(KmHtmlBuilder out)
    {
        if ( hasChild() )
            getChild().renderOn(out);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    protected void ajaxShowError()
    {
        String s = formatErrors();
        if ( s.isEmpty() )
            return;

        _wrapperBox.ajaxSetText(s);
        _wrapperBox.ajaxShow().slide();
    }

    @Override
    protected void ajaxHideError()
    {
        _wrapperBox.ajaxHide();
    }

}
