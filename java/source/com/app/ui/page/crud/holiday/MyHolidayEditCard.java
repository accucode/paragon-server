package com.app.ui.page.crud.holiday;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyHoliday;
import com.app.model.meta.MyMetaHoliday;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyHolidayEditCard
    extends MyCrudEditCard<MyHoliday>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyHolidayEditCard()
    {
        super(new MyHolidayBuilder());
    }

    public MyHolidayEditCard(MyHolidayBuilder e)
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
        root.css().gap20();

        installGeneralOn(root);
    }

    private void installGeneralOn(ScDiv root)
    {
        MyMetaHoliday x = MyHoliday.Meta;

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFullWidthFieldTable();
        fields.css().widthFull();
        fields.add(createNameField());
        fields.addField(x.Day);
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

        MyHoliday holiday = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getHolidayDao().isDuplicateName(holiday, name);
        if ( dup )
            field.addError("Duplicate");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyHoliday e)
    {
        e.applyFrom(this);
    }

}
