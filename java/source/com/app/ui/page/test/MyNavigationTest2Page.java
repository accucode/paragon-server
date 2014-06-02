package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public class MyNavigationTest2Page
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNavigationTest2Page instance = new MyNavigationTest2Page();

    private MyNavigationTest2Page()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String VALUE_KEY = "value";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _value;
    private ScText              _message;

    //##################################################
    //# navigation
    //##################################################

    public void push(String value)
    {
        _value.setValue(value);
        _push();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        ScParameterList v;
        v = new ScParameterList();
        v.setValue(VALUE_KEY, _value.getValue());
        return v;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        _value.setValue(v.getValue(VALUE_KEY));
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _value = new ScLocalString();
        _message = new ScText();

        root.css().gap();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Navigation Test (Page 2)");
        group.css().width400();

        ScBox body;
        body = group.addPad();
        body.add(_message);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        String s = Kmu.format("The value is '%s'.", _value.getValue());
        _message.setValue(s);
    }
}
