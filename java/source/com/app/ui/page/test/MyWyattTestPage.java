package com.app.ui.page.test;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyWyattTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyWyattTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyWyattTestPage();
    }

    public static MyWyattTestPage getInstance()
    {
        return _instance;
    }

    private MyWyattTestPage()
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
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScFieldTable e;
        e = root.addFieldTable();
        e.add(createField());
    }

    private ScControl createField()
    {
        ScFieldText e;
        e = new ScFieldText();
        e.setLabel("Name");
        e.setValue("Wyatt");
        e.setHelp("This is a two\r\nline message.");
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
}
