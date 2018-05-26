package com.app.ui.page.crud.holiday;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyHolidayCriteria;
import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyHolidaySearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyHoliday,MyHolidayCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyHolidaySearchView(MyCrudBuilder<MyProject,MyHoliday> e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# basic filter
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createNameField());
    }

    private ScControl createNameField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Name");
        e.disableChangeTracking();
        _nameField = e;
        return e;
    }

    //##################################################
    //# extended filter
    //##################################################

    @Override
    protected void installExtendedFieldsOn(ScDiv root)
    {
        // none
    }

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        // none
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyHolidayCriteria createCriteria()
    {
        return getAccess().getHolidayDao().createCriteria();
    }

    @Override
    protected void filter(MyHolidayCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);

        if ( _nameField.hasValue() )
            c.whereName().hasSubstring(_nameField.getValue());
    }

    @Override
    protected void sort(MyHolidayCriteria c)
    {
        c.sortOnName();
        c.sortOnUid();
    }
}
