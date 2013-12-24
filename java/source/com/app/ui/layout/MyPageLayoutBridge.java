package com.app.ui.layout;

import com.kodemore.servlet.utility.ScPageLayoutBridge;

public class MyPageLayoutBridge
    extends ScPageLayoutBridge
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        ScPageLayoutBridge.install(new MyPageLayoutBridge());
    }

    //##################################################
    //# constructor
    //##################################################

    private MyPageLayoutBridge()
    {
        // private
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public String getMainSelector()
    {
        return MyPageLayout.CONTENT_SELECTOR;
    }
}
