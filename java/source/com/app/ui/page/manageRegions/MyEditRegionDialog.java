package com.app.ui.page.manageRegions;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyRegion;
import com.app.model.meta.MyMetaRegion;
import com.app.ui.control.MyEditDialog;

public class MyEditRegionDialog
    extends MyEditDialog<MyRegion>
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

        setLabel("EDIT Region");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaRegion x = MyRegion.Meta;

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
    protected void prepare(MyRegion e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyRegion save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyRegion e;
        e = getAccess().findRegionUid(uid);
        e.applyFrom(this);
        return e;
    }
}
