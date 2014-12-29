package com.app.ui.page.manageVendors;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.control.MyEditDialog;

public class MyEditVendorDialog
    extends MyEditDialog<MyVendor>
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

        setLabel("EDIT Vendor");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaVendor x = MyVendor.Meta;

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
    protected void prepare(MyVendor e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyVendor save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyVendor e;
        e = getAccess().findVendorUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
