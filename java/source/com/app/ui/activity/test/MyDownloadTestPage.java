package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmTimestamp;

/**
 * Test the layout and usage of the groups.
 */
public class MyDownloadTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDownloadTestPage instance = new MyDownloadTestPage();

    private MyDownloadTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

        root.addButton("Download", newDownloadAction());

        return root;
    }

    private ScActionIF newDownloadAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDownload();
            }
        };
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
        value.println(KmTimestamp.createNowLocal());

        ajax().download(name, value);
    }

}
