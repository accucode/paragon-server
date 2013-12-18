package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBarcodeCode39;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

/**
 * Test the various form fields.
 */
public class MyBarcodeTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyBarcodeTestPage instance = new MyBarcodeTestPage();

    private MyBarcodeTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static String VALID_CODE   = "16180339887";
    private static String INVALID_CODE = "23jb8v 8e5i";

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScGroup group;
        group = root.addGroup("ScBarcodeCode39");

        ScBox body;
        body = group.addPad();

        body.addText("Below is a code39 barcode that contains (valid entry): '" + VALID_CODE + "'");

        ScBarcodeCode39 code;
        code = new ScBarcodeCode39();
        code.setValue(VALID_CODE);

        body.add(code);

        body.addBreak();

        body.addText("Below is a code39 barcode that contains (invalid entry): '"
            + INVALID_CODE
            + "'");

        code = new ScBarcodeCode39();
        code.setValue(INVALID_CODE);

        body.add(code);
    }
}
