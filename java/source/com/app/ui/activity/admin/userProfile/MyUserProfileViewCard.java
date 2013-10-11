package com.app.ui.activity.admin.userProfile;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyUser;
import com.app.ui.control.MyCard;
import com.app.utility.MyButtonUrls;

public class MyUserProfileViewCard
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
        _nameField.setReadOnly();

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

        ScGroup group;
        group = form.addGroup("My Profile");

        installHeader(group);
        installFields(group);
        installFooter(group);
    }

    private void installHeader(ScGroup group)
    {
        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton editButton;
        editButton = header.addButton("Edit", newEditAction());
        editButton.setImage(MyButtonUrls.edit());
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
        footer.addButton("Change Password", newChangePasswordAction());
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

    private ScActionIF newEditAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleEdit();
            }
        };
    }

    private ScActionIF newChangePasswordAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleChangePassword();
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

    private void handleChangePassword()
    {
        getFrame().printChangePasswordCard();
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
