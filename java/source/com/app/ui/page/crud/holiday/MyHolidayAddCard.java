package com.app.ui.page.crud.holiday;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaHoliday;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyHolidayAddCard
    extends MyCrudAddCard<MyProject,MyHoliday>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyHolidayAddCard()
    {
        super(new MyHolidayBuilder());
    }

    public MyHolidayAddCard(MyHolidayBuilder e)
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
        MyMetaHoliday x = MyHoliday.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createNameField());
        e.addField(x.Day);
        return e;
    }

    private ScTextField createNameField()
    {
        MyMetaHoliday x = MyHoliday.Meta;

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

        boolean dup = getAccess().getHolidayDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyHoliday saveNewChildOn(MyProject project)
    {
        MyHoliday e;
        e = project.addHoliday();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }
}
