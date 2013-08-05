package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

/**
 * Test the layout and usage of the groups.
 */
public class MyGroupTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyGroupTestPage instance = new MyGroupTestPage();

    private MyGroupTestPage()
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

        root.add(newGroup("aaa", "the gaps between children are provided the class padSpaced"));
        root.add(newGroup("bbb", "normal"));

        root.add(newLeftGroup("ccc", "floatLeft fixedWidth"));
        root.add(newLeftGroup("ddd", "floatLeft fixedWidth"));
        root.add(newGroup("eee", "eagle"));

        root.add(newLeftGroup("fff", "floatLeft fixedWidth"));
        root.add(newRightGroup("ggg", "floatRight fixedWidth"));
        root.add(newGroup("hhh", "normal, the padSpaced class doesn't seem to work correctly here"));

        root.add(newGroup("iii", "normal"));

        return root;
    }

    private ScGroup newGroup(String title, String msg)
    {
        String body = Kmu.repeat(msg + "\n", 3);

        ScGroup e;
        e = new ScGroup();
        e.setTitle(title);
        e.addPad().addText(body);
        return e;
    }

    private ScGroup newLeftGroup(String title, String msg)
    {
        ScGroup e;
        e = newGroup(title, msg);
        e.style().floatLeft().width(200);
        return e;
    }

    private ScGroup newRightGroup(String title, String msg)
    {
        ScGroup e;
        e = newGroup(title, msg);
        e.style().floatRight().width(200);
        return e;
    }

}
