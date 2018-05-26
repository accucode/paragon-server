package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyProject;

/**
 * I define common methods for selectors whose parent is a project.
 */
public abstract class MyAbstractProjectSelector<C extends KmUidDomainIF>
    extends MyAbstractSelector<MyProject,C>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAbstractProjectSelector()
    {
        // none
    }

    //##################################################
    //# parent
    //##################################################

    @Override
    protected String getDomainParentName()
    {
        return "Project";
    }

    @Override
    protected MyProject findDomainParent(String uid)
    {
        return getAccess().findProjectUid(uid);
    }

    public void setProject(MyProject e)
    {
        setDomainParent(e);
    }

}
