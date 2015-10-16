package com.app.ui.page.manageProducts;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyMasterProduct;
import com.app.model.meta.MyMetaMasterProduct;
import com.app.ui.control.MyAddDialog;

public class MyAddProductDialog
    extends MyAddDialog<MyMasterProduct>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Product");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaMasterProduct x = MyMasterProduct.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addField(x.PartNumber);
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
    protected MyMasterProduct save()
    {
        validate();

        MyMasterProduct e;
        e = getCurrentProject().addMasterProduct();
        e.applyFrom(this);
        return e;
    }
}
