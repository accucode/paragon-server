package com.app.ui.page.crud.projectVendor;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyProject;
import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyVendorAddCard
    extends MyCrudAddCard<MyProject,MyVendor>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyVendorAddCard()
    {
        super(new MyVendorBuilder());
    }

    public MyVendorAddCard(MyVendorBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.add(createLayout());
    }

    private ScControl createLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createNameField());
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaVendor x = MyVendor.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateName();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyProject project = getDomainParent();
        String name = field.getValue();

        boolean dup = getAccess().getVendorDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyVendor saveNewChildOn(MyProject project)
    {
        MyVendor e;
        e = project.addVendor();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
