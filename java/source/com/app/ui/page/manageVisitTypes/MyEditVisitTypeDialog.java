package com.app.ui.page.manageVisitTypes;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyVisitType;
import com.app.model.meta.MyMetaVisitType;
import com.app.ui.control.MyEditDialog;

public class MyEditVisitTypeDialog
    extends MyEditDialog<MyVisitType>
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

        setLabel("EDIT Visit Type");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaVisitType x = MyVisitType.Meta;

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
    protected void prepare(MyVisitType e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyVisitType save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyVisitType e;
        e = getAccess().findVisitTypeUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
