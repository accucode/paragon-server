package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyWyattTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyWyattTestPage instance = new MyWyattTestPage();

    private MyWyattTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().pad();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("hello");

        ScBox body;
        body = group.getBody().addPad();
        body.addButton("hello", this::handleHello);
    }

    private void handleHello()
    {
        ajax().toast("world!");
    }

}
