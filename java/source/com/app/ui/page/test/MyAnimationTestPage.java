package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
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

    private KmList<ScDiv> _group;

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
        root.css().fill().auto();

        ScGroup group;
        group = addGroup("Group");

        ScDiv right;
        right = group.getBanner().getRight();
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

    private KmList<ScDiv> addBoxesTo(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().flexColumn().pad().columnSpacer5();

        KmList<ScDiv> v = new KmList<>();

        int n = 5;
        for ( int i = 0; i < n; i++ )
        {
            ScDiv e = createBox(i);
            v.add(e);
            body.add(e);
        }

        return v;
    }

    private ScDiv createBox(int i)
    {
        ScDiv e;
        e = new ScDiv();
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
        KmList<ScDiv> v = _group;
        for ( ScDiv e : v )
            e.ajaxToggle().slide();
    }

    private void handleSyncToggle()
    {
        ScBlockScript ajax = ajax();

        KmList<ScDiv> v = _group;
        for ( ScDiv e : v )
        {
            ajax.toggle(e).slide();
            e.ajaxPushWhenDone();
        }
    }
}
