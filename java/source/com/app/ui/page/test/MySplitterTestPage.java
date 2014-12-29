package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScSplitter;
import com.kodemore.utility.Kmu;

public class MySplitterTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySplitterTestPage instance = new MySplitterTestPage();

    private MySplitterTestPage()
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

}
