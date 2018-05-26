package com.app.ui.page.crud.member;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyMemberCriteria;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaMember;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyMemberSearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyMember,MyMemberCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSearchView(MyCrudBuilder<MyProject,MyMember> e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScDropdownField<String> _roleField;

    private ScTextField _userNameField;

    //##################################################
    //# basic filter
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createSiteNameField());
        fields.add(createRoleDropdown());
    }

    private ScTextField createSiteNameField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Name");
        e.setHelp(MyUser.Meta.FirstName);
        e.disableChangeTracking();
        _userNameField = e;
        return e;
    }

    private ScDropdownField<String> createRoleDropdown()
    {
        MyMetaMember x = MyMember.Meta;

        ScDropdownField<String> e;
        e = MyMember.Tools.newRoleDropdown();
        e.setValueAdaptor(x.RoleCode);
        e.setNullSelectPrefix();
        e.disableChangeTracking();
        _roleField = e;
        return e;
    }

    //##################################################
    //# extended filter
    //##################################################

    @Override
    protected void installExtendedFieldsOn(ScDiv root)
    {
        // none
    }

    //==================================================
    //= extended message
    //==================================================

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        // none
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyMemberCriteria createCriteria()
    {
        return getAccess().getMemberDao().createCriteria();
    }

    @Override
    protected void filter(MyMemberCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);

        if ( _userNameField.hasValue() )
            c.joinToUser().whereFullName().hasSubstring(_userNameField.getValue());

        if ( _roleField.hasValue() )
            c.whereRoleCode().is(_roleField.getValue());
    }

    @Override
    protected void sort(MyMemberCriteria c)
    {
        c.joinToUser().sortOnFirstName();
        c.sortOnUid();
    }
}
