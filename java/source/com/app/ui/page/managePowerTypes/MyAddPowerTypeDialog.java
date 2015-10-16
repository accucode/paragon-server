package com.app.ui.page.managePowerTypes;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyPowerType;
import com.app.model.meta.MyMetaPowerType;
import com.app.ui.control.MyAddDialog;

public class MyAddPowerTypeDialog
    extends MyAddDialog<MyPowerType>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Power Type");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaPowerType x = MyPowerType.Meta;

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
    protected MyPowerType save()
    {
        validate();

        MyPowerType e;
        e = getCurrentProject().addPowerType();
        e.applyFrom(this);
        return e;
    }
}
