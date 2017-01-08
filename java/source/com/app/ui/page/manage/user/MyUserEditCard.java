package com.app.ui.page.manage.user;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyUserCriteria;
import com.app.model.MyUser;
import com.app.model.base.MyUserRole;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.manage.crud.MyCrudEditCard;
import com.app.ui.page.manage.crud.MyCrudLayout;

public class MyUserEditCard
    extends MyCrudEditCard<MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField         _firstNameField;
    private ScTextField         _lastNameField;
    private ScTextField         _nicknameField;

    private ScTextField         _emailField;

    private ScEnumDropdownField _roleField;
    private ScFieldText         _roleText;

    private ScCheckboxField     _activeField;
    private ScFieldText         _activeText;

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
        fields.add(createActiveText());
        fields.add(createActiveField());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScTextField createFirstNameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.FirstName.newField();
        e.setWidthFull();
        _firstNameField = e;
        return e;
    }

    private ScTextField createLastNameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.LastName.newField();
        e.setWidthFull();
        _lastNameField = e;
        return e;
    }

    private ScTextField createNicknameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.Nickname.newField();
        e.setWidthFull();
        _nicknameField = e;
        return e;
    }

    private ScTextField createEmailField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.Email.newField();
        e.setWidthFull();
        _emailField = e;
        return e;
    }

    private ScFieldText createActiveText()
    {
        ScFieldText e;
        e = MyUser.Meta.Active.newFieldText();
        e.hide();
        _activeText = e;
        return e;
    }

    private ScCheckboxField createActiveField()
    {
        ScCheckboxField e;
        e = MyUser.Meta.Active.newField();
        e.hide();
        _activeField = e;
        return e;
    }

    private ScFieldText createRoleText()
    {
        ScFieldText e;
        e = MyUser.Meta.RoleName.newFieldText();
        e.hide();
        _roleText = e;
        return e;
    }

    private ScEnumDropdownField createRoleField()
    {
        ScEnumDropdownField e;
        e = MyUser.Meta.RoleCode.newDropdown();
        e.setNullSelectPrefix();
        e.hide();
        _roleField = e;
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
        preRenderActiveFor(user);
    }

    private void preRenderRoleFor(MyUser user)
    {
        KmList<MyUserRole> allowedRoles = getAllowedRoles();
        boolean allowed = allowedRoles.contains(user.getRole());

        if ( !allowed )
        {
            _roleText.setValue(user.getRoleName());
            _roleText.show();
            return;
        }

        _roleField.clearOptions();
        _roleField.setEnumOptions(allowedRoles);
        _roleField.setValue(user.getRole());
        _roleField.show();
        return;
    }

    private void preRenderActiveFor(MyUser user)
    {
        if ( !allowsEditActiveFor(user) )
        {
            String s = getFormatter().formatBoolean(user.getActive());
            _activeText.setValue(s);
            _activeText.show();
            return;
        }

        _activeField.setValue(user.getActive());
        _activeField.show();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected void validateDetails()
    {
        validateQuietly();

        String first = _firstNameField.getValue();
        String last = _lastNameField.getValue();
        String nick = _nicknameField.getValue();

        if ( Kmu.allNulls(first, last, nick) )
            _firstNameField.addError(
                "You must specify at least one of First Name, Last Name, or Nickname");
    }

    //##################################################
    //# update
    //##################################################

    @Override
    protected void updateDomainChild(MyUser e)
    {
        checkDuplicateEmail(e);

        applyToModel(e);

        String roleCode = _roleField.getValue();
        MyUserRole role = MyUserRole.findCode(roleCode);
        if ( getAllowedRoles().contains(role) )
            e.setRole(role);

        if ( allowsEditActiveFor(e) )
            e.setActive(_activeField.getValue());
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

            case Admin:
                return KmList.createWith(MyUserRole.Admin, MyUserRole.Other);

            case Other:
                return new KmList<>();
        }
        return new KmList<>();
    }

    private boolean allowsEditActiveFor(MyUser editUser)
    {
        MyUser currentUser = getCurrentUser();

        switch ( currentUser.getRole() )
        {
            case Developer:
                return true;

            case Admin:
                return !editUser.isRoleDeveloper();

            case Other:
                return false;
        }
        return false;
    }

    private MyUser getCurrentUser()
    {
        return getGlobals().getCurrentUser();
    }

    private void checkDuplicateEmail(MyUser user)
    {
        String email = _emailField.getValue();

        MyUserCriteria c;
        c = getAccess().getUserDao().createCriteria();
        c.whereTenantIs(user.getTenant());
        c.whereUid().isNot(user.getUid());
        c.whereEmail().is(email);

        if ( c.exists() )
            _emailField.error("User with that email already exists.");
    }
}
