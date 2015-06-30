package com.app.ui.page.manageMembers;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyMember;
import com.app.model.MyMemberRole;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.ui.control.MyAddDialog;
import com.app.utility.MyButtonUrls;

public class MyAddMemberDialog
    extends MyAddDialog<MyMember>
{
    //##################################################
    //# variables
    //##################################################

    private ScCardFrame _frame;

    private ScAction    _checkEmailAction;
    private ScCard      _checkEmailCard;
    private ScTextField _checkEmailField;

    private ScCard      _joinUserCard;
    private ScAction    _joinUserAction;
    private ScTextField _joinEmailField;
    private ScTextField _joinNameField;
    private ScDropdown  _joinRoleField;

    private ScCard      _createUserCard;
    private ScAction    _createUserAction;
    private ScTextField _createEmailField;
    private ScTextField _createNameField;
    private ScDropdown  _createRoleField;

    //##################################################
    //# setup
    //##################################################

    @Override
    public void install()
    {
        super.install();

        setLabel("ADD Member");

        ScDiv body;
        body = getBody();
        body.css().gap();

        _frame = body.addFrame();

        installCheckEmailCard();
        installJoinUserCard();
        installCreateUserCard();

        getSaveButton().setDisabled();
        setSubmitAction(_checkEmailAction);
    }

    private void installCheckEmailCard()
    {
        _checkEmailAction = createAction(this::handleCheckEmail);

        _checkEmailCard = _frame.addCard();
        _checkEmailCard.beDefault();

        ScFieldset set;
        set = _checkEmailCard.addFieldset("Check Email");

        ScFieldLayout fields;
        fields = set.addFieldLayout();

        ScDiv row;
        row = fields.addDiv();
        row.setLabel("Email");
        row.css().smallChildMarginRight();

        _checkEmailField = row.addTextField();
        _checkEmailField.setValidator(MyUser.Meta.Email);

        ScSubmitButton button;
        button = row.addSubmitButton("Check");
        button.clearPreImage();
        button.setPostImage(MyButtonUrls.rightDown());
    }

    private void installJoinUserCard()
    {
        _joinUserCard = _frame.addCard();
        _joinUserAction = createAction(this::handleJoinUser);

        ScFieldset set;
        set = _joinUserCard.addFieldset("Join Existing User");

        ScFieldLayout fields;
        fields = set.addFieldLayout();

        ScDiv emailRow;
        emailRow = fields.addDiv();
        emailRow.setLabel("Email");
        emailRow.css().smallChildMarginRight();

        _joinEmailField = emailRow.addTextField();
        _joinEmailField.setReadOnly();

        emailRow.addLink("change", this::handleChangeEmail);

        _joinNameField = fields.addTextField();
        _joinNameField.setLabel("Name");
        _joinNameField.setReadOnly();

        _joinRoleField = fields.add(newRoleDropdown());
    }

    private void installCreateUserCard()
    {
        _createUserCard = _frame.addCard();
        _createUserAction = createAction(this::handleCreateUser);

        ScFieldset set;
        set = _createUserCard.addFieldset("Create New User");

        ScFieldLayout fields;
        fields = set.addFieldLayout();

        ScDiv emailRow;
        emailRow = fields.addDiv();
        emailRow.setLabel("Email");
        emailRow.css().smallChildMarginRight();

        _createEmailField = emailRow.addTextField();
        _createEmailField.setReadOnly();

        emailRow.addLink("change", this::handleChangeEmail);

        _createNameField = fields.addTextField();
        _createNameField.setLabel("Name");
        _createNameField.setValidator(MyUser.Meta.Name);

        _createRoleField = fields.add(newRoleDropdown());
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleCheckEmail()
    {
        _checkEmailField.ajax().focus();
        _checkEmailField.ajax().hideAllErrors();
        _checkEmailField.validate();

        String email = _checkEmailField.getValue();
        boolean isValid = Kmu.isValidEmailAddress(email);

        if ( !isValid )
        {
            _checkEmailField.addError("Invalid email.");
            throw newRollback();
        }

        MyUser user;
        user = getAccess().getUserDao().findEmail(email);

        if ( user == null )
        {
            ajaxShowCreateUserFor(email);
            return;
        }

        if ( getCurrentProject().hasMember(user) )
        {
            _checkEmailField.addError("Already a member.");
            throw newRollback();
        }

        ajaxShowJoinUserCardFor(user);
    }

    private void handleChangeEmail()
    {
        ajaxShowCheckEmailCard();
    }

    @Override
    protected MyMember save()
    {
        validate();

        MyMember e;
        e = getCurrentProject().addMember();
        e.applyFrom(this);
        e.attachDao();

        flushDao();

        return e;
    }

    private void handleCreateUser()
    {
        String email = _createEmailField.getValue();
        String name = _createNameField.getValue();
        String roleCode = _createRoleField.getStringValue();
        MyMemberRole role = MyMemberRole.findCode(roleCode);

        MyUser user = getAccess().getUserDao().findEmail(email);
        if ( user == null )
        {
            user = new MyUser();
            user.setEmail(email);
            user.setName(name);
            user.setRoleOther();
            user.attachDao();
        }

        MyProject project = getCurrentProject();
        MyMember member = project.getMemberFor(user);

        if ( member == null )
        {
            member = project.addMember();
            member.setUser(user);
        }

        member.setRole(role);

        flushDao();
    }

    private void handleJoinUser()
    {
        String email = _joinEmailField.getValue();
        String roleCode = _joinRoleField.getStringValue();
        MyMemberRole role = MyMemberRole.findCode(roleCode);

        MyUser user = getAccess().getUserDao().findEmail(email);
        if ( user == null )
        {
            _joinEmailField.addError("Invalid email.");
            throw newRollback();
        }

        MyProject project = getCurrentProject();
        MyMember member = project.getMemberFor(user);

        if ( member == null )
        {
            member = project.addMember();
            member.setUser(user);
        }

        member.setRole(role);

        flushDao();
    }

    //##################################################
    //# ajax
    //##################################################

    private void ajaxShowCreateUserFor(String email)
    {
        _createEmailField.setValue(email);
        _createUserCard.ajaxPrint();

        ajaxEnableSave(_createUserAction);
    }

    private void ajaxShowJoinUserCardFor(MyUser user)
    {
        _joinEmailField.setValue(user.getEmail());
        _joinNameField.setValue(user.getName());
        _joinUserCard.ajaxPrint();

        ajaxEnableSave(_joinUserAction);
    }

    private void ajaxShowCheckEmailCard()
    {
        _frame.ajaxPrintDefault();

        ajaxDisableSave(_checkEmailAction);
    }

    //##################################################
    //# support
    //##################################################

    private ScDropdown newRoleDropdown()
    {
        ScDropdown e;
        e = MyMember.Tools.newRoleDropdown();
        e.setValueAdaptor(MyMember.Meta.RoleCode);
        e.setValue(MyMemberRole.Worker);
        return e;
    }

}