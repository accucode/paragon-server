package com.app.ui.page.crud.priority;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaPriority;
import com.app.model.support.MyPrioritySequence;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyPriorityAddCard
    extends MyCrudAddCard<MyProject,MyPriority>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField               _nameField;
    private ScStaticEnumDropdownField _sequenceField;

    //##################################################
    //# constructor
    //##################################################

    public MyPriorityAddCard()
    {
        super(new MyPriorityBuilder());
    }

    public MyPriorityAddCard(MyPriorityBuilder e)
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
        e.add(createSequenceField());
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaPriority x = MyPriority.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    private ScControl createSequenceField()
    {
        MyMetaPriority x = MyPriority.Meta;

        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setOptions(MyPrioritySequence.values());
        e.setMeta(x.SequenceCode);
        _sequenceField = e;
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
        validateSequence();
    }

    private void validateName()
    {
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyProject project = getDomainParent();
        String name = field.getValue();

        boolean dup = getAccess().getPriorityDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateSequence()
    {
        ScStaticEnumDropdownField field = _sequenceField;
        if ( field.hasErrors() )
            return;

        MyProject project = getDomainParent();
        String sequenceCode = field.getValue();

        boolean dup = getAccess().getPriorityDao().isDuplicateSequence(project, sequenceCode);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyPriority saveNewChildOn(MyProject project)
    {
        MyPriority e;
        e = new MyPriority();
        e.setProject(project);
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
