package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmTimestamp;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the layout and usage of the groups.
 */
public final class MyDownloadTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDownloadTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDownloadTestPage();
    }

    public static MyDownloadTestPage getInstance()
    {
        return _instance;
    }

    private MyDownloadTestPage()
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
        root.addButton("Download", this::handleDownload);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleDownload()
    {
        String name = "sample.txt";

        KmStringBuilder value;
        value = new KmStringBuilder();
        value.println("Sample file");
        value.println(KmTimestamp.nowUtc().toLocal());

        ajax().download(name, value);
    }

}
