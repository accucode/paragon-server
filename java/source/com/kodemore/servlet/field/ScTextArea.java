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

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

/**
 * I am a multi-line text area, that uses the <textarea>
 * html tag.  I do not support empty string ("") values.
 * Instead empty strings (both get and set) are converted
 * to nulls.
 */
public class ScTextArea
    extends ScField<String>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _text;
    private ScLocalBoolean      _readOnly;
    private ScLocalBoolean      _disabled;
    private ScLocalBoolean      _fullWrapper;

    private ScLocalCss          _css;
    private ScLocalStyle        _style;

    private KmValidator<String> _validator;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _text = new ScLocalString();
        _readOnly = new ScLocalBoolean(false);
        _disabled = new ScLocalBoolean(false);
        _fullWrapper = new ScLocalBoolean(false);

        _css = new ScLocalCss();
        _style = new ScLocalStyle();
    }

    //##################################################
    //# full wrapper
    //##################################################

    public boolean getFullWrapper()
    {
        return _fullWrapper.getValue();
    }

    public void setFullWrapper(boolean e)
    {
        _fullWrapper.setValue(e);
    }

    public void setWidthFull()
    {
        setFullWrapper(true);
        css().widthFull();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        String s = _text.getValue();

        if ( Kmu.isEmpty(s) )
            return null;

        return s;
    }

    @Override
    public void setValue(String e)
    {
        if ( Kmu.isEmpty(e) )
            e = null;

        _text.setValue(e);
    }

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    public void clearValue()
    {
        setValue(null);
    }

    public boolean isEmpty()
    {
        return _text.isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
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

    public KmCssDefaultBuilder formatCss()
    {
        return css().textField();
    }

    public KmCssDefaultBuilder formatWrapperCss()
    {
        return newCssBuilder().textFieldWrapper();
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

    public KmStyleBuilder formatStyle()
    {
        return style();
    }

    //##################################################
    //# read only
    //##################################################

    public void setReadOnly(boolean b)
    {
        _readOnly.setValue(b);
    }

    public boolean isReadOnly()
    {
        return _readOnly.getValue();
    }

    public void setReadOnly()
    {
        setReadOnly(true);
    }

    //##################################################
    //# disabled
    //##################################################

    public void enable()
    {
        _disabled.setFalse();
    }

    public void disable()
    {
        _disabled.setTrue();
    }

    public boolean isDisabled()
    {
        return _disabled.isTrue();
    }

    //##################################################
    //# page session
    //##################################################

    @Override
    public void saveFieldValues()
    {
        super.saveFieldValues();
        _text.saveValue();
    }

    @Override
    public void resetFieldValues()
    {
        super.resetFieldValues();
        resetValue();
    }

    //##################################################
    //# validator
    //##################################################

    public KmValidator<String> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<String> e)
    {
        _validator = e;
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    @Override
    public void setRequired()
    {
        if ( hasValidator() )
        {
            if ( getValidator().isRequired() )
                return;

            KmValidator<String> e;
            e = getValidator().getCopy();
            e.setRequired();
            setValidator(e);
        }
        else
            setValidator(new KmRequiredValidator<String>());
    }

    public void setOptional()
    {
        if ( !hasValidator() )
            return;

        if ( getValidator().isOptional() )
            return;

        KmValidator<String> e;
        e = getValidator().getCopy();
        e.setOptional();
        setValidator(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        boolean wrap = getFullWrapper();

        if ( wrap )
            renderWrappedTextArea(out);
        else
            renderTextArea(out);
    }

    private void renderWrappedTextArea(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute(formatWrapperCss());
        out.close();

        renderTextArea(out);

        out.endDiv();
    }

    private void renderTextArea(KmHtmlBuilder out)
    {
        out.open("textarea");
        renderAttributesOn(out);
        out.close();

        if ( hasValue() )
            out.printWithoutBreaks(getValue());

        out.end("textarea");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());

        if ( isReadOnly() )
            out.printAttribute("readonly", "readonly");

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        String name = getHtmlName();
        if ( data.hasParameter(name) )
            _text.setValue(data.getParameter(name));
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( hasErrors() )
            return false;

        if ( _validator == null )
            return true;

        KmList<KmErrorIF> errors = new KmList<KmErrorIF>();

        _validator.validateOnly(getValue(), errors);
        if ( errors.isEmpty() )
            return true;

        setErrors(errors);
        return false;
    }

    public String getInvalidMessage()
    {
        return "Cannot parse value.";
    }

    //##################################################
    //# editable
    //##################################################

    @Override
    public boolean isEditable()
    {
        return !isReadOnly() && !isDisabled();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        ajax().setValue(getValue());
    }

}
