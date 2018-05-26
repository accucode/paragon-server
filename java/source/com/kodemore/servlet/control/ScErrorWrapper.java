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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public class ScErrorWrapper
    extends ScAbstractWrapper
{
    //##################################################
    //# enum
    //##################################################

    private static enum Flavor
    {
        attached,
        detached;
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _flavor;
    private ScDiv         _messageBox;
    private ScLocalCss    _css;

    //##################################################
    //# constructor
    //##################################################

    public ScErrorWrapper()
    {
        _flavor = new ScLocalString();
        setFlavorDetached();

        _messageBox = new ScDiv();
        _messageBox.setParent(this);
        _messageBox.css().error();
        _messageBox.hide();

        _css = new ScLocalCss();
    }

    public ScErrorWrapper(ScControl child)
    {
        this();
        setChild(child);

        // this is required for transient fields that are dynamically generated
        if ( child instanceof ScHtmlIdIF )
        {
            String htmlId = Kmu.format("%s-errorBox", ((ScHtmlIdIF)child).getHtmlId());
            _messageBox.setHtmlId(htmlId);
        }
    }

    //##################################################
    //# flavor
    //##################################################

    private Flavor getFlavor()
    {
        String name = _flavor.getValue();
        return Flavor.valueOf(name);
    }

    private void setFlavor(Flavor e)
    {
        _flavor.setValue(e.name());
    }

    public void setFlavorAttached()
    {
        setFlavor(Flavor.attached);
    }

    public void setFlavorDetached()
    {
        setFlavor(Flavor.detached);
    }

    //##################################################
    //# css
    //##################################################

    public KmCssDefaultBuilder css()
    {
        return _css.toDefaultBuilder();
    }

    private String formatCss()
    {
        KmCssDefaultBuilder css = css();

        switch ( getFlavor() )
        {
            case attached:
                css.error_attachedBox();
                break;

            case detached:
                css.error_attachedBox();
                break;
        }

        return css.toString();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("class", formatCss());
        out.close();

        renderChildOn(out);
        _messageBox.renderOn(out);

        out.endDiv();
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

        _messageBox.ajaxSetText(s);
        _messageBox.ajaxShow().slide();
    }

    @Override
    public String formatErrors()
    {
        return getChild().collectErrors().joinLines();
    }

    @Override
    public void collectErrorsOn(KmList<String> v)
    {
        // nothing
    }

    @Override
    protected void ajaxHideError()
    {
        _messageBox.ajaxHide();
    }

}
