package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;

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
    //# variables
    //##################################################

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        //        KmHtmlBuilder test;
        //        test = new KmHtmlBuilder();

        return root;
    }

    //##################################################
    //# actions
    //##################################################

    //##################################################
    //# handle
    //##################################################

}
