package com.app.ui.activity.general;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.activity.MyPage;
import com.app.utility.MyConstantsIF;

public class MyHomePage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHomePage instance = new MyHomePage();

    private MyHomePage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        String msg = "Welcome to " + MyConstantsIF.APPLICATION_NAME;

        ScBox root;
        root = new ScBox();
        root.css().pad();

        ScGroup group;
        group = root.addGroup("Home");
        group.addPad().addText(msg);

        return root;
    }

}
