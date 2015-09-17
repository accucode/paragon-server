package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
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
        root.css().gap();

        addBoxDownTo(root, "white", "black");
        addBoxDownTo(root, "white", "blue");
        addBoxDownTo(root, "white", "yellow", "blue");
        addBoxDownTo(root, "white", "yellow", "blue", "red");
        addBoxDownTo(root, "white", "yellow", "blue", "red", "black");
    }

    private ScBox addBoxDownTo(ScBox root, String... colors)
    {
        ScBox box;
        box = root.addBox();
        box.css().pad().border().floatLeft();
        box.style().width(200);
        box.style().height(200);
        box.style().gradientDown(colors);
        box.addText(Kmu.join(colors));
        return box;
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
