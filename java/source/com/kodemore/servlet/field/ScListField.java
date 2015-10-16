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
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalOptionList;
import com.kodemore.servlet.variable.ScLocalStyle;

public class ScListField
    extends ScField<Object>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalCss   _css;
    private ScLocalStyle _style;

    private ScLocalObject     _value;
    private ScLocalOptionList _options;

    /**
     * If true (by default), the original value is included in the html data- attribute
     * and the client-side browser uses javascript to track if changes are made.
     */
    private boolean _changeTracking;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _value = new ScLocalObject();
        _options = new ScLocalOptionList();
        _changeTracking = true;
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

    protected KmCssDefaultBuilder formatCss()
    {
        return css().getCopy().linkBox();
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

    public void show()
    {
        style().show();
    }

    public void hide()
    {
        style().hide();
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

    //##################################################
    //# change tracking
    //##################################################

    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        warnIfInstalled();
        _changeTracking = e;
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# convenience
    //##################################################

    public String getStringValue()
    {
        return (String)getValue();
    }

    public Integer getIntegerValue()
    {
        return (Integer)getValue();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("select");
        renderAttributesOn(out);
        out.close();

        renderOptionsOn(out);

        out.end("select");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        // Hardcoded to 2.  Set height via css.
        out.printAttribute("size", 2);

        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, encode(getValue()));
    }

    private void renderOptionsOn(KmHtmlBuilder out)
    {
        for ( ScOption e : _options )
            renderOptionOn(out, e);
    }

    private void renderOptionOn(KmHtmlBuilder out, ScOption e)
    {
        out.open("option");
        out.printAttribute("value", encode(e.getValue()));

        if ( e.hasValue(getValue()) )
            out.printAttribute("selected", "selected");

        out.close();

        out.print(e.getText());
        out.end("option");
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

    public void addOption(Object value, String label)
    {
        _options.add(value, label);
    }

    /**
     * Ensure value matches one of the options.  If not, set it to null.
     */
    public void ensureValidValue()
    {
        if ( isValueValid() )
            return;

        resetValue();
    }

    public boolean isValueValid()
    {
        Object value = getValue();

        for ( ScOption e : _options )
            if ( e.hasValue(value) )
                return true;

        return false;
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return true;
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        String value = encode(getValue());

        ajax().setValue(value);

        if ( getChangeTracking() )
            ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }

}
