package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * A sample of fieldsets.
 */
public final class MyFieldsetTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyFieldsetTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyFieldsetTestPage();
    }

    public static MyFieldsetTestPage getInstance()
    {
        return _instance;
    }

    private MyFieldsetTestPage()
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
        root.css().fill().auto().boxGray().gap();

        ScGroup group = root.addGroup("Fieldsets");
        ScDiv body = group.getBody().addGap();

        addNameSetOn(body);
        addPhoneSetOn(body);
    }

    private void addNameSetOn(ScDiv body)
    {
        ScFieldset set;
        set = body.addFieldset("Name");
        set.css().pad();
        set.setHelp("Name fields.");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addTextField().setLabel("First");
        fields.addTextField().setLabel("Middle");

        ScTextField field;
        field = fields.addTextField();
        field.setLabel("Last");
        field.setValue("readonly");
        field.setReadOnly();
    }

    private void addPhoneSetOn(ScDiv body)
    {
        ScFieldset set;
        set = body.addFieldset("Phone");
        set.css().pad();
        set.setHelp("Phone fields.");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addTextField().setLabel("Home");
        fields.addTextField().setLabel("Work");
        fields.addTextField().setLabel("Cell");
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
