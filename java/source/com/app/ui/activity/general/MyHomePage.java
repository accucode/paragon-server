package com.app.ui.activity.general;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;

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
        root.css().padSpaced();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().floatLeft().width(200).height(300);

        ScGroup group;
        group = groups.addGroup("Home");
        group.addPad().addText(msg);

        return root;
    }

}
