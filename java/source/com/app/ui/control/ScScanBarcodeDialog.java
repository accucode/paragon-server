package com.app.ui.control;

import java.util.function.Consumer;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScTextField;

/**
 * I am used to view and select the available macros for a given context type.
 */
public class ScScanBarcodeDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField      _field;

    private Consumer<String> _barcodeScannedListener;

    //##################################################
    //# constructor
    //##################################################

    public ScScanBarcodeDialog()
    {
        MyDialog dialog;
        dialog = this;
        dialog.setLabel("Scan Barcode");

        installFormOn(dialog);
        installBodyOn(dialog);
        installButtonsOn(dialog);
    }

    //##################################################
    //# install
    //##################################################

    private void installFormOn(MyDialog dialog)
    {
        ScAction submitAction = newUncheckedAction(this::handleCodeScanned);

        ScForm form;
        form = dialog.getForm();
        form.setSubmitAction(submitAction);
    }

    private void installBodyOn(MyDialog dialog)
    {
        ScDiv body;
        body = dialog.getBody();
        body.css().pad20();
        _field = body.addTextField();
        _field.setWidthFull();
    }

    private void installButtonsOn(MyDialog dialog)
    {
        ScAction closeAction = newUncheckedAction(this::ajaxClose);

        ScDiv footer;
        footer = dialog.showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton();
        footer.addCancelButton(closeAction);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleCodeScanned()
    {
        String value = _field.getValue();
        fireBarcodeScannedListener(value);
        ajaxClose();
    }

    //##################################################
    //# barcode scanned listener
    //##################################################

    public void onBarcodeScanned(Consumer<String> e)
    {
        _barcodeScannedListener = e;
    }

    private void fireBarcodeScannedListener(String e)
    {
        fire(_barcodeScannedListener, e);
    }
}
