package com.app.ui.dialog;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.script.ScBlockScript;

import com.app.ui.control.MyFormDialog;

/**
 * I am a prestyled dialog used for confirmation messages.
 * In addition to the standard dialog title, clients may
 * easily set my subtitle, message, and confirmation text.
 *
 * I have two buttons for the positive and negative actions.
 * The negative button simply closes the dialog.
 * The positive button automatically closed the dialog,
 * then initiates the positive action.
 */
public class MyConfirmDialog
    extends MyFormDialog
{
    //##################################################
    //# example
    //##################################################

    @SuppressWarnings("unused")
    private static void usage()
    {
        /**
         * The action is typically bound to a local ivar
         * and transiently assigned to the dialog immediately
         * before you render/open it.
         */
        ScAction someAction = null;

        MyConfirmDialog e;
        e = MyDialogs.getConfirmDialog();
        e.setTitle("Do the thing?");
        e.setSubtitle("A short warning.");
        e.setMessage("Some longer, potentially multi-line explanation.");
        e.setPositiveAction(someAction);
        e.setFlavorCaution();
        e.ajaxOpen();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * A short bold message at the top of the dialog body.
     * Default: Confirm the action.
     */
    private ScTextSpan _subtitle;

    /**
     * A paragraph that explains the context.
     * Default: None.
     */
    private ScTextSpan _message;

    /**
     * The confirmation message at the bottom of the dialog.
     * Default: "Are you sure?"
     */
    private ScTextSpan _confirmation;

    /**
     * Clicking this button means the user wants to continue.
     * Default text:    Ok
     * Default action:  None.
     */
    private ScScriptButton _positiveButton;

    /**
     * Cancel the action, do not proceed.
     * Default text:   Cancel
     * Default action: close the dialog.
     */
    private ScActionButton _negativeButton;

    //##################################################
    //# constructor
    //##################################################

    protected MyConfirmDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        MyFormDialog dialog;
        dialog = this;
        dialog.setLabel("Confirm");
        dialog.setFlavorCaution();

        ScDiv body;
        body = dialog.getBody();
        body.css().flexColumn().columnSpacer20().pad20();
        body.add(createSubtitle());
        body.add(createMessage());
        body.add(createConfirmation());

        ScDiv footer;
        footer = dialog.showFooter().addButtonBox();
        footer.add(createPositiveButton());
        footer.add(createNegativeButton());
    }

    private ScControl createSubtitle()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.setValue("Confirm the action.");
        e.css().bold();
        _subtitle = e;
        return e;
    }

    private ScControl createMessage()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        _message = e;
        return e;
    }

    private ScControl createConfirmation()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.setValue("Are you sure?");
        e.css().bold();
        _confirmation = e;
        return e;
    }

    private ScControl createPositiveButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.setText("Yes");
        e.setFlavorPositive();
        e.setIcon().nameDone().styleLight();
        _positiveButton = e;
        return e;
    }

    private ScControl createNegativeButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("No");
        e.setFlavorNegative();
        e.setIcon().nameClose().styleLight();
        e.setAction(newUncheckedAction(this::ajaxClose));
        e.setAutoFocus();
        _negativeButton = e;
        return e;
    }

    //##################################################
    //# accessing :: messages
    //##################################################

    public void setTitle(String s)
    {
        setLabel(s);
    }

    public void setSubtitle(String s)
    {
        _subtitle.setValue(s);
    }

    public void setMessage(String s)
    {
        _message.setValue(s);
    }

    public void setConfirmation(String s)
    {
        _confirmation.setValue(s);
    }

    public void setPositiveText(String s)
    {
        _positiveButton.setText(s);
    }

    public void setPositiveAction(Runnable e)
    {
        setPositiveAction(newUncheckedAction(e));
    }

    public void setPositiveAction(ScAction action)
    {
        ScBlockScript script;
        script = ScBlockScript.create();
        script.closeDialog(this);
        script.run(action);
        _positiveButton.setScript(script);
    }

    public void setPositiveAction(ScAction action, Object arg)
    {
        ScBlockScript script;
        script = ScBlockScript.create();
        script.closeDialog(this);
        script.run(action, arg);
        _positiveButton.setScript(script);
    }

    public void setPositiveWarning()
    {
        _positiveButton.setFlavorWarn();
    }

    public void setNegativeText(String s)
    {
        _negativeButton.setText(s);
    }

}
