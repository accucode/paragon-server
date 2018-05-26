package com.app.ui.email;

import com.kodemore.collection.KmList;

import com.app.ui.email.MyAbstractEmailComposerRecipientDialog;

/**
 * I am used to edit the default recipients for an email template.
 */
public class MyEmailComposerCcRecipientDialog
    extends MyAbstractEmailComposerRecipientDialog
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailComposerCcRecipientDialog(MyEmailComposerForm form)
    {
        super(form);

        setLabel("Choose CC Recipients");
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyEmails()
    {
        getEmailComposer().ajaxSetCcRecipients(formatEmails());
    }

    //##################################################
    //# current
    //##################################################

    @Override
    protected KmList<String> getCurrentEmails()
    {
        return getEmailComposer().getCcEmails();
    }
}
