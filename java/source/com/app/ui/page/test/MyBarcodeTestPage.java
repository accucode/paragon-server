package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBarcodeCode39;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the various form fields.
 */
public final class MyBarcodeTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyBarcodeTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyBarcodeTestPage();
    }

    public static MyBarcodeTestPage getInstance()
    {
        return _instance;
    }

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
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();

        ScGroup group;
        group = root.addGroup("Barcode Test");

        ScDiv body;
        body = group.getBody().addPad();
        body.addText(Kmu.format("A code39 barcode that contains (valid entry): '%s'.", VALID_CODE));
        body.add(newValidBarcode());
        body.addBreak();
        body.addText(
            Kmu.format("A code39 barcode that contains (invalid entry): '%s'.", INVALID_CODE));
        body.add(newInvalidBarcode());
    }

    private ScBarcodeCode39 newValidBarcode()
    {
        ScBarcodeCode39 valid;
        valid = new ScBarcodeCode39();
        valid.setValue(VALID_CODE);
        return valid;
    }

    private ScBarcodeCode39 newInvalidBarcode()
    {
        ScBarcodeCode39 invalid;
        invalid = new ScBarcodeCode39();
        invalid.setValue(INVALID_CODE);
        return invalid;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
