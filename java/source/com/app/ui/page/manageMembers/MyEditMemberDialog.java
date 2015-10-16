package com.app.ui.page.manageMembers;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDraggableMultiSelectList;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyMember;
import com.app.model.MySkill;
import com.app.model.meta.MyMetaMember;
import com.app.ui.control.MyEditDialog;

public class MyEditMemberDialog
    extends MyEditDialog<MyMember>
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String>               _uidField;
    private ScDraggableMultiSelectList<MySkill> _skillList;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("EDIT Member");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaMember x = MyMember.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        _uidField = body.addHiddenField(x.Uid);

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText(x.UserName);
        fields.addText(x.UserEmail);
        fields.add(x.RoleCode.newDropdown());
        fields.add(newSkillList());
    }

    private ScControl newSkillList()
    {
        ScDraggableMultiSelectList<MySkill> e;
        e = new ScDraggableMultiSelectList<>();
        e.layoutHeight(250);
        e.setLabel("Skills");
        e.setHelp("The member's skills determine which tasks they will be assigned.");
        e.setKeyAdapter(MySkill.Meta.Uid);
        e.setTitleAdapter(MySkill.Meta.Name);

        _skillList = e;
        return e;
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare(MyMember e)
    {
        applyFromModel(e);
        prepareSkills(e);
    }

    private void prepareSkills(MyMember e)
    {
        KmList<MySkill> sel;
        sel = e.getSkills();

        KmList<MySkill> avail;
        avail = getCurrentProject().getSkillsByName();
        avail.removeAll(sel);

        _skillList.setSelectedValues(sel);
        _skillList.setAvailableValues(avail);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyMember save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyMember e;
        e = getAccess().findMemberUid(uid);
        e.applyFrom(this);
        applySkillsTo(e);
        return e;
    }

    private void applySkillsTo(MyMember member)
    {
        KmList<String> uids;
        uids = _skillList.getSelectedKeys();

        KmList<MySkill> skills;
        skills = getCurrentProject().findSkillUids(uids);
        skills.removeNulls();

        member.setSkills(skills);
    }

}
