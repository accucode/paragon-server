package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyCustomer;

/**
 * I am used by the to dynamically add a new option/type on the fly.
 */
public abstract class MyAbstractCustomerSelectorDialog<C extends KmUidDomainIF>
    extends MyAbstractSelectorDialog<MyCustomer,C>
{
    //##################################################
    //# find
    //##################################################

    @Override
    protected final MyCustomer findDomainParent(String uid)
    {
        return getAccess().findCustomerUid(uid);
    }

}
