package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFrame;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

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

    private ScFrame      _flipFrame;

    private ScFrameChild _flipFront;
    private ScFrameChild _flipBack;

    private ScFrame      _fadeFrame;

    private ScFrameChild _fadeFront;
    private ScFrameChild _fadeBack;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

        ScBox buttons;
        buttons = root.addButtonBox();
        buttons.addButton("Show Front", newShowFrontAction());
        buttons.addButton("Show Back", newShowBackAction());

        _flipFrame = root.addFrame();
        _flipFrame.style().floatLeft().width(300);
        _flipFrame.setHideFlip();
        _flipFrame.setShowFlip();

        _fadeFrame = root.addFrame();
        _fadeFrame.style().floatLeft().width(300);
        _fadeFrame.setHideFade();
        _fadeFrame.setShowFade();

        _flipFront = _flipFrame.createChild();
        _flipBack = _flipFrame.createChild();

        _fadeFront = _fadeFrame.createChild();
        _fadeBack = _fadeFrame.createChild();

        _flipFrame.setDefaultChild(_flipFront);
        _fadeFrame.setDefaultChild(_fadeFront);

        ScGroup front;
        front = _flipFront.addGroup("Front");
        front.addPad().addText("THIS IS THE FRONT!");
        front.style().height(400);

        ScGroup back;
        back = _flipBack.addGroup("Back");
        back.addPad().addText("THIS IS THE BACK!");
        back.style().height(400);

        front = _fadeFront.addGroup("Front");
        front.addPad().addText("THIS IS THE FRONT!");
        front.style().height(400);

        back = _fadeBack.addGroup("Back");
        back.addPad().addText("THIS IS THE BACK!");
        back.style().height(400);

        return root;
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newShowFrontAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleShowFront();
            }
        };
    }

    private ScActionIF newShowBackAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleShowBack();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleShowFront()
    {
        _flipFrame.ajaxPrint(_flipFront);
        _fadeFrame.ajaxPrint(_fadeFront);
    }

    private void handleShowBack()
    {
        _flipFrame.ajaxPrint(_flipBack);
        _fadeFrame.ajaxPrint(_fadeBack);
    }
}
