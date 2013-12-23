package com.app.ui.page.admin.accounts;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScStyledText;

import com.app.model.MyAccount;
import com.app.ui.control.MyCard;

public class MyAccountSettingsViewCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScStyledText _nameText;
    private ScStyledText _ownerText;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScGroup group;
        group = addGroup("Account Settings");

        installFields(group);
        installFooter(group);
    }

    private void installFields(ScGroup group)
    {
        _nameText = new ScStyledText();
        _nameText.setLabel("Name");

        _ownerText = new ScStyledText();
        _ownerText.setLabel("Owner");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_nameText);
        fields.add(_ownerText);
    }

    private void installFooter(ScGroup group)
    {
        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addButton("Edit", newEditAction());
        footer.addButton("Transfer", newTransferAction());
        footer.addButton("Delete", newDeleteAction());
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
        MyAccount e = getPageSession().getCurrentAccount();

        _nameText.setValue(e.getName());
        _ownerText.setValue(e.getOwner().getName());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newEditAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEdit();
            }
        };
    }

    private ScActionIF newTransferAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTransfer();
            }
        };
    }

    private ScActionIF newDeleteAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDelete();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        getFrame().printEditCard();
    }

    private void handleTransfer()
    {
    }

    private void handleDelete()
    {
    }
}
