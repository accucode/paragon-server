package com.app.ui.page.manageRegions;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyRegion;
import com.app.model.meta.MyMetaRegion;
import com.app.ui.control.MyAddDialog;

public class MyAddRegionDialog
    extends MyAddDialog<MyRegion>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Region");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaRegion x = MyRegion.Meta;

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
    protected MyRegion save()
    {
        validate();

        MyRegion e;
        e = getCurrentProject().addRegion();
        e.applyFrom(this);
        return e;
    }
}
