package com.app.ui.page.crud.projectContact;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

import com.app.criteria.MyProjectContactCriteria;
import com.app.model.MyProject;
import com.app.model.MyProjectContact;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public class MyProjectContactSearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyProjectContact,MyProjectContactCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactSearchView(MyCrudBuilder<MyProject,MyProjectContact> e)
    {
        super(e);
    }

    //##################################################
    //# fields
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        // none
    }

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
    protected MyProjectContactCriteria createCriteria()
    {
        return getAccess().getProjectContactDao().createCriteria();
    }

    @Override
    protected void filter(MyProjectContactCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);
    }

    @Override
    protected void sort(MyProjectContactCriteria c)
    {
        c.sortOnFullName();
    }
}
