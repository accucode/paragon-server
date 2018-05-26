package com.app.ui.page.crud.blurb;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyBlurbCriteria;
import com.app.model.MyBlurb;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaBlurb;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyBlurbAddCard
    extends MyCrudAddCard<MyProject,MyBlurb>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyBlurbAddCard()
    {
        super(new MyBlurbBuilder());
    }

    public MyBlurbAddCard(MyBlurbBuilder e)
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

    private ScControl createGeneralSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createNameField());
        e.add(createTypeField());
        e.addText("Additional details are configured on the 'Edit' view.");
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    private ScControl createTypeField()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScDynamicEnumDropdownField e;
        e = x.OwnerTypeCode.newDropdown();
        e.setLabel("Type");
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

        MyBlurbCriteria c;
        c = getAccess().getBlurbDao().createCriteria();
        c.whereProjectIs(project);
        c.whereName().is(name);

        boolean dup = c.exists();
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyBlurb saveNewChildOn(MyProject project)
    {
        MyBlurb e;
        e = project.addBlurb();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }
}
