package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBorderLayout;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

public class MyBorderLayoutTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyBorderLayoutTestPage instance = new MyBorderLayoutTestPage();

    private MyBorderLayoutTestPage()
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
        root.css().fill();

        ScBorderLayout layout;
        layout = root.addBorderLayout();

        ScDiv e;

        e = layout.addTop(100);
        e.css().pad().borderRed();
        e.addText("1) top 100px");

        e = layout.addRight(100);
        e.css().pad().borderGreen();
        e.addText("2) right 100px");

        e = layout.addBottom(100);
        e.css().pad().borderPurple();
        e.addText("3) bottom 100px");

        e = layout.addLeftPercent(20);
        e.css().pad().borderBlue();
        e.addText("4) left 20%");

        e = layout.addLeftPercent(20);
        e.css().pad().borderGreen();
        e.addText("5) left 20%");

        e = layout.addTop(50);
        e.css().pad().borderPurple();
        e.addText("6) top 50");

        e = layout.addCenter();
        e.css().pad().borderBlack();
        e.addText("7) center");
    }
}
