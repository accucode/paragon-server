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
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * http://jqueryui.com/demos/datepicker/
 */
public class ScDateIntervalField
    extends ScDivWrapper
    implements ScFieldIF<KmDateInterval>
{
    //##################################################
    //# enum
    //##################################################

    public enum Mode
                    implements KmEnumIF
    {
        Today,
        Yesterday,
        ThisWeek,
        LastWeek,
        ThisMonth,
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

    private static final int    DATE_FIELD_WIDTH       = 100;
    private static final String DATE_FIELD_PLACEHOLDER = "mm/dd/yyyy";

    //##################################################
    //# variables
    //##################################################

    private ScLocalBoolean      _readonly;

    private ScEnumDropdownField _modeField;
    private ScDiv               _customFieldsRow;

    private ScDateField         _startField;
    private ScDateField         _endField;

    /**
     * The list of fields used in the address.
     */
    private KmList<ScField<?>>  _fields;

    /**
     * If true (the default), the value is encoded into an html data- attribute
     * and the browser utilizes client-side utilizes to warn the user before
     * ajax actions if the value has changed.
     *
     * Change tracking should be set during initial page initialization, and should
     * NOT be modified while processing a page.
     */
    private boolean             _changeTracking;

    /**
     * If set the applyFromModel and applyToModel will use this adaptor
     * to get/set the address.
     */
    private ScLocalAdaptor      _valueAdaptor;

    private ScLocalString       _modeCode;

    //##################################################
    //# constructor
    //##################################################

    public ScDateIntervalField()
    {
        _readonly = new ScLocalBoolean();

        _modeCode = new ScLocalString();
        _modeCode.setAutoSave();

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
        _startField = new ScDateField();
        _startField.setLabel("From");
        _startField.layoutInline(DATE_FIELD_WIDTH);
        _startField.setPlaceholder(DATE_FIELD_PLACEHOLDER);
        _startField.setHelp("The beginning of the date interval (inclusive)");

        _endField = new ScDateField();
        _endField.setLabel("To");
        _endField.layoutInline(DATE_FIELD_WIDTH);
        _endField.setPlaceholder(DATE_FIELD_PLACEHOLDER);
        _endField.setHelp("The end of the date interval (inclusive)");

        _modeField = new ScEnumDropdownField();
        _modeField.setOptions(Mode.values());
        _modeField.onChange(newUncheckedAction(this::handleModeChange));
        _modeField.setNullAnyPrefix();
        _modeField.setHelp(
            "Choose a pre-defined common date interval, or "
                + "select 'Custom' to specify the start and end dates.");

        _fields = new KmList<>();

        _fields.add(_startField);
        _fields.add(_endField);
        _fields.add(_modeField);
    }

    private void installLayout()
    {
        ScDiv row;
        row = getInner().addFlexRow();

        ScDiv col;
        col = row.addFlexColumn();
        col.css().flexAlignStart();
        col.add(_modeField);

        row.addFlexGap(10);

        _customFieldsRow = row.addFlexRow();
        _customFieldsRow.hide();

        ScFieldTable fields;
        fields = _customFieldsRow.addFieldTable();
        fields.add(_startField);

        _customFieldsRow.addFlexGap(10);

        fields = _customFieldsRow.addFieldTable();
        fields.add(_endField);
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
    public KmDateInterval getValue()
    {
        KmDateInterval value;
        value = new KmDateInterval();
        value.setStart(_startField.getValue());
        value.setEnd(_endField.getValue());
        return value;
    }

    @Override
    public void setValue(KmDateInterval e)
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
        setModeCode(e.getLabel());
    }

    public boolean hasMode()
    {
        return getMode() != null;
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
        setValue((KmDateInterval)e);
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model, boolean skipFields)
    {
        if ( !hasValueAdaptor() )
            return true;

        @SuppressWarnings("unchecked")
        KmDateInterval value = (KmDateInterval)getValueAdaptor().getValue(model);
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
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        if ( hasMode() )
            _modeField.setValue(getMode());

        if ( isModeCustom() )
            _customFieldsRow.show();
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(KmDateInterval e)
    {
        ajaxSetFieldValue(e, getChangeTracking());
    }

    @Override
    public void ajaxSetFieldValue(KmDateInterval e, boolean updateOldValue)
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

    //##################################################
    //# support
    //##################################################

    private boolean isModeCustom()
    {
        return getMode() == Mode.Custom;
    }

    private void handleModeChange()
    {
        setModeCode(_modeField.getValue());

        if ( getMode() == null )
        {
            clearValue();
            ajaxUpdateFieldValues();
            ajaxHideCustomFields();
            return;
        }

        KmDate start;
        KmDate end;

        KmDate today = KmClock.getLocalTimestamp().getDate();

        switch ( getMode() )
        {
            case Today:
                ajaxHideCustomFields();
                setValue(KmDateInterval.create(today, today));
                break;

            case Yesterday:
                ajaxHideCustomFields();
                KmDate yesterday = today.subtractDay();
                setValue(KmDateInterval.create(yesterday, yesterday));
                break;

            case ThisWeek:
                ajaxHideCustomFields();
                start = today.getStartOfWeek();
                end = today.getEndOfWeek();
                setValue(KmDateInterval.create(start, end));
                break;

            case LastWeek:
                ajaxHideCustomFields();
                start = today.getStartOfWeek().subtractWeek();
                end = today.getEndOfWeek().subtractWeek();
                setValue(KmDateInterval.create(start, end));
                break;

            case ThisMonth:
                ajaxHideCustomFields();
                start = today.getStartOfMonth();
                end = today.getEndOfMonth();
                setValue(KmDateInterval.create(start, end));
                break;

            case LastMonth:
                ajaxHideCustomFields();
                end = today.getStartOfMonth().subtractDay();
                start = end.getStartOfMonth();
                setValue(KmDateInterval.create(start, end));
                break;

            case Custom:
                ajaxShowCustomFields();
                break;
        }

        ajaxUpdateFieldValues();
    }

    private void ajaxHideCustomFields()
    {
        _customFieldsRow.ajaxHide();
    }

    private void ajaxShowCustomFields()
    {
        _customFieldsRow.ajaxShow();
    }
}
