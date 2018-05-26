package com.app.ui.macro;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.script.ScBlockScript;

import com.app.macro.MyMacroContextType;
import com.app.macro.MyMacroListView;
import com.app.ui.control.MyFormDialog;

/**
 * I am used to view and select the available macros for a given context type.
 */
public class MyMacroDialog
    extends MyFormDialog
{
    //##################################################
    //# constants
    //##################################################

    private static final int DIALOG_WIDTH = 800;

    //##################################################
    //# variables
    //##################################################

    private MyMacroListView _macroView;

    //##################################################
    //# constructor
    //##################################################

    public MyMacroDialog()
    {
        MyFormDialog dialog;
        dialog = this;
        dialog.setLabel("Macros");
        dialog.setWidth(DIALOG_WIDTH);

        installBodyOn(dialog);
        installFooterOn(dialog);
    }

    //##################################################
    //# install :: body
    //##################################################

    private void installBodyOn(MyFormDialog dialog)
    {
        ScDiv body;
        body = dialog.getBody();
        body.css().pad20().columnSpacer20();
        body.add(createMacroView());
    }

    private MyMacroListView createMacroView()
    {
        MyMacroListView e;
        e = new MyMacroListView();
        _macroView = e;
        return e;
    }

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooterOn(MyFormDialog dialog)
    {
        ScDiv footer;
        footer = dialog.showFooter();
        footer.css().buttonBox();
        footer.add(createCopyAndCloseButton());
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    private ScControl createCopyAndCloseButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.setText("Copy Token & Close");
        e.setIcon().nameContentCopy().styleLight();
        e.setPrimary();
        e.setFlavorPositive();
        e.setScript(getCopyAndCloseScript());
        return e;
    }

    private ScBlockScript getCopyAndCloseScript()
    {
        ScBlockScript e;
        e = ScBlockScript.create();
        e.run(_macroView.getCopyScript());
        e.closeDialog(this);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    public void ajaxOpen(MyMacroContextType contextType)
    {
        _macroView.setContextType(contextType);

        super.ajaxOpen();
    }
}
