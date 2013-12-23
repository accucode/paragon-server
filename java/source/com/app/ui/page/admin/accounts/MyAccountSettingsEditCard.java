package com.app.ui.page.admin.accounts;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScStyledText;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyAccount;
import com.app.model.meta.MyMetaAccount;
import com.app.ui.control.MyCard;

public class MyAccountSettingsEditCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField  _nameField;
    private ScStyledText _ownerText;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        ScForm form;
        form = addForm();
        form.setDefaultAction(newSaveAction());

        ScGroup group;
        group = form.addGroup("Account Settings");

        installFields(group);
        installFooter(group);
    }

    private void installFields(ScGroup group)
    {
        MyMetaAccount x = MyAccount.Meta;

        _nameField = x.Name.newField();
        _nameField.setLabel("Name");

        _ownerText = new ScStyledText();
        _ownerText.setLabel("Owner");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_nameField);
        fields.add(_ownerText);
    }

    private void installFooter(ScGroup group)
    {
        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(newCancelAction());
        footer.addSubmitButton("Save");
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

        _nameField.setValue(e.getName());
        _ownerText.setValue(e.getOwner().getName());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSave();
            }
        };
    }

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

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        validate();

        MyAccount e;
        e = getCurrentAccount();
        e.applyFrom(this);
        e.validate();

        closeCard();
    }

    private void handleCancel()
    {
        closeCard();
    }
}
