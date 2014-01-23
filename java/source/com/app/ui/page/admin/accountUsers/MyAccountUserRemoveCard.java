package com.app.ui.page.admin.accountUsers;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScTextSpan;

import com.app.model.MyAccount;
import com.app.model.MyUser;
import com.app.ui.control.MyCard;

public class MyAccountUserRemoveCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScTextSpan _messageText;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScForm form;
        form = addForm();
        form.setSubmitAction(newRemoveAction());

        ScOldGroup group;
        group = form.addOldGroup("Remove User");

        installBody(group);
        installFooter(group);
    }

    private void installBody(ScOldGroup group)
    {
        _messageText = new ScTextSpan();
        _messageText.css().displayBlock();

        ScBox body;
        body = group.addPad();
        body.add(_messageText);
    }

    private void installFooter(ScOldGroup group)
    {
        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(newCancelAction());
        footer.addSubmitButton("Remove User");
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public MyAccountUserFrame getFrame()
    {
        return (MyAccountUserFrame)super.getFrame();
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
            + "This will permanently remove "
            + getSelectedUser().getName()
            + "'s access to the "
            + getSelectedAccount().getName()
            + " account.";
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

    private ScActionIF newRemoveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRemove();
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

    private void handleRemove()
    {
        ajax().toast("remove the user");
        closeCard();
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getSelectedUser()
    {
        // todo_wyatt: selectedUser
        return null;
    }

    private MyAccount getSelectedAccount()
    {
        // todo_wyatt: selectedAccount;
        return null;
    }
}
