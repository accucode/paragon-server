package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

/**
 * Simple html5 gradients.
 */
public class MyGradientTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyGradientTestPage instance = new MyGradientTestPage();

    private MyGradientTestPage()
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
        root.css().padSpaced();

        addBoxDownTo(root, "white", "black");
        addBoxDownTo(root, "white", "blue");
        addBoxDownTo(root, "white", "yellow", "blue");
        addBoxDownTo(root, "white", "yellow", "blue", "red");
        addBoxDownTo(root, "white", "yellow", "blue", "red", "black");

        return root;
    }

    private ScBox addBoxDownTo(ScBox root, String... colors)
    {
        ScBox box;
        box = root.addBox();
        box.css().pad().border().floatLeft();
        box.style().width(200);
        box.style().height(200);
        box.style().gradientDown(colors);
        box.addText(Kmu.formatList(colors));
        return box;
    }

}
