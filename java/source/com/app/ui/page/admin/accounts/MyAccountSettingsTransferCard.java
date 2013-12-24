package com.app.ui.page.admin.accounts;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScErrorBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyInvitation;
import com.app.model.meta.MyMetaInvitation;
import com.app.ui.control.MyCard;

public class MyAccountSettingsTransferCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScTextSpan  _messageText;
    private ScTextField _emailField;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScForm form;
        form = addForm();
        form.setSubmitAction(newSendAction());

        ScGroup group;
        group = form.addGroup("Transfer Account");

        installBody(group);
        installFooter(group);
    }

    private void installBody(ScGroup group)
    {
        MyMetaInvitation x = MyInvitation.Meta;

        _messageText = new ScTextSpan();
        _messageText.css().displayBlock();

        _emailField = x.ToEmail.newField();
        _emailField.setWidthFull();

        ScBox body;
        body = group.addPad();
        body.add(_messageText);
        body.addBreak();

        ScErrorBox box;
        box = body.addErrorBox();
        box.addLabel("New Owner Email");
        box.add(_emailField);
    }

    private void installFooter(ScGroup group)
    {
        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(newCancelAction());
        footer.addSubmitButton("Send Invitation");
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public MyAccountSettingsFrame getFrame()
    {
        return (MyAccountSettingsFrame)super.getFrame();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        _messageText.setValue(formatMessage());
    }

    private String formatMessage()
    {
        return ""
            + "This will send an invitation to permanently transfer ownership of "
            + getCurrentAccount().getName()
            + " to the following recipient. You will remain the owner until the"
            + " new owner accepts the invitation.";
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCancel();
            }
        };
    }

    private ScActionIF newSendAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSend();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleCancel()
    {
        closeCard();
    }

    private void handleSend()
    {
        ajax().hideAllErrors();
        validate();

        String email = _emailField.getValue();
        boolean isValid = Kmu.isValidEmailAddress(email);
        if ( !isValid )
            _emailField.error("Invalid");

        MyInvitation e;
        e = new MyInvitation();
        e.setFromUser(getCurrentUser());
        e.setToEmail(email);
        e.setTypeTransferAccount();
        e.setAccount(getCurrentAccount());

        ajax().toast("The invitation has been sent.");
        closeCard();
    }
}
