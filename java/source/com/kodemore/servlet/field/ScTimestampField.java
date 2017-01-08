/*
  Copyright (c) 2005-2016 www.kodemore.com

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
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmValidator;

/**
 * I am used to display and edit a timestamp (date + time).
 * I am implemented as a composite of an ScDateField and ScTimeField.
 */
public class ScTimestampField
    extends ScDivWrapper
    implements ScFieldIF<KmTimestamp>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The date field.
     */
    private ScDateField              _dateField;

    /**
     * The time field.
     */
    private ScTimeField              _timeField;

    /**
     * I adapt a domain model to this field.  The value adapter is not required,
     * but when set, it allows multiple fields to be set from a single model at once.
     * In practice, adapters work best when all of the fields in a given container
     * (e.g.: a form or group) are associated with the same model.
     */
    private ScLocalAdaptor           _valueAdaptor;

    /**
     * A type specific validator.
     */
    private KmValidator<KmTimestamp> _validator;

    /**
     * A link that displays "now", it automatically updates the date/time
     * when clicked. The link is visible by default, but can be hidden.
     */
    private ScLink                   _nowLink;

    /**
     * The timezone that will be used when clicking the now link.  If not set, it
     * will default to the local timezone.
     */
    private KmTimeZone               _timeZone;

    //##################################################
    //# constructor
    //##################################################

    public ScTimestampField()
    {
        _dateField = new ScDateField();
        _dateField.setLabel("Date");

        _timeField = new ScTimeField();
        _timeField.setLabel("Time");

        ScDiv root;
        root = getInner();
        root.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        root.add(_dateField);
        root.add(_timeField);

        _nowLink = root.addLink("now", newUncheckedAction(this::handleNow));

        _valueAdaptor = new ScLocalAdaptor();
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _dateField.getChangeTracking();
    }

    public void setChangeTracking(boolean e)
    {
        _dateField.setChangeTracking(e);
        _timeField.setChangeTracking(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValue()
    {
        KmDate date = _dateField.getValue();
        KmTime time = _timeField.getValue();

        return date == null || time == null
            ? null
            : KmTimestamp.fromDateTime(date, time);
    }

    @Override
    public void setValue(KmTimestamp e)
    {
        _dateField.setValue(dateFor(e));
        _timeField.setValue(timeFor(e));
    }

    @Override
    public void saveValue()
    {
        _dateField.saveValue();
        _timeField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _dateField.resetValue();
        _timeField.resetValue();
    }

    public void clearValue()
    {
        setValue(null);
    }

    //==================================================
    //= zone
    //==================================================

    public KmTimestamp getUtcValue(KmTimeZone from)
    {
        KmTimeZone to = KmTimeZone.UTC;
        return KmTimestamp.changeZone(getValue(), from, to);
    }

    public void setUtcValue(KmTimestamp utcTs, KmTimeZone to)
    {
        KmTimeZone from = KmTimeZone.UTC;
        KmTimestamp localTs = KmTimestamp.changeZone(utcTs, from, to);
        setValue(localTs);
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
        setValue((KmTimestamp)e);
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

    public final KmValidator<KmTimestamp> getValidator()
    {
        return _validator;
    }

    public final void setValidator(KmValidator<KmTimestamp> e)
    {
        _validator = e;

        if ( _validator == null )
        {
            _dateField.clearValidator();
            _timeField.clearValidator();
        }
        else
        {
            _dateField.setRequired(_validator.isRequired());
            _timeField.setRequired(_validator.isRequired());
        }
    }

    public final void setValidator(KmMetaProperty<?,KmTimestamp> p)
    {
        setValidator(p.getValidator());
    }

    public final void clearValidator()
    {
        setValidator((KmValidator<KmTimestamp>)null);
    }

    public final boolean hasValidator()
    {
        return _validator != null;
    }

    public final void setRequired()
    {
        KmValidator<KmTimestamp> e = ScUtility.toRequiredValidator(getValidator());
        setValidator(e);
    }

    public final void setOptional()
    {
        KmValidator<KmTimestamp> e = ScUtility.toOptionalValidator(getValidator());
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
    public boolean validateQuietly()
    {
        if ( !super.validateQuietly() )
            return false;

        if ( hasErrors() )
            return false;

        if ( !validateParse() )
            return false;

        return validateValidator();
    }

    /**
     * Validate if the value can be parsed.  This allows text oriented
     * fields to validate the parsing of text-to-value BEFORE the
     * subsequent value is validated.
     *
     * This returns true by default.
     * Most classes do not need to override this.
     */
    protected boolean validateParse()
    {
        return true;
    }

    private boolean validateValidator()
    {
        if ( !hasValidator() )
            return true;

        KmList<KmErrorIF> errors = new KmList<>();
        getValidator().validateOnly(getValue(), errors);

        if ( errors.isEmpty() )
            return true;

        _dateField.setErrors(errors);
        return false;
    }

    //##################################################
    //# model
    //##################################################

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyFromModel_here(Object model, boolean skipEditableFields)
    {
        if ( skipEditableFields )
            return true;

        super.applyFromModel_here(model, skipEditableFields);

        if ( _valueAdaptor.hasValue() )
        {
            KmTimestamp value = (KmTimestamp)_valueAdaptor.getValue().getValue(model);
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
            KmTimestamp value = getValue();
            _valueAdaptor.getValue().setValue(model, value);
        }
        return true;
    }

    //##################################################
    //# now link
    //##################################################

    public void hideNowLink()
    {
        _nowLink.hide();
    }

    public void ajaxHideNowLink()
    {
        _nowLink.ajaxHide();
    }

    //##################################################
    //# time zone
    //##################################################

    public KmTimeZone getTimeZone()
    {
        return _timeZone;
    }

    public void setTimeZone(KmTimeZone e)
    {
        _timeZone = e;
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
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
    public void ajaxSetFieldValue(KmTimestamp e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(KmTimestamp e, boolean updateOldValue)
    {
        _dateField.ajaxSetFieldValue(dateFor(e), updateOldValue);
        _timeField.ajaxSetFieldValue(timeFor(e), updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        _dateField.ajaxUpdateFieldValue_here(updateOldValue);
        _timeField.ajaxUpdateFieldValue_here(updateOldValue);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleNow()
    {
        KmTimestamp now;

        if ( hasTimeZone() )
            now = KmClock.getUtcTimestamp().toLocal(getTimeZone());
        else
            now = KmClock.getLocalTimestamp();

        ajaxSetFieldValue(now);
    }

    //##################################################
    //# support
    //##################################################

    private KmDate dateFor(KmTimestamp e)
    {
        return e == null
            ? null
            : e.getDate();
    }

    private KmTime timeFor(KmTimestamp e)
    {
        return e == null
            ? null
            : e.getTime();
    }
}
