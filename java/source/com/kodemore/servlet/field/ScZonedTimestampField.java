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
 * I am implemented as a composite of date, time, and time zone.
 *
 * My value is always is always in UTC, but my time zone
 * dropdown is used to convert the timestamp for display/enter.
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
    private ScDateField              _dateField;

    /**
     * The editable time field (hh:mm).
     */
    private ScTimeField              _timeField;

    /**
     * The selectable time zone. The time zone is used ONLY for
     * display purposes. The timestamp value is always converted
     * to UTC for internal persistence.
     */
    private ScDropdownField<String>  _zoneField;

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
     * An optional link that updates fields with the current time.
     * Hidden by default.
     */
    private ScLink                   _nowLink;

    /**
     * An optional link that clear the fields.
     * Hidden by default.
     */
    private ScLink                   _clearLink;

    //##################################################
    //# constructor
    //##################################################

    public ScZonedTimestampField()
    {
        _dateField = new ScDateField();
        _timeField = new ScTimeField();

        _zoneField = new ScDropdownField<>();
        _zoneField.setNullSelectPrefix();
        setZoneOptions(KmTimeZone.getCommonZones(), KmTimeZone.getAllZones());

        ScDiv root;
        root = getInner();
        root.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        root.add(_dateField);
        root.add(_timeField);
        root.add(_zoneField);

        _nowLink = root.addLink("now", newUncheckedAction(this::handleNow));
        _nowLink.hide();

        _clearLink = root.addLink("clear", newUncheckedAction(this::handleClear));
        _clearLink.hide();

        _valueAdaptor = new ScLocalAdaptor();
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

    public KmTimeZone getZone()
    {
        String code = _zoneField.getValue();
        return KmTimeZone.findCode(code);
    }

    public void setZone(KmTimeZone e)
    {
        _zoneField.setValue(KmTimeZone.getCodeFor(e));
        _zoneField.ensureValidValue();
    }

    public void setZoneOptions(KmList<KmTimeZone> common, KmList<KmTimeZone> all)
    {
        _zoneField.clearOptions();

        for ( KmTimeZone e : common )
            _zoneField.addOption(e.getCode(), e.getName());

        _zoneField.addOption(null, "--------------------");

        for ( KmTimeZone e : all )
            _zoneField.addOption(e.getCode(), e.getName());
    }

    public boolean hasZone()
    {
        return getZone() != null;
    }

    public KmTimeZone ensureZone()
    {
        if ( !_zoneField.hasValue() )
            _zoneField.setValue(getDefaultZone().getCode());

        return getZone();
    }

    private KmTimeZone getDefaultZone()
    {
        return KmTimeZone.UTC;
    }

    //##################################################
    //# delegate
    //##################################################

    public void disableChangeTracking()
    {
        _dateField.disableChangeTracking();
        _timeField.disableChangeTracking();
        _zoneField.disableChangeTracking();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmTimestamp getValue()
    {
        KmDate date = _dateField.getValue();
        KmTime time = _timeField.getValue();
        KmTimeZone zone = getZone();

        if ( date == null || time == null || zone == null )
            return null;

        return KmTimestamp.fromDateTime(date, time).toUtc(zone);
    }

    @Override
    public void setValue(KmTimestamp utc)
    {
        KmTimeZone zone = ensureZone();

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

    @Override
    public void saveValue()
    {
        _dateField.saveValue();
        _timeField.saveValue();
        _zoneField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _dateField.resetValue();
        _timeField.resetValue();
        _zoneField.resetValue();
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

    public void error(String msg, Object... args)
    {
        _dateField.error(msg, args);
    }

    public void addError(String msg, Object... args)
    {
        _dateField.addError(msg, args);
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
        KmTimeZone zone = getZone();
        if ( zone == null )
            zone = getDefaultZone();

        if ( utc == null )
        {
            _dateField.ajaxSetFieldValue(null);
            _timeField.ajaxSetFieldValue(null);
            return;
        }

        KmTimestamp local = utc.toLocal(zone);

        _dateField.ajaxSetFieldValue(local.getDate());
        _timeField.ajaxSetFieldValue(local.getTime());
        _zoneField.ajaxSetFieldValue(zone.getCode());
    }

    @Override
    public void ajaxSetFieldValue(KmTimestamp utc, boolean updateOldValue)
    {
        KmTimeZone zone = getZone();
        if ( zone == null )
            zone = getDefaultZone();

        if ( utc == null )
        {
            _dateField.ajaxSetFieldValue(null);
            _timeField.ajaxSetFieldValue(null);
            return;
        }

        KmTimestamp local = utc.toLocal(zone);

        _dateField.ajaxSetFieldValue(local.getDate(), updateOldValue);
        _timeField.ajaxSetFieldValue(local.getTime(), updateOldValue);
        _zoneField.ajaxSetFieldValue(zone.getCode(), updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        _dateField.ajaxUpdateFieldValue_here(updateOldValue);
        _timeField.ajaxUpdateFieldValue_here(updateOldValue);
        _zoneField.ajaxUpdateFieldValue_here(updateOldValue);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleNow()
    {
        KmTimeZone zone = ensureZone();
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
