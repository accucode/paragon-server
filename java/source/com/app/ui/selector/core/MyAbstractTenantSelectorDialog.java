package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyTenant;

/**
 * I am used by the to dynamically add a new option/type on the fly.
 */
public abstract class MyAbstractTenantSelectorDialog<C extends KmUidDomainIF>
    extends MyAbstractSelectorDialog<MyTenant,C>
{
    //##################################################
    //# find
    //##################################################

    @Override
    protected final MyTenant findDomainParent(String uid)
    {
        return getAccess().findTenantUid(uid);
    }

}
