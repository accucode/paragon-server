package com.app.ui.control;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTextSpan;

/**
 * I am a prestyled dialog used for notification messages.
 * In addition to the standard dialog title, clients may
 * easily set my subtitle, and message.
 */
public class MyNotifyDialog
    extends MyDialog
{
    public static void main(String[] args)
    {
        MyNotifyDialog e;
        e = new MyNotifyDialog();
        e.setTitle("CANCEL ORDER");
        e.setSubtitle("Cancel the Sales Order.");
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

    public MyNotifyDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        MyDialog dialog;
        dialog = this;
        dialog.setLabel("Notify");
        dialog.setFlavorCaution();

        ScDiv body;
        body = dialog.getBody();
        body.css().flexColumn().columnSpacer20().pad20();
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

    private ScControl createCloseButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Close");
        e.setAction(this::ajaxClose);
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
}
