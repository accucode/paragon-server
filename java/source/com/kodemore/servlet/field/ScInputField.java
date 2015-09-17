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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScElementIF;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

public abstract class ScInputField<T>
    extends ScField<T>
    implements ScElementIF
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    /**
     * NOTE, a disabled field cannont receive user input
     * nor will its value be submitted with the form.
     * http://www.w3.org/TR/REC-html40/interact/forms.html#adef-disabled
     */
    private ScLocalBoolean _disabled;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _css = new ScLocalCss();
        _style = new ScLocalStyle();
        _disabled = new ScLocalBoolean(false);
    }

    //##################################################
    //# type
    //##################################################

    protected abstract String getInputType();

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

    @Override
    public void show()
    {
        style().show();
    }

    @Override
    public void hide()
    {
        style().hide();
    }

    //##################################################
    //# disabled
    //##################################################

    public boolean getDisabled()
    {
        return _disabled.getValue();
    }

    public void setDisabled(boolean e)
    {
        _disabled.setValue(e);
    }

    public void setEnabled(boolean e)
    {
        setDisabled(!e);
    }

    public void disable()
    {
        setDisabled(true);
    }

    public void enable()
    {
        setDisabled(false);
    }

    public boolean isDisabled()
    {
        return getDisabled();
    }

    //##################################################
    //# escape key
    //##################################################

    public void onEscape(String e)
    {
        getPostDomScript().onEscape(this, e);
    }

    public void onEscape(ScScriptIF e)
    {
        getPostDomScript().onEscape(this, e);
    }

    public void onEscape(ScAction e)
    {
        getPostDomScript().onEscape(this, e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("input");
        renderAttributesOn(out);
        out.close();

        // no end tag
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("id", getHtmlId());
        out.printAttribute("name", getHtmlName());
        out.printAttribute("type", getInputType());

        if ( getDisabled() )
            out.printAttribute("disabled", "disabled");

        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxEnable()
    {
        ajax().removeAttribute("disabled");
    }

    public void ajaxDisable()
    {
        ajax().setAttribute("disabled", "disabled");
    }
}
