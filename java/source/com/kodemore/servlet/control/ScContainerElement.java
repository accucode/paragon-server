/*
  Copyright (c) 2005-2013 www.kodemore.com

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
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;

public abstract class ScContainerElement
    extends ScChildContainer
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

    @Override
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
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

    public void setOnClickHash(String hash)
    {
        ScRootScript script;
        script = new ScRootScript();
        script.gotoHash(hash);

        setOnClick(script);
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

    /**
     * Render a container that follows a very simple and common
     * format.  All children must explicitly define their own
     * renderControlOn() method, but many will do nothing more
     * than delegate to this method. 
     */
    protected void renderSimpleElementOn(KmHtmlBuilder out, String tag)
    {
        out.open(tag);
        renderAttributesOn(out);
        out.close();

        renderChildrenOn(out);

        out.end(tag);
    }

    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        out.printAttribute("id", getHtmlId());
        out.printAttribute("onclick", getOnClick());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
    }

    protected void renderChildrenOn(KmHtmlBuilder out)
    {
        for ( ScControl e : getChildren() )
            renderChildOn(out, e);
    }

    protected void renderChildOn(KmHtmlBuilder out, ScControl e)
    {
        e.renderOn(out);
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
