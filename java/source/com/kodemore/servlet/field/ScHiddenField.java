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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalObject;

public class ScHiddenField<T>
    extends ScInputField<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalObject _value;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _value = new ScLocalObject();
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String getInputType()
    {
        return "hidden";
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("value", encode(getValue()));
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        if ( hasKeyParameter(data) )
            _value.setValue(decodeKeyParameter(data));
    }

    //##################################################
    //# convenience
    //##################################################

    @SuppressWarnings("unchecked")
    @Override
    public T getValue()
    {
        return (T)_value.getValue();
    }

    @Override
    public void setValue(T e)
    {
        _value.setValue(e);
    }

    @Override
    public void resetValue()
    {
        _value.resetValue();
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return false;
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        String value = encode(getValue());

        ajax().setValue(value);
        ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }

}
