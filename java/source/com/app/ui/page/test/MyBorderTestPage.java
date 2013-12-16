package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

public class MyBorderTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyBorderTestPage instance = new MyBorderTestPage();

    private MyBorderTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public void initUrlFromSession(ScParameterList v)
    {
        // none
    }

    @Override
    public void initSessionFromUrl(ScParameterList v)
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

    public ScDiv addBox(ScDiv root)
    {
        ScDiv div;
        div = root.addBox();
        div.css().gap();
        return div;
    }
}
