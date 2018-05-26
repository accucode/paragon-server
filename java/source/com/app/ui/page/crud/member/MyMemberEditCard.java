package com.app.ui.page.crud.member;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScDropdownField;

import com.app.model.MyMember;
import com.app.model.meta.MyMetaMember;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyMemberEditCard
    extends MyCrudEditCard<MyMember>
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberEditCard()
    {
        super(new MyMemberBuilder());
    }

    public MyMemberEditCard(MyMemberBuilder e)
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

        installUserOn(root);
        installRoleOn(root);
    }

    private void installUserOn(ScDiv root)
    {
        MyMetaMember x = MyMember.Meta;

        ScFieldset set;
        set = root.addFieldset("User");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.UserFullName);
        fields.addFieldText(x.UserEmail);
        fields.addField(x.Enabled);
    }

    private void installRoleOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("Role");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createRoleRow());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createRoleRow()
    {
        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().rowSpacer5();
        row.setLabel("Role");
        row.add(createRoleDropdown());
        return row;
    }

    private ScControl createRoleDropdown()
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
    protected void preRenderDetails(MyMember child)
    {
        super.preRenderDetails(child);
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyMember e)
    {
        e.applyFrom(this);
    }
}
