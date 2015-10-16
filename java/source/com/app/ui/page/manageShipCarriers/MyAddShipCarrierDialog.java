package com.app.ui.page.manageShipCarriers;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyShipCarrier;
import com.app.model.meta.MyMetaShipCarrier;
import com.app.ui.control.MyAddDialog;

public class MyAddShipCarrierDialog
    extends MyAddDialog<MyShipCarrier>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Ship Carrier");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaShipCarrier x = MyShipCarrier.Meta;

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
    protected MyShipCarrier save()
    {
        validate();

        MyShipCarrier e;
        e = getCurrentProject().addShipCarrier();
        e.applyFrom(this);
        return e;
    }
}
