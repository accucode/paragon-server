package com.app.ui.page.manageProducts;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.model.MyCategory;
import com.app.model.MyProduct;
import com.app.model.meta.MyMetaProduct;
import com.app.ui.control.MyAddDialog;

public class MyAddProductDialog
    extends MyAddDialog<MyProduct>
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
        MyMetaProduct x = MyProduct.Meta;

        ScDiv body;
        body = getBody();
        body.css().pad();

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
    protected void prepare()
    {
        // none
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyProduct save()
    {
        validate();

        MyProduct e;
        e = getCurrentProject().addProduct();
        e.applyFrom(this);

        flushDao();

        return e;
    }
}
