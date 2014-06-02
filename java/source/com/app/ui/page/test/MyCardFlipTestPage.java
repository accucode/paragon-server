package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyCardFlipTestPage
    extends MyAbstractTestEntryPage
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

    private ScCardFrame _flipFrame;

    private ScCard      _flipFront;
    private ScCard      _flipBack;

    private ScCardFrame _fadeFrame;

    private ScCard      _fadeFront;
    private ScCard      _fadeBack;

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

        _flipFront = _flipFrame.addCard();
        _flipBack = _flipFrame.addCard();

        _fadeFront = _fadeFrame.addCard();
        _fadeBack = _fadeFrame.addCard();

        _flipFrame.setDefaultCard(_flipFront);
        _fadeFrame.setDefaultCard(_fadeFront);

        ScGroup front;
        front = _flipFront.addGroup("Flip");
        front.addPad().addText("THIS IS THE FRONT!");
        front.bodyStyle().height(400);

        ScGroup back;
        back = _flipBack.addGroup("Flip");
        back.addPad().addText("THIS IS THE BACK!");
        back.bodyStyle().height(400);

        front = _fadeFront.addGroup("Fade");
        front.addPad().addText("THIS IS THE FRONT!");
        front.bodyStyle().height(400);

        back = _fadeBack.addGroup("Fade");
        back.addPad().addText("THIS IS THE BACK!");
        back.bodyStyle().height(400);
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
        _flipFront.ajaxPrint();
        _fadeFront.ajaxPrint();
    }

    private void handleShowBack()
    {
        _flipBack.ajaxPrint();
        _fadeBack.ajaxPrint();
    }
}
