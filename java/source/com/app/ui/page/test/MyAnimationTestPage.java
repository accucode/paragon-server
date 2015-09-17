package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.script.ScBlockScript;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAnimationTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAnimationTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyAnimationTestPage();
    }

    public static MyAnimationTestPage getInstance()
    {
        return _instance;
    }

    private MyAnimationTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<ScBox> _group;

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

        ScGroup group;
        group = addGroup("Group");

        ScDiv right;
        right = group.getBanner().addFloatRight();
        right.css().gap5();
        right.addButton("Async", this::handleAsyncToggle);
        right.addButton("Sync", this::handleSyncToggle);

        _group = addBoxesTo(group);
    }

    private ScGroup addGroup(String title)
    {
        ScGroup e;
        e = getRoot().addGroup();
        e.setTitle(title);
        e.layoutInline();
        e.style().width(300).height(300);
        return e;
    }

    private KmList<ScBox> addBoxesTo(ScGroup group)
    {
        ScBox lines;
        lines = group.getBody().addLines();

        KmList<ScBox> v = new KmList<>();

        int n = 5;
        for ( int i = 0; i < n; i++ )
        {
            ScBox e = createBox(i);
            v.add(e);
            lines.add(e);
        }

        return v;
    }

    private ScBox createBox(int i)
    {
        ScBox e;
        e = new ScBox();
        e.css().boxBlue().pad().hide();
        e.addText("box " + (i + 1));
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

    //##################################################
    //# handle
    //##################################################

    private void handleAsyncToggle()
    {
        KmList<ScBox> v = _group;
        for ( ScBox e : v )
            e.ajax().toggle().slide();
    }

    private void handleSyncToggle()
    {
        ScBlockScript ajax = ajax();

        KmList<ScBox> v = _group;
        for ( ScBox e : v )
        {
            ajax.toggle(e).slide();
            e.ajax().pushWhenDone();
        }
    }
}
