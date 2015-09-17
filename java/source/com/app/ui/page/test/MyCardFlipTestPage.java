package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyCardFlipTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyCardFlipTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyCardFlipTestPage();
    }

    public static MyCardFlipTestPage getInstance()
    {
        return _instance;
    }

    private MyCardFlipTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScCardFrame _flipFrame;

    private ScCard _flipFront;
    private ScCard _flipBack;

    private ScCardFrame _fadeFrame;

    private ScCard _fadeFront;
    private ScCard _fadeBack;

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

        ScBox buttons;
        buttons = root.addButtonBox();
        buttons.addButton("Show Front", this::handleShowFront);
        buttons.addButton("Show Back", this::handleShowBack);

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
        front.getBody().addPad().addText("THIS IS THE FRONT!");
        front.bodyStyle().height(400);

        ScGroup back;
        back = _flipBack.addGroup("Flip");
        back.getBody().addPad().addText("THIS IS THE BACK!");
        back.bodyStyle().height(400);

        front = _fadeFront.addGroup("Fade");
        front.getBody().addPad().addText("THIS IS THE FRONT!");
        front.bodyStyle().height(400);

        back = _fadeBack.addGroup("Fade");
        back.getBody().addPad().addText("THIS IS THE BACK!");
        back.bodyStyle().height(400);
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
