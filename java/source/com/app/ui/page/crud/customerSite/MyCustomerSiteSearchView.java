package com.app.ui.page.crud.customerSite;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

import com.app.criteria.MySiteCriteria;
import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public class MyCustomerSiteSearchView
    extends MyCrudGeneralCriteriaSearchView<MyCustomer,MySite,MySiteCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteSearchView(MyCrudBuilder<MyCustomer,MySite> e)
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
    protected MySiteCriteria createCriteria()
    {
        return getAccess().getSiteDao().createCriteria();
    }

    @Override
    protected void filter(MySiteCriteria c)
    {
        MyCustomer customer = getDomainParent();
        c.whereCustomerIs(customer);
    }

    @Override
    protected void sort(MySiteCriteria c)
    {
        c.sortOnName();
    }
}
