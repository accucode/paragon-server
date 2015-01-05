package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
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
        group = root.addGroup("hello");
        group.getBody().addText("world");
    }

}
