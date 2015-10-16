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
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmHtmlColorValidator;

public class ScColorField
    extends ScInputField<KmHtmlColor>
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString        _text;
    private KmHtmlColorValidator _validator;

    private ScLocalBoolean _fullWrapper;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _text = new ScLocalString();
        _fullWrapper = new ScLocalBoolean(false);

        getPostDomScript().run("Kmu.installColorField('%s');", getJquerySelector());
    }

    //##################################################
    //# input field
    //##################################################

    @Override
    protected String getInputType()
    {
        return "text";
    }

    @Override
    public boolean isEditable()
    {
        return true;
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
        return Kmu.hasValue(getText());
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
    //# validator
    //##################################################

    public void setValidator(KmHtmlColorValidator e)
    {
        _validator = e;
    }

    public KmHtmlColorValidator getValidator()
    {
        return _validator;
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmHtmlColor getValue()
    {
        return KmHtmlColor.create(getText());
    }

    @Override
    public void setValue(KmHtmlColor e)
    {
        if ( e == null )
            setText("");
        else
            setText(e.getValue());
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

    @Override
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( hasErrors() )
            return false;

        KmHtmlColor value = getValue();

        if ( hasText() && value == null )
        {
            addError("Invalid color format; e.g.: #FF00EE.");
            return false;
        }

        if ( !hasValidator() )
            return true;

        KmList<KmErrorIF> errors = new KmList<>();
        _validator.validateOnly(getValue(), errors);
        if ( errors.isNotEmpty() )
        {
            setErrors(errors);
            return false;
        }

        return true;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        String name = getHtmlName();
        String text = data.getParameter(name);

        setText(text);

        if ( hasValue() )
            setText(getValue().toString());
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
        out.openDiv();
        out.printAttribute(formatWrapperCss());
        out.close();

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

        out.printAttribute("value", getText());
        printOldValueAttributeOn(out, getText());
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = super.formatCss();
        css.textField();
        return css;
    }

    private KmCssDefaultBuilder formatWrapperCss()
    {
        return newCssBuilder().textFieldWrapper();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        String value = getText();

        ajax().setValue(value);
        ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }
}
