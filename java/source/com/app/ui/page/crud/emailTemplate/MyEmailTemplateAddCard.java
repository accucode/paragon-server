package com.app.ui.page.crud.emailTemplate;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaEmailTemplate;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyEmailTemplateAddCard
    extends MyCrudAddCard<MyProject,MyEmailTemplate>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateAddCard()
    {
        super(new MyEmailTemplateBuilder());
    }

    public MyEmailTemplateAddCard(MyEmailTemplateBuilder e)
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
        e.add(createTypeField());
        e.addText("Additional details are configured on the 'Edit' view.");
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    private ScControl createTypeField()
    {
        MyMetaEmailTemplate x = MyEmailTemplate.Meta;

        ScDynamicEnumDropdownField e;
        e = x.ContextTypeCode.newDropdown();
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

        boolean dup = getAccess().getEmailTemplateDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyEmailTemplate saveNewChildOn(MyProject project)
    {
        MyEmailTemplate e;
        e = project.addEmailTemplate();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
