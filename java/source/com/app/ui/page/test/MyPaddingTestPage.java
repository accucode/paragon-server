package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test layouts using simple boxes (divs) along with
 * basic padding and margin styles.
 */
public final class MyPaddingTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyPaddingTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyPaddingTestPage();
    }

    public static MyPaddingTestPage getInstance()
    {
        return _instance;
    }

    private MyPaddingTestPage()
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
        root.css().gapOuter();

        ScDiv box;
        box = addBlueBox(root, "one");

        box = addBlueBox(root, "two");
        box.css().pad();

        box = addBlueBox(root, "left a");
        box.css().pad().floatLeft();

        box = addBlueBox(root, "left b");
        box.css().pad().floatLeft();

        box = addBox(root, "no float");
        box.css().pad().boxPurple();
    }

    public ScDiv addBlueBox(ScBox root, String msg)
    {
        ScDiv box;
        box = addBox(root, msg);
        box.css().boxBlue();
        return box;
    }

    public ScDiv addBox(ScBox root, String msg)
    {
        ScDiv box;
        box = root.addDiv();
        box.addParagraph(msg);
        box.addParagraph(msg);
        box.addParagraph(msg);
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
