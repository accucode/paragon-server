package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

/**
 * Test layouts using simple boxes (divs) along with
 * basic padding and margin styles.
 */
public class MyPaddingTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPaddingTestPage instance = new MyPaddingTestPage();

    private MyPaddingTestPage()
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
        root.css().gapOuter();

        ScDiv box;
        box = addBlueBox(root, "one");

        box = addBlueBox(root, "two");
        box.css().pad();

        box = addBlueBox(root, "left a");
        box.css().pad().floatLeft();

        box = addBlueBox(root, "left b");
        box.css().pad().floatLeft();

        box = addBox(root, "no float");
        box.css().pad().boxPurple();

        return root;
    }

    public ScDiv addBlueBox(ScBox root, String msg)
    {
        ScDiv box;
        box = addBox(root, msg);
        box.css().boxBlue();
        return box;
    }

    public ScDiv addBox(ScBox root, String msg)
    {
        ScDiv box;
        box = root.addDiv();
        box.addParagraph(msg);
        box.addParagraph(msg);
        box.addParagraph(msg);
        return box;
    }
}
