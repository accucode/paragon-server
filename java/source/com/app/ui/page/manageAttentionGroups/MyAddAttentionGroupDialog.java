package com.app.ui.page.manageAttentionGroups;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyAttentionGroup;
import com.app.model.meta.MyMetaAttentionGroup;
import com.app.ui.control.MyAddDialog;

public class MyAddAttentionGroupDialog
    extends MyAddDialog<MyAttentionGroup>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Attention Group");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaAttentionGroup x = MyAttentionGroup.Meta;

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
    protected MyAttentionGroup save()
    {
        validate();

        MyAttentionGroup e;
        e = getCurrentProject().addAttentionGroup();
        e.applyFrom(this);
        return e;
    }
}
