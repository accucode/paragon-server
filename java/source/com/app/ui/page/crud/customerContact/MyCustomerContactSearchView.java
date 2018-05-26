package com.app.ui.page.crud.customerContact;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;

import com.app.criteria.MyCustomerContactCriteria;
import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public class MyCustomerContactSearchView
    extends MyCrudGeneralCriteriaSearchView<MyCustomer,MyCustomerContact,MyCustomerContactCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactSearchView(MyCrudBuilder<MyCustomer,MyCustomerContact> e)
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
    protected MyCustomerContactCriteria createCriteria()
    {
        return getAccess().getCustomerContactDao().createCriteria();
    }

    @Override
    protected void filter(MyCustomerContactCriteria c)
    {
        MyCustomer customer = getDomainParent();
        c.whereCustomerIs(customer);
    }

    @Override
    protected void sort(MyCustomerContactCriteria c)
    {
        c.sortOnFullName();
    }
}
