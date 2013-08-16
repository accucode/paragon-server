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
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.variable.ScLocalString;

public class ScErrorWrapper
    extends ScAbstractWrapper
{
    //##################################################
    //# constants
    //##################################################

    private static final String PREFIX          = KmCssDefaultConstantsIF.errorBox_prefix;
    private static final String PART_WRAPPER    = KmCssDefaultConstantsIF.errorBox_part_wrapper;
    private static final String PART_MESSAGE    = KmCssDefaultConstantsIF.errorBox_part_message;
    private static final String FLAVOR_ATTACHED = KmCssDefaultConstantsIF.errorBox_flavor_attached;
    private static final String FLAVOR_DETACHED = KmCssDefaultConstantsIF.errorBox_flavor_detached;

    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _flavor;
    private ScBox               _messageBox;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _flavor = new ScLocalString();
        setFlavorDetached();

        _messageBox = new ScBox();
        _messageBox.setParent(this);
        _messageBox.css().error();
        _messageBox.hide();
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor.getValue();
    }

    private void setFlavor(String e)
    {
        _flavor.setValue(e);
    }

    public void setFlavorAttached()
    {
        setFlavor(FLAVOR_ATTACHED);
    }

    public void setFlavorDetached()
    {
        setFlavor(FLAVOR_DETACHED);
    }

    private String formatWrapperCss()
    {
        KmCssDefaultBuilder e;
        e = newCssBuilder();
        e.add(PREFIX, PART_WRAPPER, getFlavor());
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
        out.close();

        renderChildOn(out);

        _messageBox.css().add(PREFIX, PART_MESSAGE, getFlavor());
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
        if ( s == null )
            return;

        _messageBox.ajax().setText(s);
        _messageBox.ajax().show().slide();
    }

    @Override
    protected void ajaxHideError()
    {
        _messageBox.ajax().hide();
    }

}
