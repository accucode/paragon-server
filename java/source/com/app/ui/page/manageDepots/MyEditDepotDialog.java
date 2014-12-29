package com.app.ui.page.manageDepots;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyDepot;
import com.app.model.meta.MyMetaDepot;
import com.app.ui.control.MyEditDialog;

public class MyEditDepotDialog
    extends MyEditDialog<MyDepot>
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

        setLabel("EDIT Depot");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaDepot x = MyDepot.Meta;

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
    protected void prepare(MyDepot e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyDepot save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyDepot e;
        e = getAccess().findDepotUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
