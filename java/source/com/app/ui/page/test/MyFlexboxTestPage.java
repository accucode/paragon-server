package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTextSpan;

public class MyFlexboxTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyFlexboxTestPage instance = new MyFlexboxTestPage();

    private MyFlexboxTestPage()
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
        root.css().gap();

        installTest1On(root);
        installTest2On(root);
    }

    private void installTest1On(ScContainer root)
    {
        ScFlexbox row;
        row = root.addRow();
        row.alignSpaced();
        row.crossAlignCenter();
        row.css().boxBlue();

        ScTextSpan item;
        item = row.addTextSpan("left");
        item.css().boxGray().pad();

        item = row.addTextSpan("center\ncenter\ncenter");
        item.css().boxGray().pad();

        item = row.addTextSpan("right");
        item.css().boxGray().pad();
    }

    private void installTest2On(ScContainer root)
    {
        ScFlexbox row;
        row = root.addRow();
        row.css().boxYellow().gap();
        row.wrap();

        int n = 10;
        for ( int i = 0; i < n; i++ )
            addGroupOn(row, i);
    }

    //##################################################
    //# support
    //##################################################

    private void addGroupOn(ScContainer root, int n)
    {
        String title = "Group-" + n;

        ScGroup group;
        group = root.addGroup(title);
        group.bodyCss().pad();

        for ( int i = 0; i < n; i++ )
            group.getBody().addTextParagraph("Line-" + i);
    }

}
