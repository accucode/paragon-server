package com.app.ui.page.manageCategories;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyCategory;
import com.app.model.meta.MyMetaCategory;
import com.app.ui.control.MyEditDialog;

public class MyEditCategoryDialog
    extends MyEditDialog<MyCategory>
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
        MyMetaCategory x = MyCategory.Meta;

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
    protected void prepare(MyCategory e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyCategory save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyCategory e;
        e = getAccess().findCategoryUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
