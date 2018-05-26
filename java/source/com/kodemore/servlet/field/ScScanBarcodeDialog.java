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

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFormDialog;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.utility.Kmu;

/**
 * I am a dialog with a single field to be used for scanning barcodes.
 * I am only to be used in conjunction with the ScBarcodeField.
 */
public class ScScanBarcodeDialog
    extends ScFormDialog
{
    //##################################################
    //# singleton
    //##################################################

    private static ScScanBarcodeDialog _instance;

    public static void installInstance()
    {
        _instance = new ScScanBarcodeDialog();
    }

    public static ScScanBarcodeDialog getInstance()
    {
        return _instance;
    }

    private ScScanBarcodeDialog()
    {
        install();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The one field on the dialog where the barcode will be entered.
     */
    private ScTextField _field;

    /**
     * The key of the ScBarcodeField that opened this dialog.
     */
    private ScHiddenField<Integer> _keyField;

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScFormDialog dialog;
        dialog = this;
        dialog.setLabel("Scan Barcode");

        installFormOn(dialog);
        installBodyOn(dialog);
        installButtonsOn(dialog);
    }

    private void installFormOn(ScFormDialog dialog)
    {
        ScAction submitAction = newUncheckedAction(this::handleCodeScanned);

        ScForm form;
        form = dialog.getDialogRoot();
        form.onSubmit(submitAction);
    }

    private void installBodyOn(ScFormDialog dialog)
    {
        ScDiv body;
        body = dialog.getBody();
        body.css().pad20();

        body.add(createKeyField());

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.add(createField());
    }

    private void installButtonsOn(ScFormDialog dialog)
    {
        ScAction closeAction = newUncheckedAction(this::ajaxClose);

        ScDiv footer;
        footer = dialog.showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton();
        footer.addCancelButton(closeAction);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createKeyField()
    {
        ScHiddenField<Integer> e;
        e = new ScHiddenField<>();
        _keyField = e;
        return e;
    }

    private ScControl createField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setWidthFull();
        e.setLabel("Barcode");
        _field = e;
        return e;
    }

    //##################################################
    //# accessing
    //##################################################

    public void setFieldLabel(String e)
    {
        _field.setLabel(e);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleCodeScanned()
    {
        ScBarcodeField barcodeField = getBarcodeField();

        String value = _field.getValue();
        barcodeField.handleBarcodeScanned(value);

        ajaxClose();
    }

    private ScBarcodeField getBarcodeField()
    {
        Integer key = _keyField.getValue();

        ScControl e;
        e = ScControlRegistry.getInstance().findKey(key);

        if ( e == null )
            throw Kmu.newError("Can't identify barcode field");

        if ( e instanceof ScBarcodeField )
            return (ScBarcodeField)e;

        throw Kmu.newError("Can't identify barcode field");
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxOpenFor(ScBarcodeField e)
    {
        _keyField.setValue(e.getKey());
        ajaxOpen();
    }
}
