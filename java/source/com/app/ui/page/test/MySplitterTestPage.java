package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScSplitter;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MySplitterTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySplitterTestPage _instance;

    public static void installInstance()
    {
        _instance = new MySplitterTestPage();
    }

    public static MySplitterTestPage getInstance()
    {
        return _instance;
    }

    private MySplitterTestPage()
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
        root.css().fill();

        ScSplitter hSplit;
        hSplit = root.addSplitter();
        hSplit.css().fill();

        ScDiv left;
        left = hSplit.addDiv();
        left.css().fill().pad().boxRed();
        left.addText(Kmu.repeat("left ", 100));

        ScSplitter vSplit;
        vSplit = hSplit.addSplitter();
        vSplit.setVertical();
        vSplit.css().fill();

        ScDiv top;
        top = vSplit.addDiv();
        top.css().fill().pad().boxGreen();
        top.addText(Kmu.repeat("top ", 100));

        ScDiv bottom;
        bottom = vSplit.addDiv();
        bottom.css().fill().pad().boxBlue();
        bottom.addText(Kmu.repeat("bottom ", 100));
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
