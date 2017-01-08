package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyBorderTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyBorderTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyBorderTestPage();
    }

    public static MyBorderTestPage getInstance()
    {
        return _instance;
    }

    private MyBorderTestPage()
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
        root.css().fill().auto().boxGray().gap();

        ScDiv div = root.addDiv();

        ScDiv dotted = addBox(div);
        dotted.css().borderDotted();
        dotted.addText("Dotted");

        div.addSpace();

        ScDiv dashed = addBox(div);
        dashed.css().borderDashed();
        dashed.addText("Dashed");

        div.addSpace();

        ScDiv solid = addBox(div);
        solid.css().borderSolid();
        solid.addText("Solid");

        div.addSpace();

        ScDiv doubleCss = addBox(div);
        doubleCss.css().borderDouble();
        doubleCss.addText("Double");

        div.addSpace();

        ScDiv groove = addBox(div);
        groove.css().borderGroove();
        groove.addText("Groove");

        div.addSpace();

        ScDiv ridge = addBox(div);
        ridge.css().borderRidge();
        ridge.addText("Ridge");

        div.addSpace();

        ScDiv inset = addBox(div);
        inset.css().borderInset();
        inset.addText("Inset");

        div.addSpace();

        ScDiv outset = addBox(div);
        outset.css().borderOutset();
        outset.addText("Outset");
    }

    private ScDiv addBox(ScDiv root)
    {
        ScDiv div;
        div = root.addDiv();
        div.css().gap();
        return div;
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
