package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAccordion;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAccordionTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAccordionTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyAccordionTestPage();
    }

    public static MyAccordionTestPage getInstance()
    {
        return _instance;
    }

    private MyAccordionTestPage()
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
        root.css();

        ScAccordion e;
        e = root.addAccordion();

        ScDiv tab;
        tab = e.addDiv();
        tab.setLabel("one");
        tab.addDiv().addText(Kmu.repeat("one ", 100));

        tab = e.addDiv();
        tab.setLabel("two");
        tab.addDiv().addText(Kmu.repeat("two ", 100));

        tab = e.addDiv();
        tab.setLabel("three");
        tab.addDiv().addText(Kmu.repeat("three ", 100));

        tab = e.addDiv();
        tab.setLabel("four");

        ScDiv content;
        content = tab.addDiv();
        content.style().height(200);
        content.addText(Kmu.repeat("four ", 100));
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
