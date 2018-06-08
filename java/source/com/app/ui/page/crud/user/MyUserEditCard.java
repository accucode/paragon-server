package com.app.ui.page.crud.user;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.model.base.MyUserRole;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;
import com.app.utility.MyGlobals;

public class MyUserEditCard
    extends MyCrudEditCard<MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;

    private ScTextField _emailField;

    private ScDynamicEnumDropdownField _roleField;
    private ScFieldText                _roleText;

    private ScCheckboxField _enabledField;
    private ScFieldText     _enabledText;

    //##################################################
    //# constructor
    //##################################################

    public MyUserEditCard()
    {
        super(new MyUserBuilder());
    }

    public MyUserEditCard(MyUserBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        root.css().columnSpacer20();

        installNameOn(root);
        installContactOn(root);
        installRoleOn(root);
        installMemoOn(root);
    }

    private void installNameOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Name");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createFirstNameField());
        fields.add(createLastNameField());
        fields.add(createNicknameField());
    }

    private void installContactOn(ScDiv root)
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldset set;
        set = root.addFieldset("Contact");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createEmailField());
        fields.addField(x.Phone);
    }

    private void installRoleOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Role");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createRoleText());
        fields.add(createRoleField());
        fields.addSpace();
        fields.add(createEnabledText());
        fields.add(createEnabledField());
    }

    private void installMemoOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Memo");
        set.add(createMemoField());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createFirstNameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.FirstName.newField();
        _firstNameField = e;
        return e;
    }

    private ScControl createLastNameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.LastName.newField();
        _lastNameField = e;
        return e;
    }

    private ScControl createNicknameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.Nickname.newField();
        _nicknameField = e;
        return e;
    }

    private ScControl createEmailField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.Email.newField();
        _emailField = e;
        return e;
    }

    private ScControl createEnabledText()
    {
        ScFieldText e;
        e = MyUser.Meta.Enabled.newFieldText();
        e.hide();
        _enabledText = e;
        return e;
    }

    private ScControl createEnabledField()
    {
        ScCheckboxField e;
        e = MyUser.Meta.Enabled.newField();
        e.hide();
        _enabledField = e;
        return e;
    }

    private ScControl createRoleText()
    {
        ScFieldText e;
        e = MyUser.Meta.RoleName.newFieldText();
        e.hide();
        _roleText = e;
        return e;
    }

    private ScControl createRoleField()
    {
        MyMetaUser x = MyUser.Meta;

        ScDynamicEnumDropdownField e;
        e = x.RoleCode.newDropdown();
        e.setEnumListSupplier(this::getAllowedRoles);
        e.setNullSelectPrefix();
        e.hide();
        _roleField = e;
        return e;
    }

    private ScControl createMemoField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextArea e;
        e = x.Memo.newMultilineField();
        e.layoutBlock();
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyUser user)
    {
        super.preRenderDetails(user);

        preRenderRoleFor(user);
        preRenderEnabledFor(user);
    }

    private void preRenderRoleFor(MyUser editUser)
    {
        KmList<MyUserRole> allowedRoles = getAllowedRoles();
        boolean allowed = !editUser.hasRole() || allowedRoles.contains(editUser.getRole());

        if ( !allowed )
        {
            _roleText.setValue(editUser.getRoleName());
            _roleText.show();
            return;
        }

        _roleField.setValue(editUser.getRole());
        _roleField.show();
        return;
    }

    private void preRenderEnabledFor(MyUser editUser)
    {
        if ( !allowsEditEnabledFor(editUser) )
        {
            String s = getFormatter().formatBoolean(editUser.getEnabled());
            _enabledText.setValue(s);
            _enabledText.show();
            return;
        }

        _enabledField.setValue(editUser.getEnabled());
        _enabledField.show();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateName();
        validateEmail();
    }

    private void validateName()
    {
        if ( _firstNameField.hasErrors() )
            return;

        if ( _lastNameField.hasErrors() )
            return;

        if ( _nicknameField.hasErrors() )
            return;

        String first = _firstNameField.getValue();
        String last = _lastNameField.getValue();
        String nick = _nicknameField.getValue();

        boolean none = Kmu.allNulls(first, last, nick);
        if ( none )
            _firstNameField.addError("You must specify a name (first, last, or nickname).");
    }

    private void validateEmail()
    {
        ScTextField field = _emailField;
        if ( field.hasErrors() )
            return;

        MyUser user = getDomainChild();
        String email = field.getValue();

        boolean dup = getAccess().getUserDao().isDuplicateEmail(user, email);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyUser e)
    {
        applyToModel(e);

        String roleCode = _roleField.getValue();
        MyUserRole role = MyUserRole.findCode(roleCode);
        if ( getAllowedRoles().contains(role) )
            e.setRole(role);

        if ( allowsEditEnabledFor(e) )
            e.setEnabled(_enabledField.getValue());
    }

    //##################################################
    //# support
    //##################################################

    private KmList<MyUserRole> getAllowedRoles()
    {
        MyUserRole role = getCurrentUser().getRole();
        switch ( role )
        {
            case Developer:
                return MyUserRole.getValues();

            case TenantAdmin:
                return KmList.createWith(MyUserRole.TenantAdmin, MyUserRole.ProjectMember);

            case ProjectMember:
                return KmList.createEmpty();
        }
        throw Kmu.newEnumError(role);
    }

    private boolean allowsEditEnabledFor(MyUser editUser)
    {
        MyUserRole role = getCurrentUser().getRole();
        switch ( role )
        {
            case Developer:
                return true;

            case TenantAdmin:
                return !editUser.isRoleDeveloper();

            case ProjectMember:
                return false;
        }
        throw Kmu.newEnumError(role);
    }

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }

}
