package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBorderLayout;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTitlePanelLayout;

public class MyTitlePanelTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTitlePanelTestPage instance = new MyTitlePanelTestPage();

    private MyTitlePanelTestPage()
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

        installTop(layout);
        installLeft(layout);
        installCenter(layout);
    }

    private void installTop(ScBorderLayout layout)
    {
        ScDiv top;
        top = layout.addTop(100);
        top.css().pad().grooveBottom();

        addLinesTo(top, "top 100px");
    }

    private void installLeft(ScBorderLayout layout)
    {
        ScDiv left;
        left = layout.addLeftPercent(30);
        left.css().grooveRight();

        ScTitlePanelLayout leftTitle;
        leftTitle = left.addTitlePanelLayout();
        leftTitle.setTitle("Left Title");
        leftTitle.headerCss().grooveBottom();
        leftTitle.bodyCss().pad();

        addLinesTo(leftTitle, "left 30%");
    }

    private void installCenter(ScBorderLayout layout)
    {
        ScDiv center;
        center = layout.addCenter();

        ScTitlePanelLayout centerTitle;
        centerTitle = center.addTitlePanelLayout();
        centerTitle.setTitle("Center Title");
        centerTitle.headerCss().grooveBottom();
        centerTitle.bodyCss().pad();

        addLinesTo(centerTitle, "center title");
    }

    private void addLinesTo(ScContainer root, String text)
    {
        root.addParagraph(text + " start");

        int n = 100;
        for ( int i = 0; i < n; i++ )
            root.addParagraph(text);

        root.addParagraph(text + " end");
    }
}
