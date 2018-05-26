package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyCustomer;

/**
 * I define common methods for selectors whose parent is a customer.
 */
public abstract class MyAbstractCustomerSelector<C extends KmUidDomainIF>
    extends MyAbstractSelector<MyCustomer,C>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAbstractCustomerSelector()
    {
        // none
    }

    //##################################################
    //# parent
    //##################################################

    @Override
    protected String getDomainParentName()
    {
        return "Customer";
    }

    @Override
    protected MyCustomer findDomainParent(String uid)
    {
        return getAccess().findCustomerUid(uid);
    }

    public void setCustomer(MyCustomer e)
    {
        setDomainParent(e);
    }

}
