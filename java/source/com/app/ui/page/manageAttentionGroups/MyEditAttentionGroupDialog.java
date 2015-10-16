package com.app.ui.page.manageAttentionGroups;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyAttentionGroup;
import com.app.model.meta.MyMetaAttentionGroup;
import com.app.ui.control.MyEditDialog;

public class MyEditAttentionGroupDialog
    extends MyEditDialog<MyAttentionGroup>
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

        setLabel("EDIT Attention Group");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaAttentionGroup x = MyAttentionGroup.Meta;

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
    protected void prepare(MyAttentionGroup e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyAttentionGroup save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyAttentionGroup e;
        e = getAccess().findAttentionGroupUid(uid);
        e.applyFrom(this);
        return e;
    }
}
