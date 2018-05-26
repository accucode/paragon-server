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
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocal;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimeZoneBridge;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmValidator;

/**
 * I am used to display and edit a timestamp (date + time).
 * I am implemented as a composite of date, time, and time zone.
 *
 * My value is always is always in UTC, but my time zone
 * dropdown is used to convert the timestamp for display/entry.
 */
public class ScZonedTimestampField
    extends ScDivWrapper
    implements ScFieldIF<KmTimestamp>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The editable date field (mm/dd/yy).
     */
    private ScDateField _dateField;

    /**
     * The editable time field (hh:mm).
     */
    private ScTimeField _timeField;

    /**
     * The selectable time zone. The time zone is used ONLY for
     * display purposes. The timestamp value is always converted
     * to UTC for internal persistence.
     */
    private ScTimeZoneField _timeZoneField;

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
    private ScLocal<KmValidator<KmTimestamp>> _validator;

    /**
     * An optional link that updates fields with the current time.
     * Hidden by default.
     */
    private ScLink _nowLink;

    /**
     * An optional link that clear the fields.
     * Hidden by default.
     */
    private ScLink _clearLink;

    //##################################################
    //# constructor
    //##################################################

    public ScZonedTimestampField()
    {
        _dateField = new ScDateField();
        _timeField = new ScTimeField();

        _timeZoneField = new ScTimeZoneField();
        _timeZoneField.setNullSelectPrefix();

        ScDiv root;
        root = getInner();
        root.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        root.add(_dateField);
        root.add(_timeField);
        root.add(_timeZoneField);

        _nowLink = root.addLink("now", newUncheckedAction(this::handleNow));
        _nowLink.hide();

        _clearLink = root.addLink("clear", newUncheckedAction(this::handleClear));
        _clearLink.hide();

        _valueAdaptor = new ScLocalAdaptor();
        _validator = new ScLocal<>();
    }

    //##################################################
    //# links
    //##################################################

    public void showNowLink()
    {
        _nowLink.show();
    }

    public void showClearLink()
    {
        _clearLink.show();
    }

    //##################################################
    //# time zone
    //##################################################

    public KmTimeZone getTimeZone()
    {
        return _timeZoneField.getValue();
    }

    public void setTimeZone(KmTimeZone e)
    {
        if ( e == null )
            throw Kmu.newFatal("Cannot set null time zone.");

        KmTimestamp utc = getValue();

        _timeZoneField.setValue(e);
        _timeZoneField.ensureValidValue();

        if ( !_timeZoneField.hasValue() )
            throw Kmu.newFatal("Selected time zone is not a valid option.");

        setValue(utc);
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
    }

    public KmTimeZone ensureTimeZone()
    {
        if ( hasTimeZone() )
            return getTimeZone();

        KmTimeZone def = getDefaultTimeZone();
        if ( def == null )
            throw Kmu.newFatal("Cannot determine default time zone.");

        setTimeZone(def);
        return def;
    }

    private KmTimeZone getDefaultTimeZone()
    {
        return KmTimeZoneBridge.getInstance().getLocalZone();
    }

    public void disableTimeZone()
    {
        _timeZoneField.disable();
    }

    //##################################################
    //# delegate
    //##################################################

    public void disableChangeTracking()
    {
        _dateField.disableChangeTracking();
        _timeField.disableChangeTracking();
        _timeZoneField.disableChangeTracking();
    }

    public void onTypeWatch(ScAction e)
    {
        _dateField.onTypeWatch(e);
        _timeField.onTypeWatch(e);
        _timeZoneField.onChange(e);
    }

    //##################################################
    //# meta
    //##################################################

    public void setMeta(KmMetaProperty<?,KmTimestamp> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setValidator(x);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValue()
    {
        KmDate date = _dateField.getValue();
        KmTime time = _timeField.getValue();
        KmTimeZone zone = getTimeZone();

        if ( date == null || time == null || zone == null )
            return null;

        return KmTimestamp.fromDateTime(date, time).toUtc(zone);
    }

    public void setValue(KmTimestamp utc, KmTimeZone zone)
    {
        setTimeZone(zone);
        setValue(utc);
    }

    @Override
    public void setValue(KmTimestamp utc)
    {
        KmTimeZone zone = ensureTimeZone();

        if ( utc == null )
        {
            _dateField.setValue(null);
            _timeField.setValue(null);
            return;
        }

        KmTimestamp local = utc.toLocal(zone);

        _dateField.setValue(local.getDate());
        _timeField.setValue(local.getTime());
    }

    public void clearValue()
    {
        setValue(null);
    }

    @Override
    public void saveValue()
    {
        _dateField.saveValue();
        _timeField.saveValue();
        _timeZoneField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _dateField.resetValue();
        _timeField.resetValue();
        _timeZoneField.resetValue();
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
        return _validator.getValue();
    }

    public final void setValidator(KmValidator<KmTimestamp> e)
    {
        _validator.setValue(e);

        if ( e == null )
        {
            _dateField.clearValidator();
            _timeField.clearValidator();
        }
        else
        {
            _dateField.setRequired(e.isRequired());
            _timeField.setRequired(e.isRequired());
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
        return _validator.hasValue();
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
        _dateField.setErrors(errors);
    }

    public void addError(String msg, Object... args)
    {
        _dateField.addError(msg, args);
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
            KmTimestamp value = (KmTimestamp)_valueAdaptor.getValue().getValue(model);
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
            KmTimestamp value = getValue();
            _valueAdaptor.getValue().setValue(model, value);
        }
        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        ensureTimeZone();
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
    public void ajaxSetFieldValue(KmTimestamp utc)
    {
        KmTimeZone zone = getTimeZone();
        if ( zone == null )
            zone = getDefaultTimeZone();

        if ( utc == null )
        {
            _dateField.ajaxSetFieldValue(null);
            _timeField.ajaxSetFieldValue(null);
            return;
        }

        KmTimestamp local = utc.toLocal(zone);

        _dateField.ajaxSetFieldValue(local.getDate());
        _timeField.ajaxSetFieldValue(local.getTime());
        _timeZoneField.ajaxSetFieldValue(zone);
    }

    @Override
    public void ajaxSetFieldValue(KmTimestamp utc, boolean updateOldValue)
    {
        KmTimeZone zone = getTimeZone();
        if ( zone == null )
            zone = getDefaultTimeZone();

        if ( utc == null )
        {
            _dateField.ajaxSetFieldValue(null);
            _timeField.ajaxSetFieldValue(null);
            return;
        }

        KmTimestamp local = utc.toLocal(zone);

        _dateField.ajaxSetFieldValue(local.getDate(), updateOldValue);
        _timeField.ajaxSetFieldValue(local.getTime(), updateOldValue);
        _timeZoneField.ajaxSetFieldValue(zone, updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        _dateField.ajaxUpdateFieldValue_here(updateOldValue);
        _timeField.ajaxUpdateFieldValue_here(updateOldValue);
        _timeZoneField.ajaxUpdateFieldValue_here(updateOldValue);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleNow()
    {
        KmTimeZone zone = ensureTimeZone();
        if ( zone == null )
        {
            ajaxToast("Select a time zone.");
            return;
        }

        ajaxSetFieldValue(KmClock.getUtcTimestamp(), false);
    }

    private void handleClear()
    {
        _dateField.ajaxClearFieldValue();
        _timeField.ajaxClearFieldValue();
    }

}
