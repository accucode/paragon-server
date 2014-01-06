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

import java.util.Collection;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalOptionList;

public class ScLinkList
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalAction     _action;
    private ScLocalOptionList _options;

    private ScLocalAdaptor    _optionLabelAdaptor;
    private ScLocalAdaptor    _optionValueAdaptor;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _action = new ScLocalAction();
        _options = new ScLocalOptionList();
        _optionLabelAdaptor = new ScLocalAdaptor();
        _optionValueAdaptor = new ScLocalAdaptor();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        ScLink link;
        link = new ScLink();
        link.setParent(this);
        link.setAction(_action.getValue());

        for ( ScOption e : _options )
        {
            link.setText(e.getText());
            link.setArgument(e.getValue());
            link.renderOn(out);
            out.printBreak();
        }
    }

    //##################################################
    //# state
    //##################################################

    public void setAction(ScActionIF e)
    {
        _action.setValue(e);
    }

    @SuppressWarnings("rawtypes")
    public void setOptionTextAdaptor(KmAdaptorIF e)
    {
        _optionLabelAdaptor.setValue(e);
    }

    public void setOptionTextAdaptor(KmMetaAttribute<?,?> e)
    {
        setOptionTextAdaptor(e.getAdaptor());
    }

    @SuppressWarnings("rawtypes")
    public void setOptionValueAdaptor(KmAdaptorIF e)
    {
        _optionValueAdaptor.setValue(e);
    }

    public void setOptionValueAdaptor(KmMetaAttribute<?,?> e)
    {
        setOptionValueAdaptor(e.getAdaptor());
    }

    public void setOptions(Collection<?> v)
    {
        if ( v == null )
        {
            _options.resetValue();
            return;
        }

        _options.set(v, _optionValueAdaptor.getValue(), _optionLabelAdaptor.getValue());
    }

}
