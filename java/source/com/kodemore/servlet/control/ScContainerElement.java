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
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;

public abstract class ScContainerElement
    extends ScContainer
    implements ScElementIF
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
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

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
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    public void setHtmlId(ScHtmlIdIF e)
    {
        if ( e == null )
            setHtmlId((String)null);
        else
            setHtmlId(e.getHtmlId());
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String getJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(getRootScript(), this);
    }

    @Override
    public ScHtmlIdAjax getPostDomScript()
    {
        return new ScHtmlIdAjax(super.getPostDomScript(), this);
    }

    @Override
    public ScHtmlIdAjax getPostRenderScript()
    {
        return new ScHtmlIdAjax(super.getPostRenderScript(), this);
    }

    //##################################################
    //# on control-enter
    //##################################################

    public ScBlockScript onControlEnter()
    {
        return getPostDomScript().onControlEnter(this);
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

    @Override
    public void show()
    {
        css().remove().hide();
    }

    @Override
    public void hide()
    {
        css().hide();
    }

    public void show(boolean visible)
    {
        if ( visible )
            show();
        else
            hide();
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
    //# on click
    //##################################################

    public String getOnClick()
    {
        return _onClick.getValue();
    }

    public void setOnClick(String e)
    {
        _onClick.setValue(e);
    }

    public void setOnClick(ScScriptIF e)
    {
        _onClick.setValue(e.formatScript());
    }

    public void setOnClick(ScActionIF e)
    {
        ScActionScript script = ScActionScript.create(e);
        setOnClick(script);
    }

    public void setOnClickPush(ScPage e)
    {
        ScBlockScript script;
        script = ScBlockScript.create();
        script.pushPage(e);

        setOnClick(script);
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
    //# on escape
    //##################################################

    public ScBlockScript onEscape()
    {
        return getPostDomScript().onEscape(this);
    }

    //##################################################
    //# render
    //##################################################

    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute("onclick", getOnClick());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.printAttribute("title", getHoverText());
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxSetText(String value)
    {
        ajax().setText(value);
    }

    public void ajaxClearText()
    {
        getRootScript().clearText(this);
    }

    public void ajaxSetHtml(String value)
    {
        ajax().setHtml(value);
    }

}
