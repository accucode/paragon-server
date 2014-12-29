package com.app.ui.page.manageSkills;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MySkill;
import com.app.model.meta.MyMetaSkill;
import com.app.ui.control.MyEditDialog;

public class MyEditSkillDialog
    extends MyEditDialog<MySkill>
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _uidField;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("EDIT Skill");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaSkill x = MySkill.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        _uidField = body.addHiddenField(x.Uid);

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addField(x.Name);
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare(MySkill e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MySkill save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MySkill e;
        e = getAccess().findSkillUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
