package com.app.ui.page.manageProjects;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;

import com.app.model.MyProject;
import com.app.model.meta.MyMetaProject;
import com.app.ui.control.MyAddDialog;

public class MyAddProjectDialog
    extends MyAddDialog<MyProject>
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("ADD Project");
        setWidth(400);
        installFields();
    }

    private void installFields()
    {
        MyMetaProject x = MyProject.Meta;

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
    protected MyProject save()
    {
        validate();

        MyProject e;
        e = new MyProject();
        e.applyFrom(this);
        e.attachDao();
        return e;
    }
}
