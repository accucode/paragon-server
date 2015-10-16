package com.app.ui.page.manageCategories;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyProductCategory;
import com.app.model.meta.MyMetaProductCategory;
import com.app.ui.control.MyAddDialog;

public class MyAddProductCategoryDialog
    extends MyAddDialog<MyProductCategory>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Category");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaProductCategory x = MyProductCategory.Meta;

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
    protected MyProductCategory save()
    {
        validate();

        MyProductCategory e;
        e = getCurrentProject().addProductCategory();
        e.applyFrom(this);
        return e;
    }
}
