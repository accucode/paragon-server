package com.app.ui.page.general;

import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;
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
    //# setup
    //##################################################

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.home;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        String msg = "Welcome to " + MyConstantsIF.APPLICATION_NAME;

        root.css().gap();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().floatLeft().width(200).height(300);

        ScGroup group;
        group = groups.addGroup("Home");
        group.addPad().addText(msg);
    }

}