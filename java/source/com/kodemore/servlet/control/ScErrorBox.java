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

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocalString;

public class ScErrorBox
    extends ScBox
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

    private ScLocalString _flavor;
    private ScBox         _messageBox;

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

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        css().add(PREFIX, PART_WRAPPER, getFlavor());

        super.renderControlOn(out);
    }

    @Override
    protected void renderChildrenOn(KmHtmlBuilder out)
    {
        super.renderChildrenOn(out);

        _messageBox.css().add(PREFIX, PART_MESSAGE, getFlavor());
        _messageBox.renderOn(out);
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControlIF> getComponents()
    {
        KmCompositeIterator<ScControlIF> i;
        i = new KmCompositeIterator<>();
        i.addAll(super.getComponents());
        i.add(_messageBox);
        return i;
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

        ScHtmlIdAjax ajax;
        ajax = _messageBox.ajax();
        ajax.setText(s);
        ajax.show().slide();
    }

    @Override
    protected void ajaxHideError()
    {
        _messageBox.ajax().hide();
    }

}
