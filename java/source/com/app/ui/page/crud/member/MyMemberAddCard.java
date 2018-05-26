package com.app.ui.page.crud.member;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaMember;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.selector.MyUserSelector;
import com.app.utility.MyGlobals;

public class MyMemberAddCard
    extends MyCrudAddCard<MyProject,MyMember>
{
    //##################################################
    //# variables
    //##################################################

    private MyUserSelector _userField;

    private ScFieldTable _newUserFields;
    private ScTextField  _firstNameField;
    private ScTextField  _lastNameField;
    private ScTextField  _nicknameField;

    private ScFieldTable _roleFields;

    //##################################################
    //# constructor
    //##################################################

    public MyMemberAddCard()
    {
        super(new MyMemberBuilder());
    }

    public MyMemberAddCard(MyMemberBuilder e)
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
        e.add(createUserSection());
        e.add(createRoleSection());
        return e;
    }

    //==================================================
    //= install :: user
    //==================================================

    private ScControl createUserSection()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("User");
        e.addFieldTable().add(createUserDropdown());
        e.addBreak();
        e.add(createNewUserFields());
        return e;
    }

    private ScControl createUserDropdown()
    {
        MyMetaMember x = MyMember.Meta;

        MyUserSelector e;
        e = new MyUserSelector();
        e.setChildrenFunction(this::findUsers);
        e.setValueAdaptor(x.User);
        e.onChange(newUncheckedAction(this::handleUserChanged));
        e.setNullPrefix(Kmu.formatMetaValue("new user"));
        _userField = e;
        return e;
    }

    private KmList<MyUser> findUsers(MyTenant tenant, boolean showAll)
    {
        MyProject project = getDomainParent();

        if ( !project.hasTenant(tenant) )
            throw Kmu.newFatal("Tenant mismatch");

        KmList<MyUser> all = tenant.getUsersByFullName();
        KmCollection<MyUser> existing = project.getMembers().collect(e -> e.getUser());

        KmList<MyUser> rem = all.without(existing);
        return showAll
            ? rem
            : rem.select(e -> e.isDomainEnabled());
    }

    private ScControl createNewUserFields()
    {
        MyMetaUser x = MyUser.Meta;

        _firstNameField = x.FirstName.newField();
        _lastNameField = x.LastName.newField();
        _nicknameField = x.Nickname.newField();

        ScFieldTable e;
        e = new ScFieldTable();
        e.add(_firstNameField);
        e.add(_lastNameField);
        e.add(_nicknameField);
        e.addSpace();
        e.addField(x.Email);
        e.addField(x.Phone);
        _newUserFields = e;
        return e;
    }

    //==================================================
    //= install :: role
    //==================================================

    private ScControl createRoleSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Role");
        e.add(createRoleField());
        _roleFields = e;
        return e;
    }

    private ScControl createRoleField()
    {
        MyMetaMember x = MyMember.Meta;

        ScDropdownField<String> e;
        e = MyMember.Tools.newRoleDropdown();
        e.setValueAdaptor(x.RoleCode);
        e.setNullSelectPrefix();
        e.setRequired();
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyProject project)
    {
        super.preRenderDetails(project);

        _userField.setTenant(project.getTenant());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleUserChanged()
    {
        boolean show = !_userField.hasValue();
        _newUserFields.ajaxShow(show);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyMember saveNewChildOn(MyProject project)
    {
        MyUser user = lazyGetSelectedUser(project);

        MyMember e;
        e = project.addMember();
        e.setUser(user);
        e.applyFrom(_roleFields);
        e.daoAttach();
        return e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        // Do NOT validate everything at once.
        // The <new user> section should only be validated when visible.
        // super.validate();

        validateUser();
        validateRole();
    }

    private void validateUser()
    {
        if ( _userField.hasValue() )
            return;

        _newUserFields.validate();

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
            _firstNameField.addError(
                "You must specify at least one of First Name, Last Name, or Nickname");
    }

    private void validateRole()
    {
        _roleFields.validate();
    }

    //##################################################
    //# support
    //##################################################

    private MyUser lazyGetSelectedUser(MyProject project)
    {
        MyUser user = _userField.hasValue()
            ? _userField.getValue()
            : createUser();

        if ( user == null )
            _userField.addErrorAndCheck("Required.");

        if ( project.hasMember(user) )
            _userField.addErrorAndCheck("Already a member.");

        return user;
    }

    private MyUser createUser()
    {
        validateUser();
        checkErrors();

        MyUser e;
        e = MyGlobals.getCurrentTenant().addUser();
        e.applyFrom(_newUserFields);
        e.setRoleProjectMember();
        e.daoAttach();
        return e;
    }

}
