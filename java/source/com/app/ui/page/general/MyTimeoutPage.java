package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGeneralButton;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
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
    //# setup
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        String href = MyUrls.getEntryUrl();

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup("Time Out");
        group.addText("For security reasons, your session has expired.");
        group.addSpace();
        group.addText("Please log back in.");

        ScDiv buttons;
        buttons = group.addFloatRight();

        ScGeneralButton button;
        button = buttons.addGeneralButton();
        button.setText("Login >>");
        button.setHref(href);
    }
}
