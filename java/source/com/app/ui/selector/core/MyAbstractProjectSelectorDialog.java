package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyProject;

/**
 * I am used by the to dynamically add a new option/type on the fly.
 */
public abstract class MyAbstractProjectSelectorDialog<C extends KmUidDomainIF>
    extends MyAbstractSelectorDialog<MyProject,C>
{
    //##################################################
    //# find
    //##################################################

    @Override
    protected final MyProject findDomainParent(String uid)
    {
        return getAccess().findProjectUid(uid);
    }

}
