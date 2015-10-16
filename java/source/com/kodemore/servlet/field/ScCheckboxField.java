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
import com.kodemore.validator.KmValidator;

public class ScCheckboxField
    extends ScInputField<Boolean>
{
    //##################################################
    //# variables
    //##################################################

    private KmValidator<Boolean> _validator;

    private ScLocalBoolean _checked;

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

        _checked = new ScLocalBoolean(false);
        _changeTracking = true;
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String getInputType()
    {
        return "checkbox";
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
    //# parameters
    //##################################################

    @Override
    public void readParameters(ScServletData data)
    {
        super.readParameters(data);

        boolean exists = data.hasParameter(getExistsHtmlName());
        if ( exists )
        {
            boolean checked = hasKeyParameter(data);
            _checked.setValue(checked);
        }
    }

    private String getExistsHtmlId()
    {
        return getHtmlId() + "_exists";
    }

    private String getExistsHtmlName()
    {
        return getExistsHtmlId();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        super.renderControlOn(out);

        out.printHiddenField(getExistsHtmlName(), "true");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        boolean checked = isChecked();

        if ( getChangeTracking() )
            printOldCheckedAttributeOn(out, checked);

        if ( checked )
            out.printAttribute("checked");
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        return super.formatCss().checkbox();
    }

    //##################################################
    //# convenience
    //##################################################

    public boolean isChecked()
    {
        return _checked.isTrue();
    }

    @Override
    public Boolean getValue()
    {
        return isChecked();
    }

    public boolean isTrue()
    {
        return getValue();
    }

    public boolean isFalse()
    {
        return !isTrue();
    }

    @Override
    public void setValue(Boolean value)
    {
        _checked.setValue(value);
    }

    @Override
    public void resetValue()
    {
        _checked.resetValue();
    }

    //##################################################
    //# page session
    //##################################################

    @Override
    public void saveFieldValues()
    {
        super.saveFieldValues();
        _checked.saveValue();
    }

    @Override
    public void resetFieldValues()
    {
        super.resetFieldValues();
        _checked.resetValue();
    }

    //##################################################
    //# validator
    //##################################################

    public KmValidator<Boolean> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<Boolean> e)
    {
        _validator = e;
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    @Override
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( hasErrors() )
            return false;

        if ( _validator == null )
            return true;

        KmList<KmErrorIF> errors = new KmList<>();
        _validator.validateOnly(getValue(), errors);
        if ( errors.isEmpty() )
            return true;

        setErrors(errors);
        return false;
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxUpdateValue()
    {
        ajaxSetValue(getValue());
    }

    public void ajaxSetValue(Object e)
    {
        String value = encode(e);
        boolean checked = isChecked();

        ajax().setValue(value);
        ajax().setChecked(checked);

        if ( getChangeTracking() )
            ajax().setDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_CHECKED, checked);
    }
}
