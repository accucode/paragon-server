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

import java.util.function.Function;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.renderer.ScRenderer;
import com.kodemore.servlet.script.ScShowNoticeScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalRenderer;

public abstract class ScAbstractLink
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The text to display on screen.
     */
    private ScLocalRenderer _text;

    /**
     * If true, the default, the link may receive tab focus.
     * If false, set the tabindex = -1 to disable tab focus.
     */
    private ScLocalBoolean _focusable;

    /**
     * If true, the visual style of the link is changed,
     * and the link is no longer clickable.
     */
    private ScLocalBoolean _disabled;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractLink()
    {
        _text = new ScLocalRenderer();
        _focusable = new ScLocalBoolean(true);
        _disabled = new ScLocalBoolean();

        css().link();
    }

    //##################################################
    //# text
    //##################################################

    public ScRenderer getText()
    {
        return _text.getValue();
    }

    public void setText(String e)
    {
        _text.setValue(e);
    }

    public void setText(Function<?,?> e)
    {
        _text.setFunction(e);
    }

    public boolean hasText()
    {
        return _text.hasValue();
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
    //# disabled
    //##################################################

    private boolean getDisabled()
    {
        return _disabled.isTrue();
    }

    private void setDisabled(boolean e)
    {
        _disabled.setValue(e);
    }

    public void enable()
    {
        setDisabled(false);
    }

    public void disable(String msg)
    {
        setDisabled(true);
        setHoverText(msg);
    }

    public boolean isEnabled()
    {
        return !isDisabled();
    }

    public boolean isDisabled()
    {
        return getDisabled();
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

        _text.renderOn(out, this, getModel());

        out.end("a");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("target", formatTarget());
        out.printAttribute("href", formatHref());
        out.printAttribute("onclick", formatOnClick());

        if ( !getFocusable() )
            out.printAttribute("tabindex", -1);
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return super.formatCss();
    }

    @Override
    protected KmStyleBuilder formatStyle()
    {
        KmStyleBuilder e = super.formatStyle();

        if ( isDisabled() )
            e.color("#666");

        return e;
    }

    //##################################################
    //# render: overrides
    //##################################################

    /**
     * This is used for the target attribute.
     * E.g.: <a target="_blank">
     */
    protected abstract String formatTarget();

    //##################################################
    //# format :: href
    //##################################################

    private String formatHref()
    {
        return isEnabled()
            ? formatEnabledHref()
            : formatDisabledHref();
    }

    /**
     * This is used for the href attribute.
     * E.g.: <a href="url">
     */
    protected abstract String formatEnabledHref();

    private String formatDisabledHref()
    {
        return null;
    }

    //##################################################
    //# format :: on click
    //##################################################

    private String formatOnClick()
    {
        return isEnabled()
            ? formatEnabledOnClick()
            : formatDisabledOnClick();
    }

    /**
     * This is used for the onclick attribute.
     * E.g.: <a onclick="alert()">
     */
    protected abstract String formatEnabledOnClick();

    private String formatDisabledOnClick()
    {
        String msg = hasHoverText()
            ? getHoverText()
            : "This action is currently disabled.";

        ScShowNoticeScript s;
        s = new ScShowNoticeScript();
        s.setTitle("Disabled");
        s.setTextMessage(msg);
        return s.formatScript() + " return false;";
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxSetText(String value)
    {
        getRootScript().setText(this, value);
    }

}
