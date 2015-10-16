package com.app.ui.page.manageProducts;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyMasterProduct;
import com.app.model.meta.MyMetaMasterProduct;
import com.app.ui.control.MyEditDialog;

public class MyEditProductDialog
    extends MyEditDialog<MyMasterProduct>
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

        setLabel("EDIT Product");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaMasterProduct x = MyMasterProduct.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        _uidField = body.addHiddenField(x.Uid);

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addField(x.PartNumber);
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare(MyMasterProduct e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyMasterProduct save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyMasterProduct e;
        e = getAccess().findMasterProductUid(uid);
        e.applyFrom(this);
        return e;
    }
}
