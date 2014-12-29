package com.app.model;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyServerSessionBase;
import com.app.utility.MyConstantsIF;

public class MyServerSession
    extends MyServerSessionBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSession()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public void close()
    {
        setActive(false);
        setClosedUtcTs(getNowUtc());
    }

    public void touch()
    {
        setLastTouchedUtcTs(getNowUtc());
    }

    public boolean isFresh()
    {
        return !isStale();
    }

    public boolean isStale()
    {
        if ( isNotActive() )
            return true;

        if ( hasWrongVersion() )
            return true;

        int timeout = getTimeoutSeconds();
        KmTimestamp lastTouch = getLastTouchedUtcTs();
        KmTimestamp limit = lastTouch.addSeconds(timeout);
        boolean isPast = getNowUtc().isAfter(limit);
        return isPast;
    }

    private int getTimeoutSeconds()
    {
        return getProperties().getServerSessionTimeoutSeconds();
    }

    private boolean hasRightVersion()
    {
        return Kmu.isEqual(getVersion(), MyConstantsIF.APPLICATION_VERSION);
    }

    private boolean hasWrongVersion()
    {
        return !hasRightVersion();
    }

    //##################################################
    //# current project
    //##################################################

    @Override
    public void setCurrentProject(MyProject e)
    {
        super.setCurrentProject(e);

        if ( hasUser() )
            getUser().setLastProject(e);
    }

    public void installCurrentProject()
    {
        MyUser u = getUser();

        if ( u == null )
        {
            clearCurrentProject();
            return;
        }

        MyProject p;

        p = getCurrentProject();
        if ( p != null )
            if ( p.allowsMember(u) )
            {
                setCurrentProject(p);
                return;
            }

        p = u.getLastProject();
        if ( p != null )
            if ( p.allowsMember(u) )
            {
                setCurrentProject(p);
                return;
            }

        MyMember m = getAccess().getMemberDao().findFirstFor(u);
        if ( m != null )
        {
            setCurrentProject(m.getProject());
            return;
        }

        p = getAccess().getProjectDao().findFirst();
        if ( p != null )
        {
            setCurrentProject(p);
            return;
        }

        clearCurrentProject();
    }

}
