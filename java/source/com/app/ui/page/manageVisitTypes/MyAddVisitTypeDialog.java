package com.app.ui.page.manageVisitTypes;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyVisitType;
import com.app.model.meta.MyMetaVisitType;
import com.app.ui.control.MyAddDialog;

public class MyAddVisitTypeDialog
    extends MyAddDialog<MyVisitType>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Visit Type");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaVisitType x = MyVisitType.Meta;

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
    protected MyVisitType save()
    {
        validate();

        MyVisitType e;
        e = getCurrentProject().addVisitType();
        e.applyFrom(this);

        flushDao();

        return e;
    }
}
