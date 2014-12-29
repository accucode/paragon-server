package com.app.ui.page.manageDepots;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyDepot;
import com.app.model.meta.MyMetaDepot;
import com.app.ui.control.MyAddDialog;

public class MyAddDepotDialog
    extends MyAddDialog<MyDepot>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Depot");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaDepot x = MyDepot.Meta;

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
    protected MyDepot save()
    {
        validate();

        MyDepot e;
        e = getCurrentProject().addDepot();
        e.applyFrom(this);

        flushDao();

        return e;
    }
}
