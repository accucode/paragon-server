package com.app.ui.page.crud.priority;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyPriority;
import com.app.model.meta.MyMetaPriority;
import com.app.model.support.MyPrioritySequence;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyPriorityEditCard
    extends MyCrudEditCard<MyPriority>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField               _nameField;
    private ScStaticEnumDropdownField _sequenceField;

    //##################################################
    //# constructor
    //##################################################

    public MyPriorityEditCard()
    {
        super(new MyPriorityBuilder());
    }

    public MyPriorityEditCard(MyPriorityBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.add(createNameField());
        fields.add(createSequenceField());
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
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setOptions(MyPrioritySequence.values());
        e.setValueAdaptor(MyPriority.Meta.SequenceCode);
        e.setHelp(MyPriority.Meta.SequenceCode);
        e.setLabel("Sequence");
        e.setRequired();
        e.setNullSelectPrefix();
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

        MyPriority priority = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getPriorityDao().isDuplicateName(priority, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    private void validateSequence()
    {
        ScStaticEnumDropdownField field = _sequenceField;
        if ( field.hasErrors() )
            return;

        MyPriority priority = getDomainChild();
        String sequenceCode = field.getValue();

        boolean dup = getAccess().getPriorityDao().isDuplicateSequence(priority, sequenceCode);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyPriority e)
    {
        e.applyFrom(this);
    }
}
