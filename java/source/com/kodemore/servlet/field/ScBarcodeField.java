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
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.utility.ScUrlBridge;

/**
 * I wrap a text field and provide a convenience dialog for scanning values from a barcode.
 */
public class ScBarcodeField
    extends ScDivWrapper
    implements ScFieldIF<String>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _textField;
    private Runnable    _onScanListener;

    //##################################################
    //# constructor
    //##################################################

    public ScBarcodeField()
    {
        ScDiv row;
        row = getInner();
        row.css().flexRow().rowSpacer5();
        row.add(createTextField());
        row.add(createButton());
    }

    private ScControl createTextField()
    {
        ScTextField e;
        e = new ScTextField();
        _textField = e;
        return e;
    }

    private ScControl createButton()
    {
        ScAction action = newUncheckedAction(this::handleScanBarcode);

        ScActionButton e;
        e = new ScActionButton();
        e.setAction(action);
        e.installPreImage(ScUrlBridge.getInstance().getBarcodeButtonUrl());
        e.setHoverText("Scan Barcode");
        return e;
    }

    //##################################################
    //# meta
    //##################################################

    public void setMeta(KmMetaAssociation<?,String> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setRequired(x.isRequired());
    }

    public void setMeta(KmMetaProperty<?,String> x)
    {
        setLabel(x);
        setHelp(x);
        setValueAdaptor(x);
        setRequired(x.isRequired());
    }

    //##################################################
    //# on scan
    //##################################################

    public void onScan(Runnable e)
    {
        _onScanListener = e;
    }

    private void fireOnScannedLisener()
    {
        fire(_onScanListener);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleScanBarcode()
    {
        ScScanBarcodeDialog d;
        d = ScScanBarcodeDialog.getInstance();
        d.setFieldLabel(getLabel());
        d.ajaxOpenFor(this);
    }

    public void handleBarcodeScanned(String s)
    {
        _textField.setValue(s);
        _textField.ajaxUpdateFieldValues();

        fireOnScannedLisener();
    }

    //##################################################
    //# value adaptor
    //##################################################

    public KmAdaptorIF<?,String> getValueAdaptor()
    {
        return _textField.getValueAdaptor();
    }

    public void setValueAdaptor(KmAdaptorIF<?,String> e)
    {
        _textField.setValueAdaptor(e);
    }

    public void clearValueAdaptor()
    {
        _textField.clearValueAdaptor();
    }

    public boolean hasValueAdaptor()
    {
        return _textField.hasValueAdaptor();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        return _textField.getValue();
    }

    @Override
    public void setValue(String value)
    {
        _textField.setValue(value);
    }

    @Override
    public void saveValue()
    {
        _textField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _textField.resetValue();
    }

    public void clearValue()
    {
        _textField.clearValue();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void setEncodableValue(Object e)
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# enabled
    //##################################################

    public void setReadonly()
    {
        setReadonly(true);
    }

    public void setReadonly(boolean e)
    {
        _textField.setReadOnly(e);
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
        return _textField.isReadOnly();
    }

    public boolean isEditable()
    {
        return !isReadonly();
    }

    //##################################################
    //# on input
    //##################################################

    public void onInput(ScAction e)
    {
        _textField.onInput(e);
    }

    //##################################################
    //# required
    //##################################################

    public void setRequired()
    {
        setRequired(true);
    }

    public void setRequired(boolean e)
    {
        _textField.setRequired(e);
    }

    //##################################################
    //# errors
    //##################################################

    public void addError(KmErrorIF e)
    {
        _textField.addError(e);
    }

    public void addError(String format, Object... args)
    {
        _textField.addError(format, args);
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _textField.getChangeTracking();
    }

    public void setChangeTracking(boolean e)
    {
        _textField.setChangeTracking(e);
    }

    public void disableChangeTracking()
    {
        setChangeTracking(false);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public void ajaxSetFieldValue(String e)
    {
        _textField.ajaxSetFieldValue(e);
    }

    @Override
    public void ajaxSetFieldValue(String e, boolean updateOldValue)
    {
        _textField.ajaxSetFieldValue(e, updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        // none
    }
}
