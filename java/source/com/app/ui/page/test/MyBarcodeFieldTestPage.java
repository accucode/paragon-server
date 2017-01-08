package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.control.ScBarcodeField;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the various form fields.
 */
public final class MyBarcodeFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyBarcodeFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyBarcodeFieldTestPage();
    }

    public static MyBarcodeFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyBarcodeFieldTestPage()
    {
        // singleton
    }

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
        group = root.addGroup("Barcode Field Test");

        ScDiv body;
        body = group.getBody().addPad();
        body.add(new ScBarcodeField());
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
