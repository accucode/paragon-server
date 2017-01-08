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
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.KmCompressMemoryIF;

public abstract class ScContainerElement
    extends ScContainer
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

    /**
     * A script to run when this control is clicked.
     */
    private ScLocalString _onClick;

    /**
     * Text that appears when hovering over an object.
     */
    private ScLocalString _hoverText;

    //##################################################
    //# constructor
    //##################################################

    public ScContainerElement()
    {
        _htmlId = new ScLocalString(getKey());
        _css = new ScLocalCss();
        _style = new ScLocalStyle();
        _onClick = new ScLocalString();
        _hoverText = new ScLocalString();
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
    public final ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    @Override
    public final void ajaxHideAllErrors()
    {
        _htmlIdAjax().hideAllErrors();
    }

    //##################################################
    //# on control-enter
    //##################################################

    public final ScBlockScript onControlEnter()
    {
        return getPostDomScript().onControlEnter(this);
    }

    public final void onControlEnter(Runnable r)
    {
        ScAction action = newCheckedAction(r);
        onControlEnter(action);
    }

    public final void onControlEnter(ScAction action)
    {
        onControlEnter().run(action);
    }

    //##################################################
    //# on click
    //##################################################

    public final String getOnClick()
    {
        return _onClick.getValue();
    }

    public final void setOnClick(String e)
    {
        _onClick.setValue(e);
    }

    public final void setOnClick(ScScriptIF e)
    {
        _onClick.setValue(e.formatScript());
    }

    public final void setOnClick(ScAction e)
    {
        setOnClick(e, null);
    }

    public final void setOnClick(ScForm form, ScAction action, Object arg)
    {
        ScActionScript script;
        script = ScActionScript.create(action, form);
        script.setArgument(arg);

        setOnClick(script);
    }

    public final void setOnClick(ScAction e, Object arg)
    {
        ScActionScript script;
        script = ScActionScript.create(e);
        script.setArgument(arg);

        setOnClick(script);
    }

    public final void setOnClickPush(ScPage e)
    {
        ScBlockScript script;
        script = ScBlockScript.create();
        script.enterPage(e);

        setOnClick(script);
    }

    //##################################################
    //# hover text
    //##################################################

    public final void setHoverText(String e)
    {
        _hoverText.setValue(e);
    }

    public final String getHoverText()
    {
        return _hoverText.getValue();
    }

    public final boolean hasHoverText()
    {
        return _hoverText.hasValue();
    }

    //##################################################
    //# on escape
    //##################################################

    public final ScBlockScript onEscape()
    {
        return getPostDomScript().onEscape(this);
    }

    public final void setEscapeAction(Runnable r)
    {
        onEscape().run(newUncheckedAction(r), findFormWrapper());
    }

    //##################################################
    //# render
    //##################################################

    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute("onclick", getOnClick());
        out.printAttribute("title", getHoverText());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
    }

    //##################################################
    //# compress
    //##################################################

    /**
     * @see KmCompressMemoryIF#compressMemory
     */
    @Override
    public void compressMemory()
    {
        super.compressMemory();

        _htmlId.compressMemory();
        _css.compressMemory();
        _style.compressMemory();
        _onClick.compressMemory();
        _hoverText.compressMemory();
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
    public final boolean getVisible()
    {
        return !style().hasHide();
    }
}
