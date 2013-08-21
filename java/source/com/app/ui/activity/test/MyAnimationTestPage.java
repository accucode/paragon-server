package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

public class MyAnimationTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAnimationTestPage instance = new MyAnimationTestPage();

    private MyAnimationTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<ScBox> _group;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().floatLeft().width(300).height(300);

        ScGroup group;
        ScDiv right;

        group = groups.addGroup("Group");
        right = group.getHeader().addFloatRight();
        right.css().gap();
        right.addButton("Async", newAsyncToggleAction());
        right.addButton("Sync", newSyncToggleAction());
        _group = addBoxesTo(group);

        return root;
    }

    private KmList<ScBox> addBoxesTo(ScGroup group)
    {
        ScBox lines;
        lines = group.addLines();

        KmList<ScBox> v = new KmList<ScBox>();

        int n = 5;
        for ( int i = 0; i < n; i++ )
        {
            ScBox e;
            e = createBox(i);

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

    private ScActionIF newAsyncToggleAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAsyncToggle();
            }
        };
    }

    private ScActionIF newSyncToggleAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSyncToggle();
            }
        };
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
        KmList<ScBox> v = _group;
        for ( ScBox e : v )
            e.ajax().toggle().slide().defer();
    }
}
