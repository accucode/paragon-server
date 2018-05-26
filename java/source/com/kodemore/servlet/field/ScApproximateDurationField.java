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
import com.kodemore.collection.KmList;
import com.kodemore.exception.KmEnumException;
import com.kodemore.exception.error.KmErrorList;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.time.KmDuration;
import com.kodemore.time.KmTimeConstantsIF;
import com.kodemore.time.KmTimeUnit;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmValidator;

public class ScApproximateDurationField
    extends ScDivWrapper
    implements ScFieldIF<KmDuration>, KmTimeConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The editable value field.
     */
    private ScDoubleField _valueField;

    /**
     * The unit field (hour/minute/seconds).
     */
    private ScStaticEnumDropdownField _unitField;

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
    private ScLocal<KmValidator<KmDuration>> _validator;

    //##################################################
    //# constructor
    //##################################################

    public ScApproximateDurationField()
    {
        ScDiv root;
        root = getInner();
        root.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        root.add(createValueField());
        root.add(createUnitField());

        _valueAdaptor = new ScLocalAdaptor();
        _validator = new ScLocal<>();
    }

    private ScControl createValueField()
    {
        ScDoubleField e;
        e = new ScDoubleField();
        _valueField = e;
        return e;
    }

    private ScControl createUnitField()
    {
        KmList<KmTimeUnit> v;
        v = new KmList<>();
        v.add(KmTimeUnit.Second);
        v.add(KmTimeUnit.Minute);
        v.add(KmTimeUnit.Hour);
        v.add(KmTimeUnit.Day);

        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setEnumOptions(v);
        e.setNullSelectPrefix();
        e.setRequired();
        _unitField = e;
        return e;
    }

    //##################################################
    //# unit
    //##################################################

    public void setUnitSeconds()
    {
        _unitField.setValue(KmTimeUnit.Second);
    }

    public void setUnitMinutes()
    {
        _unitField.setValue(KmTimeUnit.Minute);
    }

    public void setUnitHours()
    {
        _unitField.setValue(KmTimeUnit.Hour);
    }

    public void setUnitDays()
    {
        _unitField.setValue(KmTimeUnit.Day);
    }

    //##################################################
    //# delegate
    //##################################################

    public void disableChangeTracking()
    {
        _valueField.disableChangeTracking();
        _unitField.disableChangeTracking();
    }

    //##################################################
    //# meta
    //##################################################

    public void setMeta(KmMetaProperty<?,KmDuration> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setValidator(x);
    }

    //##################################################
    //# help
    //##################################################

    @Override
    public void setHelp(KmMetaAttribute<?,?> e)
    {
        _valueField.setHelp(e);
    }

    @Override
    public void setHelp(String e)
    {
        _valueField.setHelp(e);
    }

    @Override
    public String getHelp()
    {
        return _valueField.getHelp();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmDuration getValue()
    {
        if ( !_valueField.hasValue() )
            return null;

        String unitCode = _unitField.getValue();
        KmTimeUnit unit = KmTimeUnit.findCode(unitCode);

        switch ( unit )
        {
            case Second:
                return valueFromSeconds();

            case Minute:
                return valueFromMinutes();

            case Hour:
                return valueFromHours();

            case Day:
                return valueFromDays();

            case Week:
                return valueFromWeeks();

            case Month:
                return valueFromMonths();

            case Year:
                return valueFromYears();
        }
        throw new KmEnumException(unit);
    }

    @Override
    public void setValue(KmDuration e)
    {
        if ( e == null )
        {
            _valueField.clearValue();
            return;
        }

        KmTimeUnit unit = estimateBestUnitFor(e);

        _unitField.setValue(unit.getCode());
        _valueField.setValue(getFieldValueFor(e, unit));
    }

    //==================================================
    //= value :: save
    //==================================================

    @Override
    public void saveValue()
    {
        _valueField.saveValue();
        _unitField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _valueField.resetValue();
        _unitField.resetValue();
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
        setValue((KmDuration)e);
    }

    @Override
    protected void readParameters_after()
    {
        setValue(getValue());
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

    public final KmValidator<KmDuration> getValidator()
    {
        return _validator.getValue();
    }

    public final void setValidator(KmValidator<KmDuration> e)
    {
        _validator.setValue(e);

        if ( e == null )
            _valueField.clearValidator();
        else
            _valueField.setRequired(e.isRequired());
    }

    public final void setValidator(KmMetaProperty<?,KmDuration> p)
    {
        setValidator(p.getValidator());
    }

    public final void clearValidator()
    {
        setValidator((KmValidator<KmDuration>)null);
    }

    public final boolean hasValidator()
    {
        return _validator.hasValue();
    }

    public final void setRequired()
    {
        KmValidator<KmDuration> e = ScUtility.toRequiredValidator(getValidator());
        setValidator(e);
    }

    public final void setOptional()
    {
        KmValidator<KmDuration> e = ScUtility.toOptionalValidator(getValidator());
        setValidator(e);
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
     * This does nothing by default.
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
        _valueField.setErrors(errors);
    }

    public void addError(String msg, Object... args)
    {
        _valueField.addError(msg, args);
    }

    public void addErrorAndCheck(String msg, Object... args)
    {
        addError(msg, args);
        checkErrors();
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
            KmDuration value = (KmDuration)_valueAdaptor.getValue().getValue(model);
            setValue(value);
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyToModel_here(Object model)
    {
        if ( _valueAdaptor.hasValue() )
        {
            KmDuration value = getValue();
            _valueAdaptor.getValue().setValue(model, value);
        }
        return false;
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
    public void ajaxSetFieldValue(KmDuration e)
    {
        if ( e == null )
        {
            _valueField.ajaxSetFieldValue(null);
            return;
        }

        KmTimeUnit unit = estimateBestUnitFor(e);
        _unitField.ajaxSetFieldValue(unit.getCode());
        _valueField.ajaxSetFieldValue(getFieldValueFor(e, unit));
    }

    @Override
    public void ajaxSetFieldValue(KmDuration e, boolean updateOldValue)
    {
        if ( e == null )
        {
            _valueField.ajaxSetFieldValue(null, updateOldValue);
            return;
        }

        KmTimeUnit unit = estimateBestUnitFor(e);
        _unitField.ajaxSetFieldValue(unit.getCode(), updateOldValue);
        _valueField.ajaxSetFieldValue(getFieldValueFor(e, unit), updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        _valueField.ajaxUpdateFieldValue_here(updateOldValue);
        _unitField.ajaxUpdateFieldValue_here(updateOldValue);
    }

    //##################################################
    //# support
    //##################################################

    private KmTimeUnit estimateBestUnitFor(KmDuration e)
    {
        KmDuration abs = e.abs();

        double h = abs.getTotalHoursExact();
        if ( h > 23 )
            return KmTimeUnit.Day;

        double m = abs.getTotalMinutesExact();
        if ( m > 50 )
            return KmTimeUnit.Hour;

        double s = abs.getTotalSecondsExact();
        if ( s > 50 )
            return KmTimeUnit.Minute;

        return KmTimeUnit.Second;
    }

    //==================================================
    //= support :: value
    //==================================================

    private Double getFieldValueFor(KmDuration e, KmTimeUnit unit)
    {
        if ( e == null )
            return null;

        switch ( unit )
        {
            case Second:
                return Kmu.round(e.getTotalSecondsExact(), 0);

            case Minute:
                return Kmu.round(e.getTotalMinutesExact(), 1);

            case Hour:
                return Kmu.round(e.getTotalHoursExact(), 2);

            case Day:
                return Kmu.round(e.getTotalDaysExact(), 1);

            case Week:
                return Kmu.toDouble(e.getTotalWeeks());

            case Month:
                return Kmu.toDouble(e.getTotalMonths());

            case Year:
                return Kmu.toDouble(e.getTotalYears());
        }
        throw new KmEnumException(unit);
    }

    private KmDuration valueFromSeconds()
    {
        double value = _valueField.getValue();
        long secs = (long)value;
        return KmDuration.fromSeconds(secs);
    }

    private KmDuration valueFromMinutes()
    {
        Double value = _valueField.getValue();
        long secs = (long)(value * SECONDS_PER_MINUTE);
        return KmDuration.fromSeconds(secs);
    }

    private KmDuration valueFromHours()
    {
        Double value = _valueField.getValue();
        long secs = (long)(value * SECONDS_PER_HOUR);
        return KmDuration.fromSeconds(secs);
    }

    private KmDuration valueFromDays()
    {
        Double value = _valueField.getValue();
        long secs = (long)(value * SECONDS_PER_DAY);
        return KmDuration.fromSeconds(secs);
    }

    private KmDuration valueFromWeeks()
    {
        Double value = _valueField.getValue();
        long secs = (long)(value * SECONDS_PER_WEEK);
        return KmDuration.fromSeconds(secs);
    }

    private KmDuration valueFromMonths()
    {
        Double value = _valueField.getValue();
        long secs = (long)(value * SECONDS_PER_MONTH_APPROXIMATE);
        return KmDuration.fromSeconds(secs);
    }

    private KmDuration valueFromYears()
    {
        Double value = _valueField.getValue();
        long secs = (long)(value * SECONDS_PER_YEAR_APPROXIMATE);
        return KmDuration.fromSeconds(secs);
    }
}
