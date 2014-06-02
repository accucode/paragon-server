package com.app.ui.page.admin.accountSettings;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScTextSpan;

import com.app.model.MyAccount;
import com.app.ui.control.MyCard;

public class MyAccountSettingsViewCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScTextSpan _nameText;
    private ScTextSpan _ownerText;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScGroup group;
        group = addGroup("Account Settings");
        group.layoutNormalWithFooter();

        installFields(group);
        installFooter(group);
    }

    private void installFields(ScGroup group)
    {
        _nameText = new ScTextSpan();
        _nameText.setLabel("Name");

        _ownerText = new ScTextSpan();
        _ownerText.setLabel("Owner");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_nameText);
        fields.add(_ownerText);
    }

    private void installFooter(ScGroup group)
    {
        ScBox buttons;
        buttons = group.getFooter().addButtonBoxRight();
        buttons.addButton("Edit", newEditAction());
        buttons.addButton("Transfer", newTransferAction());
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
        MyAccount e = getServerSession().getCurrentAccount();

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

    //##################################################
    //# handle
    //##################################################

    private void handleEdit()
    {
        getFrame().printEditCard();
    }

    private void handleTransfer()
    {
        getFrame().printTransferCard();
    }
}
