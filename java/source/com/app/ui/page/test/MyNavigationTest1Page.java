package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyNavigationTest1Page
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyNavigationTest1Page _instance;

    public static void installInstance()
    {
        _instance = new MyNavigationTest1Page();
    }

    public static MyNavigationTest1Page getInstance()
    {
        return _instance;
    }

    private MyNavigationTest1Page()
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
        _textField = new ScTextField();
        _textField.setLabel("Test");

        root.css().gap();

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Navigation Test (Page 1)");
        group.css().width400();

        ScBox body;
        body = group.getBody().addPad();
        body.addFieldTable().add(_textField);

        group.addBodyDivider();

        ScBox footer;
        footer = group.getBody().addButtonBox();
        footer.addButton("Update", this::handleUpdateHistory);
        footer.addButton("Navigate", this::handleNavigate);
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
        MyNavigationTest2Page.getInstance().ajaxEnter(value);
    }

    private void handleUpdateHistory()
    {
        ajax().replaceHistory(this);
        ajax().toast("Updated.");
    }
}
