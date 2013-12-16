package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

/**
 * Simple html5 gradients.
 */
public class MyGradientTestPage
    extends MyTestPage
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
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeUrlParameters()
    {
        return null;
    }

    @Override
    public void applyUrlParameters(ScParameterList v)
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

        addBoxDownTo(root, "white", "black");
        addBoxDownTo(root, "white", "blue");
        addBoxDownTo(root, "white", "yellow", "blue");
        addBoxDownTo(root, "white", "yellow", "blue", "red");
        addBoxDownTo(root, "white", "yellow", "blue", "red", "black");
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
