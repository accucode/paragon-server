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
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRequiredValidator;
import com.kodemore.validator.KmValidator;

public abstract class ScAbstractTextField<T>
    extends ScInputField<T>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _text;
    private ScLocalString  _placeholder;
    private ScLocalString  _hoverText;
    private ScLocalBoolean _readOnly;
    private ScLocalBoolean _fullWrapper;
    private KmValidator<T> _validator;

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

        _text = new ScLocalString();
        _placeholder = new ScLocalString();
        _hoverText = new ScLocalString();
        _readOnly = new ScLocalBoolean(false);
        _fullWrapper = new ScLocalBoolean(false);
        _changeTracking = true;
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String getInputType()
    {
        return "text";
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
        css().widthFull().boxSizingBorder();
    }

    //##################################################
    //# validator
    //##################################################

    public KmValidator<T> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<T> e)
    {
        _validator = e;
    }

    public void setValidator(KmMetaProperty<?,T> p)
    {
        setValidator(p.getValidator());
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

            KmValidator<T> e;
            e = getValidator().getCopy();
            e.setRequired();
            setValidator(e);
        }
        else
            setValidator(new KmRequiredValidator<T>());
    }

    public void setOptional()
    {
        if ( !hasValidator() )
            return;

        if ( getValidator().isOptional() )
            return;

        KmValidator<T> e;
        e = getValidator().getCopy();
        e.setOptional();
        setValidator(e);
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

    @Override
    public void resetValue()
    {
        _text.resetValue();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        boolean wrap = getFullWrapper();

        if ( wrap )
            renderWrappedField(out);
        else
            renderField(out);
    }

    private void renderWrappedField(KmHtmlBuilder out)
    {
        out.beginDiv(formatWrapperCss());
        renderField(out);
        out.endDiv();
    }

    private void renderField(KmHtmlBuilder out)
    {
        super.renderControlOn(out);
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        if ( isReadOnly() )
            out.printAttribute("readonly", "readonly");

        out.printAttribute("placeholder", getPlaceholder());
        out.printAttribute("title", getHoverText());
        out.printAttribute("value", getText());

        if ( getChangeTracking() )
            printOldValueAttributeOn(out, getText());
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css = super.formatCss();

        if ( isReadOnly() )
            css.textFieldReadOnly();
        else
            css.textField();

        return css;
    }

    private KmCssDefaultBuilder formatWrapperCss()
    {
        return newCssBuilder().textFieldWrapper();
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        String name = getHtmlName();
        String text = getData().getParameter(name);

        if ( Kmu.hasValue(text) )
            _text.setValue(text);
        else
            _text.clearValue();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public T getValue()
    {
        return getValueFor(getText());
    }

    protected abstract T getValueFor(String s);

    @Override
    public abstract void setValue(T e);

    public boolean isEmpty()
    {
        return Kmu.isEmpty(getText());
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    public String getSampleFormat()
    {
        return null;
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

        T value = getValue();
        if ( hasText() && value == null )
        {
            addError(getInvalidMessage());
            return false;
        }

        if ( requiresModelValue() && hasText() && getModelValue() == null )
        {
            addError(getInvalidMessage());
            return false;
        }

        if ( _validator == null )
            return true;

        KmList<KmErrorIF> errors = new KmList<>();

        _validator.validateOnly(getValue(), errors);

        if ( errors.isEmpty() )
            return true;

        setErrors(errors);

        return false;
    }

    public boolean requiresModelValue()
    {
        return false;
    }

    public String getInvalidMessage()
    {
        String msg = "Cannot parse value.";

        String sample = getSampleFormat();
        if ( sample != null )
            msg += "  Sample: " + sample;

        return msg;
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text.getValue();
    }

    public void setText(String e)
    {
        _text.setValue(e);
    }

    public boolean hasText()
    {
        return _text.hasValue();
    }

    public boolean hasText(String e)
    {
        return _text.is(e);
    }

    public void clearText()
    {
        _text.setValue("");
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
    //# placeholder
    //##################################################

    public void setPlaceholder(String e)
    {
        _placeholder.setValue(e);
    }

    public String getPlaceholder()
    {
        return _placeholder.getValue();
    }

    public boolean hasPlaceholder()
    {
        return _placeholder.hasValue();
    }

    //##################################################
    //# hover text
    //##################################################

    public void setHoverText(String e)
    {
        _hoverText.setValue(e);
    }

    public String getHoverText()
    {
        return _hoverText.getValue();
    }

    public boolean hasHoverText()
    {
        return _hoverText.hasValue();
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
        String value = getText();

        ajax().setValue(value);

        if ( getChangeTracking() )
            ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }

}
