package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the layout and usage of the groups.
 */
public final class MyGroupTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyGroupTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyGroupTestPage();
    }

    public static MyGroupTestPage getInstance()
    {
        return _instance;
    }

    private MyGroupTestPage()
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

    private ScGroup newGroup(String title, String msg)
    {
        String text = Kmu.repeat(msg + "\n", 3);

        ScGroup group;
        group = new ScGroup();
        group.setTitle(title);

        ScDiv body;
        body = group.getBody();
        body.css().pad();
        body.addText(text);

        return group;
    }

    private ScGroup newClearGroup(String title, String msg)
    {
        ScGroup e;
        e = newGroup(title, msg);
        e.css().clearBoth();
        return e;
    }

    private ScGroup newLeftGroup(String title, String msg)
    {
        ScGroup e;
        e = newGroup(title, msg);
        e.css().floatLeft().width200();
        return e;
    }

    private ScGroup newLeftClearGroup(String title, String msg)
    {
        ScGroup e;
        e = newLeftGroup(title, msg);
        e.css().clearBoth();
        return e;
    }

    private ScGroup newRightGroup(String title, String msg)
    {
        ScGroup e;
        e = newGroup(title, msg);
        e.style().floatRight().width(200);
        return e;
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
