package com.app.ui.page.managePowerTypes;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyPowerType;
import com.app.model.meta.MyMetaPowerType;
import com.app.ui.control.MyEditDialog;

public class MyEditPowerTypeDialog
    extends MyEditDialog<MyPowerType>
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

        setLabel("EDIT Power Type");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaPowerType x = MyPowerType.Meta;

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
    protected void prepare(MyPowerType e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyPowerType save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyPowerType e;
        e = getAccess().findPowerTypeUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
