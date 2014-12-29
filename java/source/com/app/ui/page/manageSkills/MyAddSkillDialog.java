package com.app.ui.page.manageSkills;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MySkill;
import com.app.model.meta.MyMetaSkill;
import com.app.ui.control.MyAddDialog;

public class MyAddSkillDialog
    extends MyAddDialog<MySkill>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Skill");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaSkill x = MySkill.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addField(x.Name);
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
    //# save
    //##################################################

    @Override
    protected MySkill save()
    {
        validate();

        MySkill e;
        e = getCurrentProject().addSkill();
        e.applyFrom(this);

        flushDao();

        return e;
    }
}
