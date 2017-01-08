package com.app.ui.control;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldIF;
import com.kodemore.servlet.field.ScTextField;

import com.app.utility.MyButtonUrls;

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

    private ScTextField         _innerTextField;

    private Runnable            _onScanListener;

    private ScScanBarcodeDialog _dialog;

    //##################################################
    //# constructor
    //##################################################

    public ScBarcodeField()
    {
        installField();
        installDialog();
    }

    //##################################################
    //# install
    //##################################################

    private void installField()
    {
        ScDiv row;
        row = getInner();
        row.css().flexRow().rowSpacer5();
        installTextFieldOn(row);
        installButtonOn(row);
    }

    private void installTextFieldOn(ScDiv root)
    {
        ScTextField e;
        e = root.addTextField();
        _innerTextField = e;
    }

    private void installButtonOn(ScDiv root)
    {
        ScAction action = newUncheckedAction(this::handleScanBarcode);

        ScButton button;
        button = root.addButton("", action);
        button.setImage(MyButtonUrls.barcode());
        button.setHoverText("Scan Barcode");
    }

    //==================================================
    //= install :: dialog
    //==================================================

    private void installDialog()
    {
        _dialog = new ScScanBarcodeDialog();
        _dialog.onBarcodeScanned(this::handleBarcodeScanned);
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
        _dialog.ajaxOpen();
    }

    private void handleBarcodeScanned(String s)
    {
        _innerTextField.setValue(s);
        _innerTextField.ajaxUpdateFieldValues();

        fireOnScannedLisener();
    }

    //##################################################
    //# value adaptor
    //##################################################

    @SuppressWarnings("rawtypes")
    public KmAdaptorIF getValueAdaptor()
    {
        return _innerTextField.getValueAdaptor();
    }

    @SuppressWarnings("rawtypes")
    public void setValueAdaptor(KmAdaptorIF e)
    {
        _innerTextField.setValueAdaptor(e);
    }

    public void clearValueAdaptor()
    {
        _innerTextField.clearValueAdaptor();
    }

    public boolean hasValueAdaptor()
    {
        return _innerTextField.hasValueAdaptor();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        return _innerTextField.getValue();
    }

    @Override
    public void setValue(String value)
    {
        _innerTextField.setValue(value);
    }

    @Override
    public void saveValue()
    {
        _innerTextField.saveValue();
    }

    @Override
    public void resetValue()
    {
        _innerTextField.resetValue();
    }

    public void clearValue()
    {
        _innerTextField.clearValue();
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
        _innerTextField.setReadOnly(e);
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
        return _innerTextField.isReadOnly();
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
        _innerTextField.onInput(e);
    }

    public void onInput(Runnable e)
    {
        _innerTextField.onInput(e);
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
        _innerTextField.setRequired(e);
    }

    //##################################################
    //# errors
    //##################################################

    public void addError(KmErrorIF e)
    {
        _innerTextField.addError(e);
    }

    public void addError(String format, Object... args)
    {
        _innerTextField.addError(format, args);
    }

    public void addError(KmList<KmErrorIF> v)
    {
        _innerTextField.addErrors(v);
    }

    //##################################################
    //# change tracking
    //##################################################

    @Override
    public boolean getChangeTracking()
    {
        return _innerTextField.getChangeTracking();
    }

    public void setChangeTracking(boolean e)
    {
        _innerTextField.setChangeTracking(e);
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
        _innerTextField.ajaxSetFieldValue(e);
    }

    @Override
    public void ajaxSetFieldValue(String e, boolean updateOldValue)
    {
        _innerTextField.ajaxSetFieldValue(e, updateOldValue);
    }

    @Override
    public void ajaxUpdateFieldValue_here(boolean updateOldValue)
    {
        // none
    }
}
