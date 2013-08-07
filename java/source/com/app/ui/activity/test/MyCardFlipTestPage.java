package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFrame;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

// review_aaron: card flip test
public class MyCardFlipTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyCardFlipTestPage instance = new MyCardFlipTestPage();

    private MyCardFlipTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFrame      _frame;

    private ScFrameChild _childFront;
    private ScFrameChild _childBack;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        _frame = root.addFrame();
        _frame.style().width(300);

        _childFront = _frame.createChild();
        _childBack = _frame.createChild();

        _frame.setDefaultChild(_childFront);

        ScGroup front;
        front = _childFront.addGroup("Front");
        front.addPad().addText("THIS IS THE FRONT!");
        front.style().height(400);
        front.getHeader().addPad().addFloatRight().addButton("Flip!", newFlipToBackAction());

        ScGroup back;
        back = _childBack.addGroup("Back");
        back.addPad().addText("THIS IS THE BACK!");
        back.style().height(400);
        back.getHeader().addPad().addFloatRight().addButton("Flip!", newFlipToFrontAction());

        return root;
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newFlipToFrontAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleFlipToFront();
            }
        };
    }

    private ScActionIF newFlipToBackAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleFlipToBack();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleFlipToFront()
    {
        _frame.ajaxFlipTo(_childFront);
    }

    private void handleFlipToBack()
    {
        _frame.ajaxFlipTo(_childBack);
    }
}
