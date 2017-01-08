package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDetachedGroupTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDetachedGroupTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDetachedGroupTestPage();
    }

    public static MyDetachedGroupTestPage getInstance()
    {
        return _instance;
    }

    private MyDetachedGroupTestPage()
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
        root.css().flexColumn().columnSpacer20().auto();

        ScGroup group;
        group = installGroupOn(root);
        group.setTitle("Attached");

        group = installGroupOn(root);
        group.setTitle("Attached, show header");
        group.showHeader();

        group = installGroupOn(root);
        group.setTitle("Attached, show header & footer");
        group.showHeader();
        group.showFooter();

        group = installGroupOn(root);
        group.setTitle("Detached");
        group.setDetachedBody();

        group = installGroupOn(root);
        group.setTitle("Detached");
        group.setDetachedBody();
        group.showHeader();
        group.showFooter();
    }

    private ScGroup installGroupOn(ScPageRoot root)
    {
        ScGroup e;
        e = root.addGroup();

        ScDiv header;
        header = e.getHeader();
        header.css().pad();
        header.addParagraph("header");

        ScDiv body;
        body = e.getBody();
        body.css().pad();
        body.addParagraph("body");

        ScDiv footer;
        footer = e.getFooter();
        footer.css().pad();
        footer.addParagraph("footer");

        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }
}
