package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAbsoluteLayout;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTitlePanelLayout;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyTitlePanelTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTitlePanelTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyTitlePanelTestPage();
    }

    public static MyTitlePanelTestPage getInstance()
    {
        return _instance;
    }

    private MyTitlePanelTestPage()
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

        ScAbsoluteLayout layout;
        layout = root.addAbsoluteLayout();

        installTop(layout);
        installLeft(layout);
        installCenter(layout);
    }

    private void installTop(ScAbsoluteLayout layout)
    {
        ScDiv top;
        top = layout.addTop(100);
        top.css().pad().grooveBottom().overflowAuto();

        installLinesOn(top, "top 100px");
    }

    private void installLeft(ScAbsoluteLayout layout)
    {
        ScDiv left;
        left = layout.addLeftPercent(30);
        left.css().grooveRight();

        ScTitlePanelLayout leftTitle;
        leftTitle = left.addTitlePanelLayout();
        leftTitle.setTitle("Left Title");
        leftTitle.headerCss().grooveBottom();
        leftTitle.bodyCss().pad();

        installLinesOn(leftTitle, "left 30%");
    }

    private void installCenter(ScAbsoluteLayout layout)
    {
        ScDiv center;
        center = layout.addCenter();

        ScTitlePanelLayout centerTitle;
        centerTitle = center.addTitlePanelLayout();
        centerTitle.setTitle("Center Title");
        centerTitle.headerCss().grooveBottom();
        centerTitle.bodyCss().pad();

        installLinesOn(centerTitle, "center title");
    }

    private void installLinesOn(ScContainer root, String text)
    {
        root.addParagraph(text + " start");

        int n = 100;
        for ( int i = 0; i < n; i++ )
            root.addParagraph(text);

        root.addParagraph(text + " end");
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
