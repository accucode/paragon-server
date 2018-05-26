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
import com.kodemore.exception.error.KmErrorList;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.time.KmTimeConstantsIF;
import com.kodemore.time.KmTimeUnit;
import com.kodemore.time.KmUnitDuration;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmValidator;

public class ScUnitDurationField
    extends ScDivWrapper
    implements ScFieldIF<KmUnitDuration>, KmTimeConstantsIF
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
    private ScLocal<KmValidator<KmUnitDuration>> _validator;

    /**
     * The minimum (smallest) unit to show as an option
     */
    private ScLocalString _minimumUnitCode;

    /**
     * The maximum (largest) unit to show as an option
     */
    private ScLocalString _maximumUnitCode;

    //##################################################
    //# constructor
    //##################################################

    public ScUnitDurationField()
    {
        ScDiv root;
        root = getInner();
        root.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        root.add(createValueField());
        root.add(createUnitField());

        _valueAdaptor = new ScLocalAdaptor();
        _validator = new ScLocal<>();

        _minimumUnitCode = new ScLocalString();
        _maximumUnitCode = new ScLocalString();
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
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setNullSelectPrefix();
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

    //==================================================
    //= unit :: options
    //==================================================

    public void setUnitOptionsMinutesToWeeks()
    {
        setMinimumUnit(KmTimeUnit.Minute);
        setMaximumUnit(KmTimeUnit.Week);
    }

    public KmTimeUnit getMinimumUnit()
    {
        String code = _minimumUnitCode.getValue();
        return KmTimeUnit.findCode(code);
    }

    public void setMinimumUnit(KmTimeUnit e)
    {
        if ( e == null )
        {
            _minimumUnitCode.clearValue();
            return;
        }

        _minimumUnitCode.setValue(e.getCode());
    }

    public KmTimeUnit getMaximumUnit()
    {
        String code = _maximumUnitCode.getValue();
        return KmTimeUnit.findCode(code);
    }

    public void setMaximumUnit(KmTimeUnit e)
    {
        if ( e == null )
        {
            _maximumUnitCode.clearValue();
            return;
        }

        _maximumUnitCode.setValue(e.getCode());
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

    public void setMeta(KmMetaProperty<?,KmUnitDuration> x)
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
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderUnitField();
    }

    private void preRenderUnitField()
    {
        KmList<KmTimeUnit> v;
        v = getUnitOptions();

        if ( _unitField.hasValue() )
        {
            KmTimeUnit selected;
            selected = KmTimeUnit.findCode(_unitField.getValue());
            v.addDistinct(selected);
        }

        _unitField.setEnumOptions(v);
    }

    private KmList<KmTimeUnit> getUnitOptions()
    {
        if ( _minimumUnitCode.isEmpty() && _maximumUnitCode.isEmpty() )
            return KmTimeUnit.getValues();

        return KmTimeUnit.getValues(getMinimumUnit(), getMaximumUnit());
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmUnitDuration getValue()
    {
        if ( !_valueField.hasValue() )
            return null;

        if ( !_unitField.hasValue() )
            return null;

        Double value = _valueField.getValue();
        String unitCode = _unitField.getValue();
        KmTimeUnit unit = KmTimeUnit.findCode(unitCode);

        return new KmUnitDuration(value, unit);
    }

    @Override
    public void setValue(KmUnitDuration e)
    {
        if ( e == null )
        {
            _valueField.clearValue();
            _unitField.clearValue();
            return;
        }

        _valueField.setValue(e.getValue());
        _unitField.setValue(e.getUnit());
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
        setValue((KmUnitDuration)e);
    }

    @Override
    protected void readParameters_after()
    {
        if ( _valueField.hasValue() )
        {
            int i = KmUnitDuration.PRECISION;
            Double value = _valueField.getValue();
            double converted = Kmu.round(value, i);
            _valueField.setValue(converted);
        }
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

    public final KmValidator<KmUnitDuration> getValidator()
    {
        return _validator.getValue();
    }

    public final void setValidator(KmValidator<KmUnitDuration> e)
    {
        _validator.setValue(e);

        if ( e != null )
            _valueField.setRequired(e.isRequired());
    }

    public final void setValidator(KmMetaProperty<?,KmUnitDuration> p)
    {
        setValidator(p.getValidator());
    }

    public final void clearValidator()
    {
        setValidator((KmValidator<KmUnitDuration>)null);
    }

    public final boolean hasValidator()
    {
        return _validator.hasValue();
    }

    public final void setRequired()
    {
        KmValidator<KmUnitDuration> e = ScUtility.toRequiredValidator(getValidator());
        setValidator(e);
    }

    public final void setOptional()
    {
        KmValidator<KmUnitDuration> e = ScUtility.toOptionalValidator(getValidator());
        setValidator(e);
    }

    @Override
    public final boolean isRequired()
    {
        return hasValidator() && getValidator().isRequired();
    }

    //##################################################
    //# on change
    //##################################################

    public void onChange(ScAction e)
    {
        _valueField.onTypeWatch(e);
        _unitField.onChange(e);
    }

    //##################################################
    //# typeWatch
    //##################################################

    public void onTypeWatch(ScAction e)
    {
        _valueField.onTypeWatch(e);
        _unitField.onChange(e);
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

        validateUnit();
        if ( hasErrors() )
            return;

        validateValidator();
    }

    protected void validateUnit()
    {
        if ( !_valueField.hasValue() )
            return;

        if ( !_unitField.hasValue() )
            addError("Unit is required");
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
            KmUnitDuration value = (KmUnitDuration)_valueAdaptor.getValue().getValue(model);
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
            KmUnitDuration value = getValue();
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
    public void ajaxSetFieldValue(KmUnitDuration e)
    {
        if ( e == null )
        {
            _valueField.ajaxSetFieldValue(null);
            return;
        }

        KmTimeUnit unit = e.getUnit();
        _unitField.ajaxSetFieldValue(unit.getCode());
        _valueField.ajaxSetFieldValue(e.getValue());
    }

    @Override
    public void ajaxSetFieldValue(KmUnitDuration e, boolean updateOldValue)
    {
        if ( e == null )
        {
            _valueField.ajaxSetFieldValue(null, updateOldValue);
            return;
        }

        KmTimeUnit unit = e.getUnit();
        _unitField.ajaxSetFieldValue(unit.getCode(), updateOldValue);
        _valueField.ajaxSetFieldValue(e.getValue(), updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        _valueField.ajaxUpdateFieldValue_here(updateOldValue);
        _unitField.ajaxUpdateFieldValue_here(updateOldValue);
    }
}
