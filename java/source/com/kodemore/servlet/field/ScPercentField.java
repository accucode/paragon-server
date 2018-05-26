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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.exception.error.KmErrorList;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.validator.KmValidator;

/**
 * I am used to enter and display percentages.
 * A value of 0.0513 is displayed as 5.13%.
 * The percentage field should be directly compatible with a double
 * field for the same underlying value. The only difference is how the
 * value is DISPLAYED to the user.
 */
public class ScPercentField
    extends ScDivWrapper
    implements ScFieldIF<Double>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The date field.
     */
    private ScDoubleField _doubleField;

    /**
     * I adapt a domain model to this field.  The value adapter is not required,
     * but when set, it allows multiple fields to be set from a single model at once.
     * In practice, adapters work best when all of the fields in a given container
     * (e.g.: a form or group) are associated with the same model.
     */
    private ScLocalAdaptor _valueAdaptor;

    /**
     * A type specific validator.
     */
    private ScLocal<KmValidator<Double>> _validator;

    //##################################################
    //# constructor
    //##################################################

    public ScPercentField()
    {
        _doubleField = new ScDoubleField();
        _doubleField.setLabel("Date");

        ScDiv root;
        root = getInner();
        root.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        root.add(_doubleField);
        root.addTextSpan("%").css().bold();

        _valueAdaptor = new ScLocalAdaptor();
        _validator = new ScLocal<>();
    }

    //##################################################
    //# meta
    //##################################################

    public void setMeta(KmMetaProperty<?,Double> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setValidator(x);
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _doubleField.getChangeTracking();
    }

    public void setChangeTracking(boolean e)
    {
        _doubleField.setChangeTracking(e);
    }

    public void disableChangeTracking()
    {
        _doubleField.disableChangeTracking();
    }

    //##################################################
    //# listeners
    //##################################################

    public void onInput(ScAction e)
    {
        _doubleField.onInput(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Double getValue()
    {
        Double percent = _doubleField.getValue();
        return percentToRate(percent);
    }

    @Override
    public void setValue(Double rate)
    {
        Double percent = rateToPercent(rate);
        _doubleField.setValue(percent);
    }

    @Override
    public void saveValue()
    {
        _doubleField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _doubleField.resetValue();
    }

    public void clearValue()
    {
        setValue(null);
    }

    //==================================================
    //= encodable
    //==================================================

    @Override
    public Object getEncodableValue()
    {
        return getValue();
    }

    @Override
    public void setEncodableValue(Object e)
    {
        setValue((Double)e);
    }

    //##################################################
    //# value adaptor
    //##################################################

    @SuppressWarnings("rawtypes")
    public final KmAdaptorIF getValueAdaptor()
    {
        return _valueAdaptor.getValue();
    }

    @SuppressWarnings("rawtypes")
    public final void setValueAdaptor(KmAdaptorIF e)
    {
        _valueAdaptor.setValue(e);
    }

    public final void clearValueAdaptor()
    {
        _valueAdaptor.clearValue();
    }

    public final boolean hasValueAdaptor()
    {
        return _valueAdaptor.hasValue();
    }

    //##################################################
    //# validator
    //##################################################

    public final KmValidator<Double> getValidator()
    {
        return _validator.getValue();
    }

    public final void setValidator(KmValidator<Double> e)
    {
        _validator.setValue(e);

        if ( e == null )
            _doubleField.clearValidator();
        else
            _doubleField.setRequired(e.isRequired());
    }

    public final void setValidator(KmMetaProperty<?,Double> p)
    {
        setValidator(p.getValidator());
    }

    public final void clearValidator()
    {
        setValidator((KmValidator<Double>)null);
    }

    public final boolean hasValidator()
    {
        return _validator != null;
    }

    //==================================================
    //= required
    //==================================================

    public void setRequired(boolean e)
    {
        _doubleField.setRequired(e);
    }

    public final void setRequired()
    {
        _doubleField.setRequired();
    }

    public final void setOptional()
    {
        _doubleField.setOptional();
    }

    @Override
    public final boolean isRequired()
    {
        return hasValidator() && getValidator().isRequired();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        if ( hasErrors() )
            return;

        validateParse();
        if ( hasErrors() )
            return;

        validateValidator();
    }

    /**
     * Validate if the value can be parsed.  This allows text oriented
     * fields to validate the parsing of text-to-value BEFORE the
     * subsequent value is validated.
     *
     * Does nothing by default.
     * Most classes do not need to override this.
     */
    protected void validateParse()
    {
        // none
    }

    private void validateValidator()
    {
        if ( !hasValidator() )
            return;

        KmErrorList errors = getValidator().getValidationErrors(getValue());
        _doubleField.setErrors(errors);
    }

    //##################################################
    //# help
    //##################################################

    @Override
    public void setHelp(String e)
    {
        _doubleField.setHelp(e);
    }

    @Override
    public void setHelp(KmMetaAttribute<?,?> e)
    {
        setHelp(e.getHelp());
    }

    //##################################################
    //# model
    //##################################################

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyFromModel_here(Object model)
    {
        super.applyFromModel_here(model);

        if ( _valueAdaptor.hasValue() )
        {
            Double value = (Double)_valueAdaptor.getValue().getValue(model);
            setValue(value);
        }

        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyToModel_here(Object model)
    {
        if ( _valueAdaptor.hasValue() )
        {
            Double value = getValue();
            _valueAdaptor.getValue().setValue(model, value);
        }
        return true;
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScVisibilityScript ajaxShow(boolean visible)
    {
        return getInner().ajaxShow(visible);
    }

    @Override
    public void ajaxSetFieldValue(Double rate)
    {
        ajaxSetFieldValue(rate, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(Double rate, boolean updateOldValue)
    {
        Double percent = rateToPercent(rate);
        _doubleField.ajaxSetFieldValue(percent, updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        Double rate = getValue();
        ajaxSetFieldValue(rate, updateOldValue);
    }

    //##################################################
    //# convert
    //##################################################

    private Double percentToRate(Double percent)
    {
        return percent == null
            ? null
            : percent / 100.0;
    }

    private Double rateToPercent(Double rate)
    {
        return rate == null
            ? null
            : rate * 100.0;
    }

}
