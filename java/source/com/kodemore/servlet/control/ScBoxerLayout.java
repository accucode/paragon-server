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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

public class ScBoxerLayout
    implements ScLayoutIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Style the wrapper that encloses the collection of children.
     */
    private ScLocalCss     _css;
    private ScLocalStyle   _style;
    private ScLocalBoolean _clearfix;

    /**
     * Style the wrapper that encloses each individual child.
     */
    private ScLocalCss     _childCss;
    private ScLocalStyle   _childStyle;
    private ScLocalBoolean _childClearfix;

    //##################################################
    //# constructor
    //##################################################

    public ScBoxerLayout()
    {
        _css = new ScLocalCss();
        _style = new ScLocalStyle();
        _clearfix = new ScLocalBoolean(true);

        _childCss = new ScLocalCss();
        _childStyle = new ScLocalStyle();
        _childClearfix = new ScLocalBoolean(true);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public ScBoxerLayout getCopy()
    {
        ScBoxerLayout e;
        e = new ScBoxerLayout();

        e.setCss(getCss());
        e.setStyle(getStyle());
        e.setClearfix(getClearfix());

        e.setChildCss(getChildCss());
        e.setChildStyle(getChildStyle());
        e.setChildClearfix(getChildClearfix());

        return e;
    }

    //##################################################
    //# wrapper
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

    public boolean getClearfix()
    {
        return _clearfix.getValue();
    }

    public void setClearfix(boolean e)
    {
        _clearfix.setValue(e);
    }

    public ScBoxerLayout pad()
    {
        css().pad();
        return this;
    }

    public ScBoxerLayout gap()
    {
        css().gap();
        return this;
    }

    //##################################################
    //# child
    //##################################################

    public String getChildCss()
    {
        return _childCss.getValue();
    }

    public void setChildCss(String e)
    {
        _childCss.setValue(e);
    }

    public KmCssDefaultBuilder childCss()
    {
        return _childCss.toDefaultBuilder();
    }

    public String getChildStyle()
    {
        return _childStyle.getValue();
    }

    public void setChildStyle(String e)
    {
        _childStyle.setValue(e);
    }

    public KmStyleBuilder childStyle()
    {
        return _childStyle.toBuilder();
    }

    public boolean getChildClearfix()
    {
        return _childClearfix.getValue();
    }

    public void setChildClearfix(boolean e)
    {
        _childClearfix.setValue(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderOpenOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.close();
    }

    @Override
    public void renderChildOn(KmHtmlBuilder out, ScControl e, int i, int n)
    {
        out.openDiv();
        out.printAttribute(formatChildCss());
        out.printAttribute(formatChildStyle(i));
        out.close();

        out.render(e);

        out.endDiv();
    }

    @Override
    public void renderCloseOn(KmHtmlBuilder out)
    {
        out.endDiv();
    }

    //##################################################
    //# format
    //##################################################

    private KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css = css();

        if ( getClearfix() )
            css.clearfix();

        return css;
    }

    private KmStyleBuilder formatStyle()
    {
        return style();
    }

    private KmCssDefaultBuilder formatChildCss()
    {
        KmCssDefaultBuilder css = childCss();

        if ( getChildClearfix() )
            css.clearfix();

        return css;
    }

    private KmStyleBuilder formatChildStyle(int i)
    {
        return childStyle();
    }

}
