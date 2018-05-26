package com.app.ui.page.guide;

import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScChoiceField;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public class MyProjectSetupHomePage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectSetupHomePage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectSetupHomePage();
    }

    public static MyProjectSetupHomePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# constants
    //##################################################

    private static final String MODE_SIMPLE   = "Simple";
    private static final String MODE_ADVANCED = "Advanced";

    //##################################################
    //# variables
    //##################################################

    private ScChoiceField<String>      _modeField;
    private ScCardFrame                _frame;
    private MyProjectSetupSimpleCard   _simpleCard;
    private MyProjectSetupAdvancedCard _advancedCard;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectManager;
    }

    @Override
    public String getHelpMessage()
    {
        return "This page serves as a guide to help you set up new projects.";
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().flexColumn().columnSpacer10();
        root.add(createChoiceRow());
        root.add(createFrame());
    }

    private ScControl createChoiceRow()
    {
        ScForm e;
        e = new ScForm();
        e.css().flexRow().flexChildStatic();
        e.add(createChoiceField());
        return e;
    }

    private ScControl createChoiceField()
    {
        ScChoiceField<String> e;
        e = new ScChoiceField<>();
        e.onChange(newUncheckedAction(this::handleModeChanged));
        e.addOption(MODE_SIMPLE);
        e.addOption(MODE_ADVANCED);
        e.setValue(MODE_SIMPLE);
        e.disableChangeTracking();
        _modeField = e;
        return e;
    }

    private ScControl createFrame()
    {
        ScCardFrame e;
        e = new ScCardFrame();
        e.css().flexColumn().flexChildFiller();
        e.addCard(createSimpleCard());
        e.addCard(createAdvancedCard());
        e.setDefaultCard(_simpleCard);
        _frame = e;
        return e;
    }

    //==================================================
    //= install :: simple
    //==================================================

    private MyProjectSetupSimpleCard createSimpleCard()
    {
        MyProjectSetupSimpleCard card;
        card = new MyProjectSetupSimpleCard();
        _simpleCard = card;
        return card;
    }

    private MyProjectSetupAdvancedCard createAdvancedCard()
    {
        MyProjectSetupAdvancedCard card;
        card = new MyProjectSetupAdvancedCard();
        _advancedCard = card;
        return card;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleModeChanged()
    {
        String code = _modeField.getValue();

        if ( Kmu.isEqual(code, MODE_SIMPLE) )
            _frame.ajaxPrint(_simpleCard);

        if ( Kmu.isEqual(code, MODE_ADVANCED) )
            _frame.ajaxPrint(_advancedCard);
    }
}
