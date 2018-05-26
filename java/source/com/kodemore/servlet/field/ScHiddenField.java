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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;

public class ScHiddenField<T>
    extends ScField<T>
{
    //##################################################
    //# variables
    //##################################################

    private String         _htmlName;
    private ScLocal<T>     _value;
    private ScLocalBoolean _enabled;

    /**
     * Hidden fields rarely need css.
     * However, in rare cases, we may use css classes to coordinate
     * certain types of business logic.
     */
    private ScLocalCss _cssHidden;

    //##################################################
    //# constructor
    //##################################################

    public ScHiddenField()
    {
        _value = new ScLocal<>();
        _htmlName = getHtmlId();
        _enabled = new ScLocalBoolean(true);
        _cssHidden = new ScLocalCss();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    //==================================================
    //= html name
    //==================================================

    public String getHtmlName()
    {
        return _htmlName;
    }

    public void setHtmlName(String e)
    {
        _htmlName = e;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        return _value.getValue();
    }

    @Override
    public void setValue(T e)
    {
        _value.setValue(e);
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _value.saveValue();
    }

    @Override
    public void resetValue()
    {
        _value.resetValue();
    }

    //##################################################
    //# editable
    //##################################################

    public boolean getEnabled()
    {
        return _enabled.isTrue();
    }

    public void setEnabled(boolean e)
    {
        _enabled.setValue(e);
    }

    @Override
    public boolean isEditable()
    {
        return getEnabled();
    }

    //##################################################
    //# css
    //##################################################

    public KmCssDefaultBuilder cssHidden()
    {
        return _cssHidden.toBuilder();
    }
    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("input");
        out.printAttribute("id", getHtmlId());
        out.printAttribute("name", getHtmlName());
        out.printAttribute("type", "hidden");
        out.printAttribute("value", encode(getValue()));
        out.printAttribute(cssHidden());

        if ( !getEnabled() )
            out.printAttribute("disabled", "disabled");

        out.close();
        // no end tag
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    protected void readParameters_here(ScServletData data)
    {
        super.readParameters_here(data);

        String name = getHtmlName();
        if ( data.hasParameter(name) )
        {
            Object value = decode(data.getParameter(name));
            setValueUntyped(value);
        }
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxUpdateValue()
    {
        ajaxSetFieldValue(getValue());
    }

    @Override
    public void ajaxSetFieldValue(T e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(T e, boolean updateOldValue)
    {
        String htmlValue = encode(e);

        ScHtmlIdAjax ajax;
        ajax = _htmlIdAjax();
        ajax.setValue(htmlValue);

        if ( updateOldValue )
            ajax.setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, htmlValue);
    }
}
