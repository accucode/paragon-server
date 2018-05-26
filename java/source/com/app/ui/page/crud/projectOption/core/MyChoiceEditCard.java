package com.app.ui.page.crud.projectOption.core;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyChoice;
import com.app.model.meta.MyMetaChoice;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyChoiceEditCard
    extends MyCrudEditCard<MyChoice>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyChoiceEditCard(MyChoiceBuilder e)
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
        root.css().columnSpacer20();
        root.add(createGeneralFields());
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScFieldset createGeneralFields()
    {
        ScFieldset set;
        set = new ScFieldset();
        set.setLabel("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createNameField());

        return set;
    }

    private ScTextField createNameField()
    {
        MyMetaChoice x = MyChoice.Meta;

        ScTextField e;
        e = x.Name.newField();
        e.setWidthFull();
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

        MyChoice option = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getChoiceDao().isDuplicateName(option, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyChoice e)
    {
        e.applyFrom(this);
    }

}
