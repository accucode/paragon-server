package com.app.ui.page.admin.userProfile;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyUser;
import com.app.ui.control.MyCard;

public class MyUserProfileEditCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScTextField _emailField;
    private ScTextField _roleField;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        createFields();
        installLayout();
    }

    private void createFields()
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");
        _nameField.css().padLeft5();

        _emailField = new ScTextField();
        _emailField.setLabel("Email");
        _emailField.css().padLeft5();
        _emailField.setReadOnly();

        _roleField = new ScTextField();
        _roleField.setLabel("Role");
        _roleField.css().padLeft5();
        _roleField.setReadOnly();
    }

    private void installLayout()
    {
        ScForm form;
        form = addForm();
        form.css().gap();
        form.setDefaultAction(newSaveAction());

        ScGroup group;
        group = form.addGroup("My Profile");

        installFields(group);
        installFooter(group);
    }

    private void installFields(ScGroup group)
    {
        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_nameField);
        fields.add(_emailField);
        fields.add(_roleField);
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
    public MyUserProfileFrame getFrame()
    {
        return (MyUserProfileFrame)super.getFrame();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        refreshFields();
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleCancel();
            }
        };
    }

    private ScActionIF newSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSave();
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

    private void handleSave()
    {
        validate();

        String name = _nameField.getValue();

        MyUser e;
        e = getCurrentUser();
        e.setName(name);

        ajax().toast("Changes Saved.").success();

        closeCard();
    }

    //##################################################
    //# support
    //##################################################

    private void refreshFields()
    {
        MyUser u = getCurrentUser();

        _nameField.setValue(u.getName());
        _nameField.ajax().replace();

        _emailField.setValue(u.getEmail());
        _emailField.ajax().replace();

        _roleField.setValue(u.getRoleName());
        _roleField.ajax().replace();
    }

}
