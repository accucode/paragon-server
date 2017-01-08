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
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScAddContentScript;
import com.kodemore.servlet.script.ScReplaceContentsScript;

public class ScDiv
    extends ScChildContainerElement
{
    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderSimpleElementOn(out, "div");
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxReplaceContents()
    {
        KmHtmlBuilder out = new KmHtmlBuilder();
        renderChildrenOn(out);
        ajaxSetContents(out);
    }

    public ScReplaceContentsScript ajaxSetContents(KmHtmlBuilder out)
    {
        return _htmlIdAjax().setContents(out);
    }

    public ScReplaceContentsScript ajaxSetContents(String html)
    {
        return _htmlIdAjax().setContents(html);
    }

    public ScReplaceContentsScript ajaxSetContents(ScControl e)
    {
        return _htmlIdAjax().setContents(e);
    }

    public void ajaxClearContents()
    {
        _htmlIdAjax().clearContents();
    }

    public void ajaxSetHtml(KmHtmlBuilder out)
    {
        _htmlIdAjax().setHtml(out);
    }

    public ScAddContentScript ajaxAddContents()
    {
        return _htmlIdAjax().addContents();
    }

    public void ajaxScrollTo(ScHtmlIdIF e)
    {
        _htmlIdAjax().scrollTo(e);
    }

    public void ajaxPushWhenDone()
    {
        _htmlIdAjax().pushWhenDone();
    }

    public void ajaxSetCss(String css)
    {
        _htmlIdAjax().setCss(css);
    }

    public void ajaxSetText(String value)
    {
        _htmlIdAjax().setText(value);
    }

    public void ajaxClearText()
    {
        _htmlIdAjax().clearText();
    }

    public void ajaxSetHtml(String value)
    {
        _htmlIdAjax().setHtml(value);
    }

}
