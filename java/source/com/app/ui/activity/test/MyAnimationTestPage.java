package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;

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

    private KmList<ScBox> _groupOneBoxes;
    private KmList<ScBox> _groupTwoBoxes;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().floatLeft().width(300).height(300);

        ScGroup group;
        ScDiv right;

        group = groups.addGroup("Asynchronous");
        right = group.getHeader().addFloatRight();
        right.css().padSpaced5();
        right.addButton("Toggle", newToggleGroupOneAction());
        _groupOneBoxes = addBoxesTo(group);

        group = groups.addGroup("Synchronous");
        right = group.getHeader().addFloatRight();
        right.css().padSpaced5();
        right.addButton("Toggle", newToggleGroupTwoAction());
        _groupTwoBoxes = addBoxesTo(group);

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

    private ScActionIF newToggleGroupOneAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleToggleGroupOne();
            }
        };
    }

    private ScActionIF newToggleGroupTwoAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleToggleGroupTwo();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleGroupOne()
    {
        KmList<ScBox> v = _groupOneBoxes;
        for ( ScBox e : v )
            e.ajax().toggle().slide();
    }

    private void handleToggleGroupTwo()
    {
        KmList<ScBox> v = _groupTwoBoxes;
        for ( ScBox e : v )
            e.ajax().toggle().slide().defer();
    }
}
