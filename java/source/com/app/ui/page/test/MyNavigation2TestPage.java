package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyNavigation2TestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyNavigation2TestPage _instance;

    public static void installInstance()
    {
        _instance = new MyNavigation2TestPage();
    }

    public static MyNavigation2TestPage getInstance()
    {
        return _instance;
    }

    private MyNavigation2TestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_VALUE = "value";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _value;
    private ScText              _message;

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
        _value.setValue(value);
        ajaxEnter();
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        v.setValue(PARAM_VALUE, _value.getValue());
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        _value.setValue(v.getValue(PARAM_VALUE));
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _value = new ScLocalString();
        _message = new ScText();

        root.css().fill().auto();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Navigation Test (Page 2)");

        ScDiv body;
        body = group.getBody().addPad();
        body.add(_message);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        String s = Kmu.format("The value is '%s'.", _value.getValue());
        _message.setValue(s);
    }
}
