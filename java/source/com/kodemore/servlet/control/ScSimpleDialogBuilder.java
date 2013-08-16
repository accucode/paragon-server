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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.action.ScActions;
import com.kodemore.servlet.script.ScScript;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.Kmu;

/**
 * I provide convenient use of a simple dialog intended
 * for non-editable, non-dynamic, messages.  
 * 
 * I am NOT an ScControl.  Instead, I am intended to be
 * created on the fly, in order to generate an ad hoc dialog. 
 * 
 * NOTE: Care must be taken to ensure than any custom actions 
 * are created as singletons and bound into the controlRegistry 
 * during application install.  Any action instances created
 * inside of a handle() method will not be registered and will
 * fail when the client attempts to activate them.
 */
public class ScSimpleDialogBuilder
{
    //##################################################
    //# variables
    //##################################################

    private String           _flavor;
    private KmHtmlBuilder    _header;

    private KmHtmlBuilder    _body;
    private Integer          _bodyWidth;
    private Integer          _bodyHeight;

    private KmList<ScButton> _buttons;

    //##################################################
    //# constructor
    //##################################################

    public ScSimpleDialogBuilder()
    {
        _flavor = "default";
        _header = new KmHtmlBuilder();

        _body = new KmHtmlBuilder();
        _bodyWidth = null;
        _bodyHeight = 300;

        _buttons = new KmList<ScButton>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getFlavor()
    {
        return _flavor;
    }

    public void setFlavor(String e)
    {
        _flavor = e;
    }

    public KmHtmlBuilder getHeader()
    {
        return _header;
    }

    public void setHeaderText(String s)
    {
        getHeader().clear();
        getHeader().print(s);
    }

    public void setHeaderHtml(String s)
    {
        getHeader().clear();
        getHeader().printLiteral(s);
    }

    public KmHtmlBuilder getBody()
    {
        return _body;
    }

    public void setBodyText(String s)
    {
        _body.clear();
        _body.print(s);
    }

    public void setBodyHtml(String s)
    {
        _body.clear();
        _body.printLiteral(s);
    }

    public Integer getBodyWidth()
    {
        return _bodyWidth;
    }

    public void setBodyWidth(Integer e)
    {
        _bodyWidth = e;
    }

    public Integer getBodyHeight()
    {
        return _bodyHeight;
    }

    public void setBodyHeight(Integer e)
    {
        _bodyHeight = e;
    }

    //##################################################
    //# buttons
    //##################################################

    public ScActionButton addCancelButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Cancel");
        e.setAction(getCloseAction());
        e.setFlavorNegative();
        e.setPreImage(ScUrls.getThemeImage("buttonCancel.png"));

        _buttons.add(e);

        return e;
    }

    public ScActionButton addCloseButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Close");
        e.setAction(getCloseAction());

        _buttons.add(e);

        return e;
    }

    public ScActionButton addSubmitButton(ScActionIF a)
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Continue");
        e.setAction(a);
        e.setFlavorPositive();
        e.setPrimary();
        e.setPostImage(ScUrls.getThemeImage("buttonSubmit.png"));

        _buttons.add(e);

        return e;
    }

    //##################################################
    //# render
    //##################################################

    private String render()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderOn(out);

        return out.toString();
    }

    private void renderOn(KmHtmlBuilder out)
    {
        String boxClass = formatBoxCss("box");
        String headerClass = formatBoxCss("header");
        String footerClass = formatBoxCss("footer");
        String bodyClass = formatBoxCss("body");

        out.beginDivCss(boxClass);

        out.beginDivCss(headerClass);
        out.render(getHeader());
        out.endDiv();

        out.openDiv();
        out.printAttribute("class", bodyClass);
        out.printAttribute("style", formatBodyStyle());
        out.close();
        out.render(getBody());
        out.endDiv();

        out.beginDivCss(footerClass);
        out.beginDivCss("floatRight clearfix");
        for ( ScButton e : _buttons )
            out.render(e);
        out.endDiv();
        out.endDiv();

        out.endDiv();
    }

    private String formatBoxCss(String section)
    {
        return Kmu.format("clearfix dialog-%s-%s", section, getFlavor());
    }

    private String formatBodyStyle()
    {
        KmStyleBuilder out;
        out = new KmStyleBuilder();
        out.width(getBodyWidth());
        out.height(getBodyHeight());

        return out.toString();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxShowModal()
    {
        String html = render();

        KmJsonObject options;
        options = new KmJsonObject();

        KmJsonObject css;
        css = options.setObject("containerCss");
        css.setString("border", "4px solid #44f");

        ajax().openDialogHtml(html, options);
    }

    //##################################################
    //# support
    //##################################################

    private ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    private ScScript ajax()
    {
        return getData().ajax();
    }

    private ScActionIF getCloseAction()
    {
        return ScActions.getInstance().getCloseDialogAction();
    }

}
