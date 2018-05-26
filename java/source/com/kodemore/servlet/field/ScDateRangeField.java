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
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * http://jqueryui.com/demos/datepicker/
 */
public class ScDateRangeField
    extends ScDivWrapper
    implements ScFieldIF<KmDateRange>
{
    //##################################################
    //# enum
    //##################################################

    public enum Mode
        implements KmEnumIF
    {
        Today,
        Tomorrow,
        Yesterday,
        ThisWeek,
        NextWeek,
        LastWeek,
        ThisMonth,
        NextMonth,
        LastMonth,
        Custom;

        //##################################################
        //# accessing
        //##################################################

        @Override
        public String getLabel()
        {
            return Kmu.formatCamelCaseAsCapitalizedWords(name());
        }

        public static Mode findCode(String label)
        {
            for ( Mode e : values() )
                if ( Kmu.isEqual(label, e.getCode()) )
                    return e;

            return null;
        }
    }

    //##################################################
    //# constants
    //##################################################

    private static final int    DATE_FIELD_WIDTH       = 130;
    private static final String DATE_FIELD_PLACEHOLDER = "mm/dd/yyyy";

    //##################################################
    //# variables
    //##################################################

    private ScLocalBoolean _readonly;

    private ScStaticEnumDropdownField _modeField;
    private ScDiv                     _customFieldsRow;

    private ScDateField _startField;
    private ScDateField _endField;

    /**
     * The list of fields used in the address.
     */
    private KmList<ScField<?>> _fields;

    /**
     * If true (the default), the value is encoded into an html data- attribute
     * and the browser utilizes client-side utilizes to warn the user before
     * ajax actions if the value has changed.
     *
     * Change tracking should be set during initial page initialization, and should
     * NOT be modified while processing a page.
     */
    private boolean _changeTracking;

    /**
     * If set the applyFromModel and applyToModel will use this adaptor
     * to get/set the address.
     */
    private ScLocalAdaptor _valueAdaptor;

    private ScLocalString _modeCode;

    private ScLocalString _help;

    private Runnable _changeListener;

    //##################################################
    //# constructor
    //##################################################

    public ScDateRangeField()
    {
        _readonly = new ScLocalBoolean();

        _modeCode = new ScLocalString();
        _modeCode.setAutoSave();

        _help = new ScLocalString();

        _changeTracking = true;
        _valueAdaptor = new ScLocalAdaptor();

        installFields();
        installLayout();

        css().inlineBlock();
    }

    //##################################################
    //# install
    //##################################################

    private void installFields()
    {
        _fields = new KmList<>();
        _fields.add(createStartField());
        _fields.add(createEndField());
        _fields.add(createModeField());
    }

    private void installLayout()
    {
        ScDiv row;
        row = getInner().addDiv();
        row.css().flexRow();

        ScDiv col;
        col = row.addDiv();
        col.css().flexColumn().flexAlignStart();
        col.add(_modeField);

        row.addFlexGap(10);

        _customFieldsRow = row.addDiv();
        _customFieldsRow.css().flexRow();
        _customFieldsRow.hide();

        ScFieldTable fields;
        fields = _customFieldsRow.addFieldTable();
        fields.add(_startField);

        _customFieldsRow.addFlexGap(10);

        fields = _customFieldsRow.addFieldTable();
        fields.add(_endField);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScDateField createStartField()
    {
        ScDateField e;
        e = new ScDateField();
        e.setLabel("From");
        e.layoutInline(DATE_FIELD_WIDTH);
        e.setPlaceholder(DATE_FIELD_PLACEHOLDER);
        e.setHelp("The beginning of the date interval (inclusive)");
        e.onChange(newUncheckedAction(this::handleDateChanged));
        _startField = e;
        return e;
    }

    private ScDateField createEndField()
    {
        ScDateField e;
        e = new ScDateField();
        e.setLabel("To");
        e.layoutInline(DATE_FIELD_WIDTH);
        e.setPlaceholder(DATE_FIELD_PLACEHOLDER);
        e.setHelp("The end of the date interval (inclusive)");
        e.onChange(newUncheckedAction(this::handleDateChanged));
        _endField = e;
        return e;
    }

    private ScStaticEnumDropdownField createModeField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setOptions(Mode.values());
        e.onChange(newUncheckedAction(this::handleModeChange));
        e.setNullAnyPrefix();
        _modeField = e;
        return e;
    }

    //##################################################
    //# value adaptor
    //##################################################

    @SuppressWarnings("rawtypes")
    public KmAdaptorIF getValueAdaptor()
    {
        return _valueAdaptor.getValue();
    }

    @SuppressWarnings("rawtypes")
    public void setValueAdaptor(KmAdaptorIF e)
    {
        _valueAdaptor.setValue(e);
    }

    public void clearValueAdaptor()
    {
        _valueAdaptor.clearValue();
    }

    public boolean hasValueAdaptor()
    {
        return _valueAdaptor.hasValue();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmDateRange getValue()
    {
        KmDateRange value;
        value = new KmDateRange();
        value.setStart(_startField.getValue());
        value.setEnd(_endField.getValue());
        return value;
    }

    @Override
    public void setValue(KmDateRange e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        _startField.setValue(e.getStart());
        _endField.setValue(e.getEnd());
    }

    @Override
    public boolean hasValue()
    {
        return !getValue().isOpen();
    }

    @Override
    public void saveValue()
    {
        _modeCode.saveValue();
        _fields.forEach(e -> e.saveValue());
    }

    @Override
    public void resetValue()
    {
        _modeCode.clearValue();
        _fields.forEach(e -> e.resetValue());
    }

    public void clearValue()
    {
        _modeCode.clearValue();
        _fields.forEach(e -> e.clearValue());
    }

    //##################################################
    //# mode
    //##################################################

    private String getModeCode()
    {
        return _modeCode.getValue();
    }

    private void setModeCode(String e)
    {
        _modeCode.setValue(e);
    }

    public Mode getMode()
    {
        return Mode.findCode(getModeCode());
    }

    public void setMode(Mode e)
    {
        setModeCode(e.getCode());
    }

    public boolean hasMode()
    {
        return getMode() != null;
    }

    //##################################################
    //# help
    //##################################################

    @Override
    public String getHelp()
    {
        return _help.getValue();
    }

    @Override
    public void setHelp(String e)
    {
        _help.setValue(e);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public boolean isRequired()
    {
        return false;
    }

    //==================================================
    //= value :: encodable
    //==================================================

    @Override
    public Object getEncodableValue()
    {
        return getValue();
    }

    @Override
    public void setEncodableValue(Object e)
    {
        setValue((KmDateRange)e);
    }

    //##################################################
    //# on change
    //##################################################

    public void onChange(Runnable e)
    {
        _changeListener = e;
    }

    //##################################################
    //# enabled
    //##################################################

    public void setReadonly(boolean e)
    {
        _readonly.setValue(e);

        _startField.setReadOnly(e);
        _endField.setReadOnly(e);
        _modeField.setDisabled(e);
    }

    public void enable()
    {
        setReadonly(false);
    }

    public void readonly()
    {
        setReadonly(true);
    }

    public boolean isReadonly()
    {
        return _readonly.isTrue();
    }

    public boolean isEditable()
    {
        return !isReadonly();
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _changeTracking;
    }

    public void setChangeTracking(boolean e)
    {
        warnIfInstalled();
        _changeTracking = e;
        _fields.forEach(x -> x.setChangeTracking(e));
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        if ( !hasValueAdaptor() )
            return true;

        @SuppressWarnings("unchecked")
        KmDateRange value = (KmDateRange)getValueAdaptor().getValue(model);
        setValue(value);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected boolean applyToModel_here(Object model)
    {
        if ( hasValueAdaptor() )
            getValueAdaptor().setValue(model, getValue());

        return true;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        if ( hasHelp() )
            _modeField.setHelp(getHelp());

        if ( hasMode() )
            _modeField.setValue(getMode());

        if ( isModeCustom() )
            _customFieldsRow.show();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(KmDateRange e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(KmDateRange e, boolean updateOldValue)
    {
        setValue(e);
        ajaxUpdateFieldValues(updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        if ( isModeCustom() )
        {
            ajaxShowCustomFields();
            return;
        }

        ajaxHideCustomFields();
    }

    //==================================================
    //= ajax :: show custom fields
    //==================================================

    private void ajaxShowCustomFields()
    {
        ajaxShowCustomFields(true);
    }

    private void ajaxHideCustomFields()
    {
        ajaxShowCustomFields(false);
    }

    private void ajaxShowCustomFields(boolean visible)
    {
        _customFieldsRow.ajaxShow(visible);
    }

    //##################################################
    //# handle :: mode change
    //##################################################

    private void handleModeChange()
    {
        setModeCode(_modeField.getValue());

        Mode mode = getMode();
        KmDateRange interval = getIntervalFor(mode);
        boolean showsCustom = showsCustomFieldsFor(mode);

        setValue(interval);
        ajaxUpdateFieldValues();
        ajaxShowCustomFields(showsCustom);

        fire(_changeListener);
    }

    private void handleDateChanged()
    {
        fire(_changeListener);
    }

    //==================================================
    //= get interval
    //==================================================

    private KmDateRange getIntervalFor(Mode mode)
    {
        if ( mode == null )
            return null;

        switch ( mode )
        {
            case Custom:
                return getCustomInterval();

            case Today:
                return getTodayInterval();

            case Tomorrow:
                return getTomorrowInterval();

            case Yesterday:
                return getYesterdayInterval();

            case ThisWeek:
                return getThisWeekInterval();

            case NextWeek:
                return getNextWeekInterval();

            case LastWeek:
                return getLastWeekInterval();

            case ThisMonth:
                return getThisMonthInterval();

            case NextMonth:
                return getNextMonthInterval();

            case LastMonth:
                return getLastMonthInterval();
        }

        throw Kmu.newEnumError(mode);
    }

    private KmDateRange getCustomInterval()
    {
        return getValue();
    }

    private KmDateRange getTodayInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today;
        KmDate end = start;
        return KmDateRange.create(start, end);
    }

    private KmDateRange getTomorrowInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.addDay();
        KmDate end = start;
        return KmDateRange.create(start, end);
    }

    private KmDateRange getYesterdayInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.subtractDay();
        KmDate end = start;
        return KmDateRange.create(start, end);
    }

    private KmDateRange getThisWeekInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfWeek();
        KmDate end = start.getEndOfWeek();
        return KmDateRange.create(start, end);
    }

    private KmDateRange getNextWeekInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfWeek().addWeek();
        KmDate end = start.getEndOfWeek();
        return KmDateRange.create(start, end);
    }

    private KmDateRange getLastWeekInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfWeek().subtractWeek();
        KmDate end = start.getEndOfWeek();
        return KmDateRange.create(start, end);
    }

    private KmDateRange getThisMonthInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfMonth();
        KmDate end = start.getEndOfMonth();
        return KmDateRange.create(start, end);
    }

    private KmDateRange getNextMonthInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfMonth().addMonth();
        KmDate end = start.getEndOfMonth();
        return KmDateRange.create(start, end);
    }

    private KmDateRange getLastMonthInterval()
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfMonth().subtractMonth();
        KmDate end = start.getEndOfMonth();
        return KmDateRange.create(start, end);
    }

    //==================================================
    //= shows custom
    //==================================================

    private boolean showsCustomFieldsFor(Mode mode)
    {
        if ( mode == null )
            return false;

        switch ( mode )
        {
            case Custom:
                return true;

            case Today:
            case Tomorrow:
            case Yesterday:
            case ThisWeek:
            case NextWeek:
            case LastWeek:
            case ThisMonth:
            case NextMonth:
            case LastMonth:
                return false;
        }

        throw Kmu.newEnumError(mode);
    }

    //##################################################
    //# support
    //##################################################

    private boolean isModeCustom()
    {
        return getMode() == Mode.Custom;
    }

}
