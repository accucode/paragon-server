package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAccordion;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

public class MyAccordionTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccordionTestPage instance = new MyAccordionTestPage();

    private MyAccordionTestPage()
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
        root.css().gap();

        ScAccordion e;
        e = root.addAccordion();

        ScBox tab;
        tab = e.addBox();
        tab.setLabel("one");
        tab.addDiv().addText(Kmu.repeat("one ", 100));

        tab = e.addBox();
        tab.setLabel("two");
        tab.addDiv().addText(Kmu.repeat("two ", 100));

        tab = e.addBox();
        tab.setLabel("three");
        tab.addDiv().addText(Kmu.repeat("three ", 100));

        tab = e.addBox();
        tab.setLabel("four");

        ScDiv content;
        content = tab.addDiv();
        content.style().height(200);
        content.addText(Kmu.repeat("four ", 100));
    }
}
