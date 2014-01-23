package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScOldGroup;
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

        root.add(newGroup("aaa", "the gaps between children are provided the css 'gap'."));
        root.add(newGroup("bbb", "normal"));

        root.add(newLeftGroup("ccc", "floatLeft fixedWidth"));
        root.add(newLeftGroup("ddd", "floatLeft fixedWidth"));
        root.add(newRightGroup("eee", "floatRight fixedWidth"));

        root.add(newLeftClearGroup("fff", "floatLeft fixedWidth clearBoth"));
        root.add(newRightGroup("ggg", "floatRight fixedWidth"));
        root.add(newRightGroup("hhh", "floatRight fixedWidth"));

        root.add(newClearGroup("iii", "normal, clearBoth"));
        root.add(newGroup("jjj", "normal"));
    }

    private ScOldGroup newGroup(String title, String msg)
    {
        String body = Kmu.repeat(msg + "\n", 3);

        ScOldGroup e;
        e = new ScOldGroup();
        e.setTitle(title);
        e.addPad().addText(body);
        return e;
    }

    private ScOldGroup newClearGroup(String title, String msg)
    {
        ScOldGroup e;
        e = newGroup(title, msg);
        e.css().clearBoth();
        return e;
    }

    private ScOldGroup newLeftGroup(String title, String msg)
    {
        ScOldGroup e;
        e = newGroup(title, msg);
        e.css().floatLeft().width200();
        return e;
    }

    private ScOldGroup newLeftClearGroup(String title, String msg)
    {
        ScOldGroup e;
        e = newLeftGroup(title, msg);
        e.css().clearBoth();
        return e;
    }

    private ScOldGroup newRightGroup(String title, String msg)
    {
        ScOldGroup e;
        e = newGroup(title, msg);
        e.style().floatRight().width(200);
        return e;
    }

}
