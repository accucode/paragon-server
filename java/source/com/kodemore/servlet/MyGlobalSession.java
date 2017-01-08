package com.kodemore.servlet;

import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;

/**
 * I maintain variables that are saved in the page session but
 * aren't cleared with the page session.
 */
public class MyGlobalSession
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyGlobalSession instance = new MyGlobalSession();

    //##################################################
    //# variables
    //##################################################

    private ScLocalString               _currentProjectUid;

    //##################################################
    //# constructor
    //##################################################

    public MyGlobalSession()
    {
        _currentProjectUid = new ScLocalString();
        _currentProjectUid.setGlobal();
    }

    //##################################################
    //# project
    //##################################################

    public String getCurrentProjectUid()
    {
        return getCurrentProjectUidWrapper().getValue();
    }

    public void setCurrentProjectUid(String e)
    {
        getCurrentProjectUidWrapper().setValue(e);
    }

    public void clearCurrentProject()
    {
        getCurrentProjectUidWrapper().clearValue();
    }

    public ScLocalString getCurrentProjectUidWrapper()
    {
        return _currentProjectUid;
    }

    public MyProject getCurrentProject()
    {
        String uid = getCurrentProjectUid();
        MyProject p = getAccess().findProjectUid(uid);
        return p;
    }

    public void setCurrentProject(MyProject e)
    {
        if ( e == null )
        {
            clearCurrentProject();
            return;
        }

        setCurrentProjectUid(e.getUid());
    }

    //##################################################
    //# install
    //##################################################

    public void installCurrentProjectFor(MyUser u)
    {
        if ( u == null )
        {
            clearCurrentProject();
            return;
        }

        MyProject p;

        p = u.getLastProject();
        if ( p != null )
            return;

        p = u.getTenant().getProjectsByName().selectFirst(e -> e.isActive());
        if ( p != null )
        {
            setCurrentProject(p);
            return;
        }

        clearCurrentProject();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.instance.getAccess();
    }
}
