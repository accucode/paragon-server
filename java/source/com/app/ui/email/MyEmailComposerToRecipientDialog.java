package com.app.ui.email;

import com.kodemore.collection.KmList;

import com.app.ui.email.MyAbstractEmailComposerRecipientDialog;

/**
 * I am used to edit the default recipients for an email template.
 */
public class MyEmailComposerToRecipientDialog
    extends MyAbstractEmailComposerRecipientDialog
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailComposerToRecipientDialog(MyEmailComposerForm form)
    {
        super(form);

        setLabel("Choose To Recipients");
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyEmails()
    {
        getEmailComposer().ajaxSetToRecipients(formatEmails());
    }

    //##################################################
    //# current
    //##################################################

    @Override
    protected KmList<String> getCurrentEmails()
    {
        return getEmailComposer().getToEmails();
    }
}
