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
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.utility.Kmu;

public class ScRadioField
    extends ScInputField<Object>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalObject  _value;
    private ScLocalBoolean _checked;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _value = new ScLocalObject();
        _checked = new ScLocalBoolean(false);

        setValue(getKey());
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String getInputType()
    {
        return "radio";
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Object getValue()
    {
        return _value.getValue();
    }

    @Override
    public void setValue(Object e)
    {
        _value.setValue(e);
    }

    @Override
    public void resetValue()
    {
        _value.resetValue();
    }

    //==================================================
    //= value :: convenience
    //==================================================

    public String getStringValue()
    {
        return (String)getValue();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        String value = encode(getValue());
        out.printAttribute("value", value);

        if ( isChecked() )
            out.printAttribute("checked");
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return newCssBuilder().radio();
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        String encodedValue = data.getParameter(getHtmlName());
        Object value = decode(encodedValue);
        boolean checked = Kmu.isEqual(getValue(), value);
        _checked.setValue(checked);
    }

    //##################################################
    //# convenience
    //##################################################

    public boolean isChecked()
    {
        return _checked.getValue();
    }

    public void setChecked()
    {
        _checked.setValue(true);
    }

    public void setChecked(boolean e)
    {
        _checked.setValue(e);
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isDisabled();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        ajax().setValue(encode(getValue()));
    }
}
