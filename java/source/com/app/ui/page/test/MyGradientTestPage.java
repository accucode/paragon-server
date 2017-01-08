package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Simple html5 gradients.
 */
public final class MyGradientTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyGradientTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyGradientTestPage();
    }

    public static MyGradientTestPage getInstance()
    {
        return _instance;
    }

    private MyGradientTestPage()
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
        root.css().fill().auto().flexRow().flexWrap().flexWrapAlignStart().gap().boxGray();

        addBoxDownTo(root, "white", "black");
        addBoxDownTo(root, "white", "blue");
        addBoxDownTo(root, "white", "yellow", "blue");
        addBoxDownTo(root, "white", "yellow", "blue", "red");
        addBoxDownTo(root, "white", "yellow", "blue", "red", "black");
    }

    private ScDiv addBoxDownTo(ScDiv root, String... colors)
    {
        ScDiv e;
        e = root.addDiv();
        e.css().border().size200().pad();
        e.style().gradientDown(colors);
        e.addText(Kmu.join(colors));
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
