package com.app.ui.activity.admin;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.ui.activity.MyActivity;
import com.app.utility.MyButtonUrls;

public class MyProfilePage
    extends MyAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyProfilePage();

    private MyProfilePage()
    {
        // singleton 
    }

    //##################################################
    //# variables
    //##################################################

    private ScCardFrame     _profileFrame;

    private ScCard          _viewCard;
    private ScCard          _editCard;
    private ScCard          _passwordCard;

    private ScTextField     _viewNameField;
    private ScTextField     _viewEmailField;
    private ScTextField     _viewRoleField;

    private ScTextField     _editNameField;
    private ScTextField     _editEmailField;
    private ScTextField     _editRoleField;

    private ScTextField     _pwViewNameField;
    private ScTextField     _pwViewEmailField;
    private ScTextField     _pwViewRoleField;

    private ScPasswordField _oldPasswordField;
    private ScPasswordField _newPasswordField;
    private ScPasswordField _retypePasswordField;

    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean requiresAccountMember()
    {
        return true;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScArray row;
        row = root.addRow();

        _profileFrame = row.addFrame();
        _profileFrame.setHideFlip();
        _profileFrame.setShowFlip();

        installMyProfileCard();
        installEditProfileCard();
        installPasswordCard();

        _profileFrame.setDefaultCard(_viewCard);
    }

    private void installMyProfileCard()
    {
        createViewFields();

        ScCard card;
        card = _profileFrame.addCard();
        card.beDefault();

        ScForm form;
        form = card.addForm();
        form.css().gap();

        ScGroup group;
        group = form.addGroup("My Profile");
        group.css().width400();

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton editButton;
        editButton = header.addButton("Edit", newShowEditCardAction());
        editButton.setImage(MyButtonUrls.edit());

        ScFieldTable fields;
        fields = group.addPad().addFields();

        fields.add(_viewNameField);
        fields.add(_viewEmailField);
        fields.add(_viewRoleField);

        group.addDivider();
        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addButton("Change Password", newShowChangePasswordAction());

        _viewCard = card;
    }

    private void installEditProfileCard()
    {
        createEditFields();

        ScCard card;
        card = _profileFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(newEditSaveAction());
        form.css().gap();

        ScGroup group;
        group = form.addGroup("My Profile");
        group.css().width400();

        ScFieldTable fields;
        fields = group.addPad().addFields();

        fields.add(_editNameField);
        fields.add(_editEmailField);
        fields.add(_editRoleField);

        group.addDivider();
        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(newCancelEditAction());
        footer.addSubmitButton("Save");

        _editCard = card;
    }

    private void installPasswordCard()
    {
        createPwViewFields();
        createPasswordFields();

        ScCard card;
        card = _profileFrame.addCard();

        ScForm form;
        form = card.addForm();
        form.setDefaultAction(newSavePasswordAction());
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Change My Password");
        group.css().width400();

        ScFieldTable fields;
        fields = group.addPad().addFields();

        fields.add(_pwViewNameField);
        fields.add(_pwViewEmailField);
        fields.add(_pwViewRoleField);

        fields.addDivider(5);

        fields.add(_oldPasswordField);
        fields.add(_newPasswordField);
        fields.add(_retypePasswordField);

        group.addDivider();
        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(newCancelChangePasswordAction());
        footer.addSubmitButton("Save");

        _passwordCard = card;
    }

    private void createViewFields()
    {
        _viewNameField = new ScTextField();
        _viewNameField.setLabel("Name");
        _viewNameField.css().padLeft5();
        _viewNameField.setReadOnly();

        _viewEmailField = new ScTextField();
        _viewEmailField.setLabel("Email");
        _viewEmailField.css().padLeft5();
        _viewEmailField.setReadOnly();

        _viewRoleField = new ScTextField();
        _viewRoleField.setLabel("Role");
        _viewRoleField.css().padLeft5();
        _viewRoleField.setReadOnly();
    }

    private void createEditFields()
    {
        _editNameField = new ScTextField();
        _editNameField.setLabel("Name");
        _editNameField.css().padLeft5();

        _editEmailField = new ScTextField();
        _editEmailField.setLabel("Email");
        _editEmailField.css().padLeft5();
        _editEmailField.setReadOnly();

        _editRoleField = new ScTextField();
        _editRoleField.setLabel("Role");
        _editRoleField.css().padLeft5();
        _editRoleField.setReadOnly();
    }

    private void createPwViewFields()
    {
        _pwViewNameField = new ScTextField();
        _pwViewNameField.setLabel("Name");
        _pwViewNameField.css().padLeft5();
        _pwViewNameField.setWidthFull();
        _pwViewNameField.setReadOnly();

        _pwViewEmailField = new ScTextField();
        _pwViewEmailField.setLabel("Email");
        _pwViewEmailField.css().padLeft5();
        _pwViewEmailField.setWidthFull();
        _pwViewEmailField.setReadOnly();

        _pwViewRoleField = new ScTextField();
        _pwViewRoleField.setLabel("Role");
        _pwViewRoleField.css().padLeft5();
        _pwViewRoleField.setWidthFull();
        _pwViewRoleField.setReadOnly();
    }

    private void createPasswordFields()
    {
        _oldPasswordField = new ScPasswordField();
        _oldPasswordField.setLabel("Old Password");
        _oldPasswordField.setWidthFull();
        _oldPasswordField.css().padLeft5();

        _newPasswordField = new ScPasswordField();
        _newPasswordField.setLabel("New Password");
        _newPasswordField.setWidthFull();
        _newPasswordField.css().padLeft5();

        _retypePasswordField = new ScPasswordField();
        _retypePasswordField.setLabel("Retype Password");
        _retypePasswordField.setWidthFull();
        _retypePasswordField.css().padLeft5();
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        super.start();
        refreshFields();
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newShowEditCardAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleShowEditCard();
            }
        };
    }

    private ScActionIF newCancelEditAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleCancelEdit();
            }
        };
    }

    private ScActionIF newEditSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditSave();
            }
        };
    }

    private ScActionIF newShowChangePasswordAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                showPasswordCard();
            }
        };
    }

    private ScActionIF newCancelChangePasswordAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                closePasswordCard();
            }
        };
    }

    private ScActionIF newSavePasswordAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handlePasswordSave();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void refreshFields()
    {
        MyUser currentUser = getCurrentUser();
        String name = currentUser.getName();
        String email = currentUser.getEmail();
        String roleName = currentUser.getRoleName();

        _viewNameField.setValue(name);
        _viewNameField.ajax().replace();

        _viewEmailField.setValue(email);
        _viewEmailField.ajax().replace();

        _viewRoleField.setValue(roleName);
        _viewRoleField.ajax().replace();

        _pwViewNameField.setValue(name);
        _pwViewNameField.ajax().replace();

        _pwViewEmailField.setValue(email);
        _pwViewEmailField.ajax().replace();

        _pwViewRoleField.setValue(roleName);
        _pwViewRoleField.ajax().replace();

        handleRefreshEditFields();
    }

    private void handleRefreshEditFields()
    {
        MyUser currentUser = getCurrentUser();

        _editNameField.setValue(currentUser.getName());
        _editNameField.ajax().replace();

        _editEmailField.setValue(currentUser.getEmail());
        _editEmailField.ajax().replace();

        _editRoleField.setValue(currentUser.getRoleName());
        _editRoleField.ajax().replace();
    }

    private void handleCancelEdit()
    {
        showViewCard();
    }

    private void showViewCard()
    {
        refreshFields();
        _profileFrame.print(_viewCard);
    }

    private void handleShowEditCard()
    {
        refreshFields();
        _profileFrame.print(_editCard);
    }

    private void handleEditSave()
    {
        _editCard.validate();

        MyUser user;
        user = getCurrentUser();
        user.setName(_editNameField.getValue());
        user.saveDao();

        closePasswordCard();
        ajax().toast(_editNameField.getValue() + " set.");
        showViewCard();
    }

    private void showPasswordCard()
    {
        refreshFields();
        _profileFrame.print(_passwordCard);
    }

    private void closePasswordCard()
    {
        refreshFields();
        _profileFrame.printDefault();
    }

    private void handlePasswordSave()
    {
        ajax().hideAllErrors();

        String oldPassword = _oldPasswordField.getValue();
        String newPassword = _newPasswordField.getValue();
        String retypePassword = _retypePasswordField.getValue();

        if ( !getCurrentUser().hasPassword(oldPassword) )
        {
            _oldPasswordField.ajax().focus();
            _oldPasswordField.error("Invalid.");
        }

        if ( newPassword == null )
        {
            _newPasswordField.ajax().focus();
            _newPasswordField.error("Password field empty.");
        }

        if ( retypePassword == null )
        {
            _retypePasswordField.ajax().focus();
            _retypePasswordField.error("Password field empty.");
        }

        if ( Kmu.isNotEqual(newPassword, retypePassword) )
        {
            _retypePasswordField.ajax().clearValue();
            _retypePasswordField.ajax().focus();
            _retypePasswordField.error("Passwords did not match.");
        }

        getCurrentUser().setPassword(newPassword);
        ajax().toast("New password set");
        closePasswordCard();
    }
}
