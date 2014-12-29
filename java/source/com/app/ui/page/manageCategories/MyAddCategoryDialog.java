package com.app.ui.page.manageCategories;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyCategory;
import com.app.model.meta.MyMetaCategory;
import com.app.ui.control.MyAddDialog;

public class MyAddCategoryDialog
    extends MyAddDialog<MyCategory>
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
        MyMetaCategory x = MyCategory.Meta;

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
    protected MyCategory save()
    {
        validate();

        MyCategory e;
        e = getCurrentProject().addCategory();
        e.applyFrom(this);

        flushDao();

        return e;
    }
}
