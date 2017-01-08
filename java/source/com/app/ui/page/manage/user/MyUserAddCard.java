package com.app.ui.page.manage.user;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyUserCriteria;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.base.MyUserRole;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.manage.crud.MyCrudAddCard;
import com.app.ui.page.manage.crud.MyCrudLayout;
import com.app.utility.MyGlobals;

public class MyUserAddCard
    extends MyCrudAddCard<MyTenant,MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField         _firstNameField;
    private ScTextField         _lastNameField;
    private ScTextField         _nicknameField;
    private ScTextField         _emailField;

    //##################################################
    //# variables
    //##################################################

    private ScEnumDropdownField _roleField;

    //##################################################
    //# constructor
    //##################################################

    public MyUserAddCard()
    {
        super(new MyUserBuilder());
    }

    public MyUserAddCard(MyUserBuilder e)
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
        fields.addFieldFull(x.Phone);
    }

    private void installRoleOn(ScDiv root)
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldset set;
        set = root.addFieldset("Role");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createRoleField());
        fields.addField(x.Active).setValue(true);
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

    private ScEnumDropdownField createRoleField()
    {
        MyMetaUser x = MyUser.Meta;

        ScEnumDropdownField e;
        e = x.RoleCode.newDropdown();
        e.setNullSelectPrefix();
        _roleField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyTenant parent)
    {
        super.preRenderDetails(parent);

        _roleField.setEnumOptions(getAllowedRoles());
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
    //# save
    //##################################################

    @Override
    protected MyUser saveNewChildOn(MyTenant tenant)
    {
        checkDuplicateEmail();
        checkRole();

        MyUser e;
        e = tenant.addUser();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

    private void checkRole()
    {
        String roleCode = _roleField.getValue();
        MyUserRole role = MyUserRole.findCode(roleCode);

        if ( !getAllowedRoles().contains(role) )
            _roleField.error("Invalid");
    }

    private void checkDuplicateEmail()
    {
        MyTenant tenant = getDomainParent();
        String email = _emailField.getValue();

        MyUserCriteria c;
        c = getAccess().getUserDao().createCriteria();
        c.whereTenantIs(tenant);
        c.whereEmail().is(email);

        if ( c.exists() )
            _emailField.error("Duplicate");
    }

    public boolean allowsAddDeveloper()
    {
        return getCurrentUser().isRoleDeveloper();
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getCurrentUser()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        return ss == null
            ? null
            : ss.getUser();
    }

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

}
