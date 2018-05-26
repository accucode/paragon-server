package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserRecentProjectBase;
import com.app.model.core.MyTenantDomainIF;

public class MyUserRecentProject
    extends MyUserRecentProjectBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserRecentProject()
    {
        super();
    }

    public MyUserRecentProject(MyUser user, MyProject project)
    {
        super();
        setUser(user);
        setProject(project);
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getUser().getTenant();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getDomainTitle();
    }

    @Override
    public String getDomainTitle()
    {
        return Kmu.format(
            "%s %s %s",
            getUser().getFullName(),
            getProject().getName(),
            getCreatedLocalTsMessage());
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }
}
