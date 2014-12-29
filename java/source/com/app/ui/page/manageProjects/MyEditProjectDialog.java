package com.app.ui.page.manageProjects;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyEditDialog;

public class MyEditProjectDialog
    extends MyEditDialog<MyProject>
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

        setLabel("EDIT Project");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaProject x = MyProject.Meta;

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
    protected void prepare(MyProject e)
    {
        applyFromModel(e);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyProject save()
    {
        validate();

        String uid;
        uid = _uidField.getValue();

        MyProject e;
        e = getAccess().findProjectUid(uid);
        e.applyFrom(this);
        e.validate();

        flushDao();

        return e;
    }
}
