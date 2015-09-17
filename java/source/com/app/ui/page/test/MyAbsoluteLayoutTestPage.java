package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAbsoluteLayout;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAbsoluteLayoutTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAbsoluteLayoutTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyAbsoluteLayoutTestPage();
    }

    public static MyAbsoluteLayoutTestPage getInstance()
    {
        return _instance;
    }

    private MyAbsoluteLayoutTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
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
        root.css().fill();

        ScAbsoluteLayout layout;
        layout = root.addAbsoluteLayout();

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

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }
}
