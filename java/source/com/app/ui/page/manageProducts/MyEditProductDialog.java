package com.app.ui.page.manageProducts;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyCategory;
import com.app.model.MyProduct;
import com.app.model.meta.MyMetaProduct;
import com.app.ui.control.MyEditDialog;

public class MyEditProductDialog
    extends MyEditDialog<MyProduct>
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
        MyMetaProduct x = MyProduct.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

        _uidField = body.addHiddenField(x.Uid);

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addField(x.Name);
        fields.add(newCategoryDropdown());
    }

    private ScControl newCategoryDropdown()
    {
        MyMetaProduct x = MyProduct.Meta;

        ScDomainDropdownField<MyCategory,String> e;
        e = MyCategory.Tools.newDomainDropdownForCurrentProject();
        e.setValueAdaptor(x.Category);
        return e;
    }

    //##################################################
    //# prepare
    //##################################################

    @Override
    protected void prepare(MyProduct e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyProduct save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyProduct e;
        e = getAccess().findProductUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
