package com.app.ui.activity.general;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGeneralButton;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.activity.MyPage;
import com.app.utility.MyUrls;

public class MyTimeoutPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTimeoutPage instance = new MyTimeoutPage();

    private MyTimeoutPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        String href = MyUrls.getEntryUrl();

        ScForm root;
        root = new ScForm();

        ScGroup group;
        group = root.addGroup("Time Out");
        group.addText("For security reasons, your session has expired.");
        group.addSpace();
        group.addText("Please log back in.");

        ScDiv buttons;
        buttons = group.addFloatRight();

        ScGeneralButton button;
        button = buttons.addGeneralButton();
        button.setText("Login >>");
        button.setHref(href);

        return root;
    }
}
