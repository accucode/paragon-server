package com.app.ui.page.manageCategories;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyProductCategory;
import com.app.model.meta.MyMetaProductCategory;
import com.app.ui.control.MyEditDialog;

public class MyEditProductCategoryDialog
    extends MyEditDialog<MyProductCategory>
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

        setLabel("EDIT Category");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaProductCategory x = MyProductCategory.Meta;

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
    protected void prepare(MyProductCategory e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyProductCategory save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyProductCategory e;
        e = getAccess().findProductCategoryUid(uid);
        e.applyFrom(this);
        return e;
    }
}
