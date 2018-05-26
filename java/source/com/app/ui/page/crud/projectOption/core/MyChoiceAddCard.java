package com.app.ui.page.crud.projectOption.core;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyChoice;
import com.app.model.MyProject;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaChoice;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyChoiceAddCard
    extends MyCrudAddCard<MyProject,MyChoice>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyChoiceAddCard(MyChoiceBuilder e)
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
        MyMetaChoice x = MyChoice.Meta;

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
        MyChoiceType type = getType();
        String name = field.getValue();

        boolean dup = getAccess().getChoiceDao().isDuplicateName(project, type, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyChoice saveNewChildOn(MyProject project)
    {
        MyChoice e;
        e = new MyChoice();
        e.setProject(project);
        e.setType(getType());
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected MyChoiceBuilder getCrudBuilder()
    {
        return (MyChoiceBuilder)super.getCrudBuilder();
    }

    private MyChoiceType getType()
    {
        return getCrudBuilder().getType();
    }
}
