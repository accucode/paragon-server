package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyButtonUrls;

/**
 * Include the content found at /web/test/staticInclude.html
 */
public final class MyStaticIncludeTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyStaticIncludeTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyStaticIncludeTestPage();
    }

    public static MyStaticIncludeTestPage getInstance()
    {
        return _instance;
    }

    private MyStaticIncludeTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String FILE = "test/staticInclude.html";

    //##################################################
    //# variables
    //##################################################

    private ScDiv               _contents;

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
        root.css().fill().flexColumn();

        ScDiv row;
        row = root.addFlexRow();
        row.css().flexCrossAlignCenter().flexChildStatic();
        row.css().boxBlue().gap();

        ScActionButton button;
        button = row.addButton("Reload", this::handleReload);
        button.setImage(MyButtonUrls.refresh());

        row.addTextSpan("The contents below are loaded from:");
        row.addTextSpan(FILE).css().bold();

        _contents = root.addDiv();
        _contents.css().flexChildFiller().auto().relative();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        _contents.getPostDomScript().setContents(getStaticHtml());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleReload()
    {
        _contents.ajaxSetContents(getStaticHtml());
    }

    //##################################################
    //# support
    //##################################################

    private String getStaticHtml()
    {
        String path = MyFilePaths.getWebPath(FILE);
        return Kmu.readFileString(path);
    }

}
