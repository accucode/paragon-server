package com.app.ui.page.crud.priority;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyPriorityCriteria;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyPrioritySearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyPriority,MyPriorityCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyPrioritySearchView(MyCrudBuilder<MyProject,MyPriority> e)
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
    protected MyPriorityCriteria createCriteria()
    {
        return getAccess().getPriorityDao().createCriteria();
    }

    @Override
    protected void filter(MyPriorityCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);

        if ( _nameField.hasValue() )
            c.whereName().hasSubstring(_nameField.getValue());
    }

    @Override
    protected void sort(MyPriorityCriteria c)
    {
        c.sortOnSequenceCode();
        c.sortOnName();
    }
}
