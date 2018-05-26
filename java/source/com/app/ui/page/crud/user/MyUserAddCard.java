package com.app.ui.page.crud.user;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.base.MyUserRole;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.utility.MyGlobals;

public class MyUserAddCard
    extends MyCrudAddCard<MyTenant,MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;
    private ScTextField _emailField;

    //##################################################
    //# variables
    //##################################################

    private ScDynamicEnumDropdownField _roleField;

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
    protected void installBody(ScDiv body)
    {
        body.add(createLayout());
    }

    private ScControl createLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createNameSection());
        e.add(createContactSection());
        e.add(createRoleSection());
        e.add(createMemoSection());
        return e;
    }

    //==================================================
    //= install :: name
    //==================================================

    private ScControl createNameSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Name");
        e.add(createFirstNameField());
        e.add(createLastNameField());
        e.add(createNicknameField());
        return e;
    }

    private ScTextField createFirstNameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.FirstName.newField();
        _firstNameField = e;
        return e;
    }

    private ScTextField createLastNameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.LastName.newField();
        _lastNameField = e;
        return e;
    }

    private ScTextField createNicknameField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.Nickname.newField();
        _nicknameField = e;
        return e;
    }

    //==================================================
    //= install :: contact
    //==================================================

    private ScControl createContactSection()
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Contact");
        e.add(createEmailField());
        e.addField(x.Phone);
        return e;
    }

    private ScTextField createEmailField()
    {
        MyMetaUser x = MyUser.Meta;

        ScTextField e;
        e = x.Email.newField();
        _emailField = e;
        return e;
    }

    //==================================================
    //= install :: role
    //==================================================

    private ScControl createRoleSection()
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Role");
        e.add(createRoleField());
        e.addField(x.Enabled).setValue(true);
        return e;
    }

    private ScControl createRoleField()
    {
        MyMetaUser x = MyUser.Meta;

        ScDynamicEnumDropdownField e;
        e = x.RoleCode.newDropdown();
        e.setNullSelectPrefix();
        e.setEnumListSupplier(this::getAllowedRoles);
        _roleField = e;
        return e;
    }

    //==================================================
    //= install :: memo
    //==================================================

    private ScControl createMemoSection()
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
    protected void preRenderDetails(MyTenant parent)
    {
        super.preRenderDetails(parent);
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
        validateRole();
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

        MyTenant tenant = getDomainParent();
        String email = field.getValue();

        boolean dup = getAccess().getUserDao().isDuplicateEmail(tenant, email);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateRole()
    {
        ScDynamicEnumDropdownField field = _roleField;
        if ( field.hasErrors() )
            return;

        String roleCode = field.getValue();
        MyUserRole role = MyUserRole.findCode(roleCode);

        boolean allowed = getAllowedRoles().contains(role);
        if ( !allowed )
            field.addError("Invalid");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyUser saveNewChildOn(MyTenant tenant)
    {
        MyUser e;
        e = tenant.addUser();
        e.applyFrom(this);
        e.daoAttach();
        return e;
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

            case TenantAdmin:
                return KmList.createWith(MyUserRole.TenantAdmin, MyUserRole.ProjectMember);

            case ProjectMember:
                return new KmList<>();
        }
        return new KmList<>();
    }

}
