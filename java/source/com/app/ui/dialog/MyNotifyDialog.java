package com.app.ui.dialog;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTextSpan;

import com.app.ui.control.MyFormDialog;

/**
 * I am a prestyled dialog used for notification messages.
 * In addition to the standard dialog title, clients may
 * easily set my subtitle, and message.
 */
public class MyNotifyDialog
    extends MyFormDialog
{
    //##################################################
    //# usage
    //##################################################

    @SuppressWarnings("unused")
    private static void usage()
    {
        MyNotifyDialog e;
        e = MyDialogs.getNotifyDialog();
        e.setTitle("CANCEL JOB");
        e.setSubtitle("Cancel the Job.");
        e.setMessage("Some status information.");
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

    //##################################################
    //# constructor
    //##################################################

    protected MyNotifyDialog()
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
        dialog.setLabel("Notify");
        dialog.setFlavorCaution();

        ScDiv body;
        body = dialog.getBody();
        body.css().flexColumn().pad20();
        body.add(createSubtitle());
        body.add(createMessage());

        ScDiv footer;
        footer = dialog.showFooter().addButtonBox();
        footer.add(createCloseButton());
    }

    private ScControl createSubtitle()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().bold().marginBottom20();
        e.hide();
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

    private ScControl createCloseButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Close");
        e.setAction(newUncheckedAction(this::ajaxClose));
        e.setAutoFocus();
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

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        if ( _subtitle.hasValue() )
            _subtitle.show();
    }
}
