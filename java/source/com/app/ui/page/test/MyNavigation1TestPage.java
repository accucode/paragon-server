package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyNavigation1TestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyNavigation1TestPage _instance;

    public static void installInstance()
    {
        _instance = new MyNavigation1TestPage();
    }

    public static MyNavigation1TestPage getInstance()
    {
        return _instance;
    }

    private MyNavigation1TestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _textField;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# navigation
    //##################################################

    public void ajaxEnter(String value)
    {
        _textField.setValue(value);
        ajaxEnter();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        v.setValue("value", _textField.getValue());
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        _textField.setValue(v.getValue("value"));
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Navigation Test (Page 1)");

        ScDiv body;
        body = group.getBody().addPad();
        body.addFieldTable().add(createTextField());

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Update", this::handleUpdateHistory);
        buttons.addButton("Navigate", this::handleNavigate);
    }

    private ScControl createTextField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Test");
        e.disableChangeTracking();
        _textField = e;
        return e;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleNavigate()
    {
        String value = _textField.getValue();
        MyNavigation2TestPage.getInstance().ajaxEnter(value);
    }

    private void handleUpdateHistory()
    {
        ajax().replaceHistory(this);
        ajax().toast("Updated.");
    }
}
