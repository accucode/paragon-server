package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.utility.MyButtonUrls;

/**
 * Include the content found at /web/test/staticInclude.html
 */
public class MyStaticIncludeTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyStaticIncludeTestPage instance = new MyStaticIncludeTestPage();

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

        ScFlexbox col;
        col = root.addColumn();
        col.css().fill();

        ScFlexbox row;
        row = col.addRow();
        row.crossAlignCenter();
        row.css().boxBlue().gap();

        ScActionButton button;
        button = row.addButton("Reload", this::handleReload);
        button.setImage(MyButtonUrls.refresh());

        row.addTextSpan("The contents below are loaded from:");
        row.addTextSpan(FILE).css().bold();

        _contents = col.addFiller();
        _contents.css().relative();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        _contents.getPostDomScript().setContents(getStaticHtml());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleReload()
    {
        _contents.ajax().setContents(getStaticHtml());
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
