package com.app.model;

import com.app.model.base.MyOptimisticLockBase;
import com.app.model.core.MySystemDomainIF;

public class MyOptimisticLock
    extends MyOptimisticLockBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyOptimisticLock()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public void touch()
    {
        int next = hasLockVersion()
            ? getLockVersion() + 1
            : 1;

        setLockVersion(next);
    }
    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return getName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

}
