package com.app.ui.page.manageVendors;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.control.MyAddDialog;

public class MyAddVendorDialog
    extends MyAddDialog<MyVendor>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Vendor");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaVendor x = MyVendor.Meta;

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
    protected MyVendor save()
    {
        validate();

        MyVendor e;
        e = getCurrentProject().addVendor();
        e.applyFrom(this);

        flushDao();

        return e;
    }
}
